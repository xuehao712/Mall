package com.shawn.mall.demo.config;

import com.shawn.mall.demo.bo.AdminUserDetails;
import com.shawn.mall.mapper.UmsAdminMapper;
import com.shawn.mall.model.UmsAdmin;
import com.shawn.mall.model.UmsAdminExample;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;

import java.util.List;

/**
 * Spring Security config
 */
@Configuration
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {
    @Autowired
    private UmsAdminMapper umsAdminMapper;

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.anonymous().disable()
                .authorizeRequests()
                .antMatchers("/**")
                .permitAll()
                .and()
                .authorizeRequests()
                .anyRequest().authenticated()
                .and()//login page
                .formLogin()
                .loginPage("/login")
                .permitAll()
                .failureUrl("/login?error=true")
                .and()//config exist url
                .logout()
                .logoutRequestMatcher(new AntPathRequestMatcher("/logout"))
                .clearAuthentication(true)
                .invalidateHttpSession(true)
                .logoutSuccessUrl("/")
                .and()//remember password
                .rememberMe()
                .tokenValiditySeconds(60*60*24)
                .key("rememberMeKey")
                .and()//close csrf
                .headers()//remove x-frame-options
                .frameOptions()
                .deny()
                .and()
                .csrf()
                .disable()
                .sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS);
    }

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.userDetailsService(userDetailsService()).passwordEncoder(new BCryptPasswordEncoder());
    }

    @Bean
    public UserDetailsService userDetailsService() {
        //Get login user info
        return new UserDetailsService() {
            @Override
            public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
                UmsAdminExample example = new UmsAdminExample();
                example.createCriteria().andUsernameEqualTo(username);
                List<UmsAdmin> umsAdminList = umsAdminMapper.selectByExample(example);
                if(umsAdminList !=null && umsAdminList.size()>0){
                    return new AdminUserDetails(umsAdminList.get(0));
                }
                throw new UsernameNotFoundException("Username is incorrect");
            }
        };
    }
}
