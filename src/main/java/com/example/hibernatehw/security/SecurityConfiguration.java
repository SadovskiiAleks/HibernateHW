package com.example.hibernatehw.security;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.configuration.EnableGlobalAuthentication;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.method.configuration.EnableMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

import java.util.ArrayList;
import java.util.List;

import static org.springframework.security.config.Customizer.withDefaults;

@Configuration
@EnableGlobalMethodSecurity(
        prePostEnabled = true,
        securedEnabled = true,
        jsr250Enabled = true)
public class SecurityConfiguration {
    @Bean
    public InMemoryUserDetailsManager userDetailsService() {
        UserDetails user = User.withDefaultPasswordEncoder()
                .username("userOne")
                .password("password")
                .roles("READ")
                .build();
        UserDetails user2 = User.withDefaultPasswordEncoder()
                .username("userTwo")
                .password("password")
                .roles("WRITE")
                .build();
        UserDetails user3 = User.withDefaultPasswordEncoder()
                .username("userTree")
                .password("password")
                .roles("DELETE")
                .build();
        UserDetails user4 = User.withDefaultPasswordEncoder()
                .username("userFourth")
                .password("password")
                .roles("DELETE")
                .build();
        List<UserDetails> userDetailsList = new ArrayList<>();
        userDetailsList.add(user);
        userDetailsList.add(user2);
        userDetailsList.add(user3);
        userDetailsList.add(user4);
        return new InMemoryUserDetailsManager(userDetailsList);
    }

    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
        http
                .authorizeHttpRequests((authz) -> authz
                        .requestMatchers("persons/userName*").permitAll()
                        .requestMatchers("persons/by-city*").authenticated()
                        //.anyRequest().hasAnyRole()
                )
                .formLogin(withDefaults());
        return http.build();
    }
}
