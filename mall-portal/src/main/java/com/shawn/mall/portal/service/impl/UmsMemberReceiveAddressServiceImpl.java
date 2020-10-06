package com.shawn.mall.portal.service.impl;

import com.shawn.mall.mapper.UmsMemberReceiveAddressMapper;
import com.shawn.mall.model.UmsMember;
import com.shawn.mall.model.UmsMemberReceiveAddress;
import com.shawn.mall.model.UmsMemberReceiveAddressExample;
import com.shawn.mall.portal.service.UmsMemberReceiveAddressService;
import com.shawn.mall.portal.service.UmsMemberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import java.util.List;

/**
 * Member address service impl
 */
@Service
public class UmsMemberReceiveAddressServiceImpl implements UmsMemberReceiveAddressService {
    @Autowired
    private UmsMemberService memberService;
    @Autowired
    private UmsMemberReceiveAddressMapper addressMapper;

    @Override
    public int add(UmsMemberReceiveAddress address) {
        UmsMember currentMember = memberService.getCurrentMember();
        address.setMemberId(currentMember.getId());
        return addressMapper.insert(address);
    }

    @Override
    public int delete(Long id) {
        UmsMember member = memberService.getCurrentMember();
        UmsMemberReceiveAddressExample example = new UmsMemberReceiveAddressExample();
        example.createCriteria().andMemberIdEqualTo(member.getId()).andIdEqualTo(id);
        return addressMapper.deleteByExample(example);
    }

    @Override
    public int update(Long id,UmsMemberReceiveAddress address) {
        address.setId(null);
        UmsMember member = memberService.getCurrentMember();
        UmsMemberReceiveAddressExample example = new UmsMemberReceiveAddressExample();
        example.createCriteria().andMemberIdEqualTo(member.getId()).andIdEqualTo(id);
        if(address.getDefaultStatus() == 1){
            //Remove default address
            UmsMemberReceiveAddress record = new UmsMemberReceiveAddress();
            record.setDefaultStatus(0);
            UmsMemberReceiveAddressExample updateExample = new UmsMemberReceiveAddressExample();
            updateExample.createCriteria()
                    .andMemberIdEqualTo(member.getId())
                    .andDefaultStatusEqualTo(1);
            addressMapper.updateByExampleSelective(address,example);
        }
        return addressMapper.updateByExampleSelective(address,example);
    }

    @Override
    public List<UmsMemberReceiveAddress> list() {
        UmsMember currentMember = memberService.getCurrentMember();
        UmsMemberReceiveAddressExample example = new UmsMemberReceiveAddressExample();
        example.createCriteria().andMemberIdEqualTo(currentMember.getId());
        return addressMapper.selectByExample(example);
    }

    @Override
    public UmsMemberReceiveAddress getItem(Long id) {
        UmsMember currentMember = memberService.getCurrentMember();
        UmsMemberReceiveAddressExample example = new UmsMemberReceiveAddressExample();
        example.createCriteria().andMemberIdEqualTo(currentMember.getId()).andIdEqualTo(id);
        List<UmsMemberReceiveAddress> addressList = addressMapper.selectByExample(example);
        if(!CollectionUtils.isEmpty(addressList)){
            return addressList.get(0);
        }
        return null;
    }
}
