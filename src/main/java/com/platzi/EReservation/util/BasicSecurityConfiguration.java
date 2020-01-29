/**
 * 
 */
package com.platzi.EReservation.util;

import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.factory.PasswordEncoderFactories;
import org.springframework.security.crypto.password.PasswordEncoder;

/**
 * @author yojan
 *
 */

@Configuration
@EnableWebSecurity
public class BasicSecurityConfiguration extends WebSecurityConfigurerAdapter{
	
	protected void configure(HttpSecurity httpSecurity) throws Exception {
        httpSecurity.csrf().disable()
            .authorizeRequests()
            .anyRequest()
            .authenticated()
            .and().formLogin()
                .loginPage("/app/login").permitAll()
                .failureUrl("/app/login?error=true")
                .defaultSuccessUrl("/app/home");
    }

    @Override
    protected void configure(AuthenticationManagerBuilder builder) throws Exception {
        PasswordEncoder encoder = PasswordEncoderFactories.createDelegatingPasswordEncoder();
                builder.inMemoryAuthentication()
                        .withUser("yojan")
                        .password(encoder.encode("platzi"))
                        .roles("USER");
    }

    @Override
    public void configure(WebSecurity security) {
        security.ignoring()
                .antMatchers("/resources/**", "/static/**", "/css/**", "/js/**", "/images/**");
    }
}
