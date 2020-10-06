package com.shawn.mall.demo.bo;

import com.shawn.mall.model.UmsAdmin;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Arrays;
import java.util.Collection;

/**
 * SpringSecurity user details
 */
public class AdminUserDetails implements UserDetails {
    private UmsAdmin umsAdmin;

    public AdminUserDetails (UmsAdmin umsAdmin) {
        this.umsAdmin = umsAdmin;
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        //Return current user authority
        return Arrays.asList(new SimpleGrantedAuthority("Test"));
    }

    @Override
    public String getPassword() {
        return umsAdmin.getPassword();
    }

    @Override
    public String getUsername() {
        return umsAdmin.getUsername();
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return true;
    }
}
