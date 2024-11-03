package com.example.next_project.global.security;

import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.header.writers.frameoptions.XFrameOptionsHeaderWriter;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;

@Configuration
@EnableWebSecurity
@RequiredArgsConstructor
public class ApiSecurityConfig {

    @Bean
    SecurityFilterChain apiFilterChain(HttpSecurity http) throws Exception {
        http
            .securityMatcher("/api/**")
            .authorizeHttpRequests(
                authorizeHttpRequests -> authorizeHttpRequests
//                  .requestMatchers("/api/*/members/login", "/api/*/members/logout").permitAll()
                  .requestMatchers("/api/*/articles").permitAll()
                  .anyRequest().authenticated()
            )
            .csrf(
                csrf -> csrf
                  .disable()
            );
        return http.build();
    }

}
