package com.shawn.mall.security.util;

import cn.hutool.core.date.DateUtil;
import cn.hutool.core.util.StrUtil;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.core.userdetails.UserDetails;

import javax.xml.crypto.Data;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * JwtToken generator tool
 * JWT token format：header.payload.signature
 * header format（algorithm、token type）：
 * {"alg": "HS512","typ": "JWT"}
 * payload format（username、created date、expiration time）：
 * {"sub":"wang","created":1489079981393,"exp":1489684781}
 * signature algo：
 * HMACSHA512(base64UrlEncode(header) + "." +base64UrlEncode(payload),secret)
 * Created by macro on 2018/4/26.
 */
public class JwtTokenUtil {
    private static final Logger LOGGER = LoggerFactory.getLogger(JwtTokenUtil.class);
    private static final String CLAIM_KEY_USERNAME = "sub";
    private static final String CLAIM_KEY_CREATED = "created";
    @Value("${jwt.secret}")
    private String secret;
    @Value("${jwt.expiration}")
    private Long expiration;
    @Value("${jwt.tokenHead}")
    private String tokenHead;

    /**
     * JWT token generator
     */
    private String generateToken(Map<String,Object> claims){
        return Jwts.builder()
                .setClaims(claims)
                .setExpiration(generateExpirationDate())
                .signWith(SignatureAlgorithm.HS512,secret)
                .compact();
    }

    /**
     * get JWT claim from token
     */
    private Claims getClaimsFromToken(String token){
        Claims claims = null;
        try{
            claims = Jwts.parser()
                    .setSigningKey(secret)
                    .parseClaimsJws(token)
                    .getBody();
        } catch (Exception e){
            LOGGER.info("JWT format validation fail:{}",token);
        }
        return claims;
    }

    /**
     * Generate token expiration time
     */
    private Date generateExpirationDate(){
        return new Date(System.currentTimeMillis() + expiration*1000);
    }

    /**
     * Get username from token
     */
    public String getUserNameFromToken(String token){
        String username;
        try{
            Claims claims = getClaimsFromToken(token);
            username = claims.getSubject();
        } catch (Exception e){
            username =null;
        }
        return username;
    }

    /**
     * Validation token
     * @param token       client side token
     * @param userDetails user details from database
     */
    public boolean validateToken(String token, UserDetails userDetails){
        String username = getUserNameFromToken(token);
        return username.equals(userDetails.getUsername()) && !isTokenExpired(token);
    }

    /**
     * Check if token expire
     */
    private boolean isTokenExpired(String token){
        Date expirateDate = getExpiredDateFromToken(token);
        return expirateDate.before(new Date());
    }

    /**
     * Get expiration date from token
     */
    private Date getExpiredDateFromToken(String token){
        Claims claims = getClaimsFromToken(token);
        return claims.getExpiration();
    }

    /**
     * Generate token base on user info
     */
    public String generateToken(UserDetails userDetails){
        Map<String,Object> claims = new HashMap<>();
        claims.put(CLAIM_KEY_USERNAME,userDetails.getUsername());
        claims.put(CLAIM_KEY_CREATED,new Date());
        return generateToken(claims);
    }

    /**
     * Refresh if token not expired
     * @param oldToken tokenHead token
     */
    public String refreshHeadToken(String oldToken){
        if(StrUtil.isEmpty(oldToken)){
            return null;
        }
        String token =oldToken.substring(tokenHead.length());
        if(StrUtil.isEmpty(token)){
            return null;
        }
        //token validation fail
        Claims claims = getClaimsFromToken(token);
        if (claims==null){
            return null;
        }
        //if token is expired, cannot refresh
        if(isTokenExpired(token)){
            return null;
        }
        //if token just refresh within 30 minutes, return original token
        if(tokenRefreshJustBefore(token,30*60)){
            return token;
        }else{
            claims.put(CLAIM_KEY_CREATED,new Date());
            return generateToken(claims);
        }
    }

    /**
     * Tell if token just refresh
     * @param token
     * @param time second
     */
    private boolean tokenRefreshJustBefore(String token,int time){
        Claims claims = getClaimsFromToken(token);
        Date created = claims.get(CLAIM_KEY_CREATED,Date.class);
        Date refreshDate = new Date();
        if(refreshDate.after(created) && refreshDate.before(DateUtil.offsetSecond(created,time))){
            return true;
        }
        return false;
    }
}
