package com.code4life.ecommerce.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.env.Environment;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

import java.util.Arrays;
import java.util.List;

@Configuration
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {

    @Autowired
    private Environment environment;

    public static final String[] PUBLIC_MATCHERS = {

            "/",
            "/product",
            "/users"

    };

    @Override
    protected void configure(HttpSecurity http) throws Exception {

        List<String> activeProfiles = Arrays.asList(environment.getActiveProfiles());

        activeProfiles.forEach(activeProfile -> {

            if (activeProfile.equals("dev")) {

                try {
                    http
                            .headers().frameOptions().disable();
                    http
                            .cors().disable().csrf().disable();

                } catch (Exception e) {
                    e.printStackTrace();
                }


            }

        });

        http
                .authorizeRequests().antMatchers(PUBLIC_MATCHERS).permitAll()
                .anyRequest().authenticated()
                .and()
                .formLogin().defaultSuccessUrl("/user")
                .failureUrl("/login?error");

    }

    @Autowired
    protected void configureGlobal(AuthenticationManagerBuilder auth) throws Exception {
        auth
                .inMemoryAuthentication()
                .withUser("user")
                .password("password")
                .roles("USER_ROLE");
    }
}
