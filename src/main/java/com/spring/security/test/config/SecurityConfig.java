package com.spring.security.test.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.method.configuration.EnableMethodSecurity;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;

@Configuration
@EnableMethodSecurity
public class SecurityConfig {

    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

    @Bean
    public UserDetailsService userDetailsService() {

        UserDetails normalUser = User
                               .withUsername("mahesh")
                               .password(passwordEncoder().encode("mahesh"))
                               .roles("NORMAL")
                               .build();

        UserDetails adminUser = User
                .withUsername("nikhil")
                .password(passwordEncoder().encode("nikhil"))
                .roles("ADMIN")
                .build();

        UserDetails publicUser = User
                .withUsername("pavan")
                .password(passwordEncoder().encode("pavan"))
                .roles("PUBLIC")
                .build();        
        
                
        InMemoryUserDetailsManager inMemoryUserDetailsManager = new InMemoryUserDetailsManager(normalUser, adminUser, publicUser);
        return inMemoryUserDetailsManager;

    }
}
