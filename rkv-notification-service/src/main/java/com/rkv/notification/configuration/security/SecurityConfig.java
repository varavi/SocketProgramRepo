package com.rkv.notification.configuration.security;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity

public class SecurityConfig {

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        http.
             authorizeHttpRequests()
                .requestMatchers("/","/ws/**").
                permitAll().
                and().
                authorizeHttpRequests()
                .anyRequest().authenticated().
                and().
                formLogin().and().logout(logout->logout.logoutSuccessUrl("/"));
        return http.build();
    }

    @Bean
    public UserDetailsService userDetailsService() {
        // I am using build-in user so
        UserDetails user = User.withDefaultPasswordEncoder().
                username("test").password("test").roles("USER").build();
        UserDetails rkuser = User.withDefaultPasswordEncoder().
                username("test1").password("test1").roles("USER").build();

        return new InMemoryUserDetailsManager(user,rkuser);
    }
}
