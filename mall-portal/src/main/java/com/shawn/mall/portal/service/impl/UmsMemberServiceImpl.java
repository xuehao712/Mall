package com.shawn.mall.portal.service.impl;

import com.shawn.mall.common.exception.Asserts;
import com.shawn.mall.mapper.UmsMemberLevelMapper;
import com.shawn.mall.mapper.UmsMemberMapper;
import com.shawn.mall.model.UmsMember;
import com.shawn.mall.model.UmsMemberExample;
import com.shawn.mall.model.UmsMemberLevel;
import com.shawn.mall.model.UmsMemberLevelExample;
import com.shawn.mall.portal.domain.MemberDetails;
import com.shawn.mall.portal.service.UmsMemberCacheService;
import com.shawn.mall.portal.service.UmsMemberService;
import com.shawn.mall.security.util.JwtTokenUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.context.SecurityContext;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;
import org.springframework.util.StringUtils;

import java.util.Date;
import java.util.List;
import java.util.Random;

/**
 * Member service impl
 */
@Service
public class UmsMemberServiceImpl implements UmsMemberService {
    private static final Logger LOGGER = LoggerFactory.getLogger(UmsMemberServiceImpl.class);
    @Autowired
    private PasswordEncoder passwordEncoder;
    @Autowired
    private JwtTokenUtil jwtTokenUtil;
    @Autowired
    private UmsMemberMapper memberMapper;
    @Autowired
    private UmsMemberLevelMapper memberLevelMapper;
    @Autowired
    private UmsMemberCacheService memberCacheService;
    @Value("${redis.key.authCode}")
    private String REDIS_KEY_PREFIX_AUTH_CODE;
    @Value("${redis.expire.authCode}")
    private Long AUTH_CODE_EXPIRE_SECONDS;

    @Override
    public UmsMember getByUsername(String username) {
        UmsMember member = memberCacheService.getMember(username);
        if(member!=null) {
            return member;
        }
        UmsMemberExample example = new UmsMemberExample();
        example.createCriteria().andUsernameEqualTo(username);
        List<UmsMember> memberList = memberMapper.selectByExample(example);
        if(!CollectionUtils.isEmpty(memberList)){
            member = memberList.get(0);
            memberCacheService.setMember(member);
            return member;
        }
        return null;
    }

    @Override
    public UmsMember getById(Long id) {
        return memberMapper.selectByPrimaryKey(id);
    }

    @Override
    public void register(String username,String password,String email,String authCode){
        //Verify auth
        if(!verifyAuthCode(authCode,email)){
            Asserts.fail("Auth Code is incorrect");
        }
        //Check if user exist
        UmsMemberExample memberExample = new UmsMemberExample();
        memberExample.createCriteria().andUsernameEqualTo(username);
        memberExample.or(memberExample.createCriteria().andEmailEqualTo(email));
        List<UmsMember> umsMembers = memberMapper.selectByExample(memberExample);
        if(!CollectionUtils.isEmpty(umsMembers)){
            Asserts.fail("User already exists");
        }
        //Add when there is no existing user
        UmsMember umsMember = new UmsMember();
        umsMember.setUsername(username);
        umsMember.setEmail(email);
        umsMember.setPassword(passwordEncoder.encode(password));
        umsMember.setCreateTime(new Date());
        umsMember.setStatus(1);
        //Get default member level
        UmsMemberLevelExample levelExample = new UmsMemberLevelExample();
        levelExample.createCriteria().andDefaultStatusEqualTo(1);
        List<UmsMemberLevel> memberLevelList = memberLevelMapper.selectByExample(levelExample);
        if(!CollectionUtils.isEmpty(memberLevelList)){
            umsMember.setMemberLevelId(memberLevelList.get(0).getId());
        }
        memberMapper.insert(umsMember);
        umsMember.setPassword(null);
    }

    @Override
    public String generateAuthCode(String email){
        StringBuilder sb = new StringBuilder();
        Random random = new Random();
        for(int i =0;i<6;i++){
            sb.append(random.nextInt(10));
        }
        memberCacheService.setAuthCode(email,sb.toString());
        return sb.toString();
    }

    @Override
    public void updatePassword(String email,String password,String authCode) {
        UmsMemberExample example = new UmsMemberExample();
        example.createCriteria().andEmailEqualTo(email);
        List<UmsMember> memberList = memberMapper.selectByExample(example);
        if(CollectionUtils.isEmpty(memberList)){
            Asserts.fail("Account is not exist!");
        }
        //Verify
        if(!verifyAuthCode(authCode,email)){
            Asserts.fail("Auth code is incorrect!");
        }
        UmsMember umsMember = memberList.get(0);
        umsMember.setPassword(passwordEncoder.encode(password));
        memberMapper.updateByPrimaryKeySelective(umsMember);
        memberCacheService.delMember(umsMember.getId());
    }

    @Override
    public UmsMember getCurrentMember() {
        SecurityContext context = SecurityContextHolder.getContext();
        Authentication authentication = context.getAuthentication();
        MemberDetails memberDetails = (MemberDetails) authentication.getPrincipal();
        return memberDetails.getUmsMember();
    }

    @Override
    public void updateIntegration(Long id, Integer integration) {
        UmsMember record=new UmsMember();
        record.setId(id);
        record.setIntegration(integration);
        memberMapper.updateByPrimaryKeySelective(record);
        memberCacheService.delMember(id);
    }

    @Override
    public UserDetails loadUserByUsername(String username) {
        UmsMember member = getByUsername(username);
        if(member!=null){
            return new MemberDetails(member);
        }
        throw new UsernameNotFoundException("Username or password is incorrect!");
    }

    @Override
    public String login(String username,String password) {
        String token = null;
        try {
            UserDetails userDetails = loadUserByUsername(username);
            if(!passwordEncoder.matches(password,userDetails.getPassword())){
                throw new BadCredentialsException("Password is incorrect!");
            }
            UsernamePasswordAuthenticationToken authenticationToken = new UsernamePasswordAuthenticationToken(userDetails, null, userDetails.getAuthorities());
            SecurityContextHolder.getContext().setAuthentication(authenticationToken);
            token = jwtTokenUtil.generateToken(userDetails);
        } catch (AuthenticationException e) {
            LOGGER.warn("Login failed:{}",e.getMessage());
        }
        return token;
    }

    @Override
    public String refreshToken(String token) {
        return jwtTokenUtil.refreshHeadToken(token);
    }

    private boolean verifyAuthCode(String authCode,String email) {
        if(StringUtils.isEmpty(authCode)){
            return false;
        }
        String realAuthCode = memberCacheService.getAuthCode(email);
        return authCode.equals(realAuthCode);
    }
}
