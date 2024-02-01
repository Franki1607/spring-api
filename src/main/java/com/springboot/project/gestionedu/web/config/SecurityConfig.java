package com.springboot.project.gestionedu.web.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.authentication.configuration.AuthenticationConfiguration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
public class SecurityConfig {
    @Bean
    public static PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }
    @Bean
    public AuthenticationManager authenticationManager(AuthenticationConfiguration configuration) throws Exception {
        return configuration.getAuthenticationManager();
    }

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        http.authorizeHttpRequests(request ->
                        request
                                .requestMatchers("/api/v1/studentnotes/all").hasRole("ADMIN")
                                .requestMatchers("/api/v1/studentnotes/create").hasAnyRole("ADMIN", "USER")
                                .requestMatchers("/api/v1/studentnotes/update/{id}").hasAnyRole("ADMIN", "USER")
                                .requestMatchers("/api/v1/studentnotes/delete/{id}").hasAnyRole("ADMIN", "USER")
                                .requestMatchers("/api/v1/studentnotes/get/{id}").hasAnyRole("ADMIN", "USER")
                                .requestMatchers("/api/v1/users/signup").permitAll()
                                .requestMatchers("/api/v1/users/login").permitAll()
                                .anyRequest().authenticated())
                .httpBasic(Customizer.withDefaults())
                .formLogin(Customizer.withDefaults())
                .csrf(csrf -> csrf.disable());
        return http.build();
    }
}