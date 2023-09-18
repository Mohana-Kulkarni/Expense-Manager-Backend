package com.example.expensemanager.security;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
public class SecurityConfig {

//    @Bean
//    public PasswordEncoder passwordEncoder() {
//        return new BCryptPasswordEncoder();
//    }

    @Bean
    SecurityFilterChain securityFilterChain(HttpSecurity httpSecurity) throws Exception {

        httpSecurity.authorizeHttpRequests(configurer ->
                configurer
                        .requestMatchers("/api").hasAuthority("ADMIN")
                        .requestMatchers("/transaction/**").permitAll()
                        .requestMatchers("/category/**").permitAll()
                        .requestMatchers("/report/**").permitAll()
                        .anyRequest().authenticated()

//                        .requestMatchers(HttpMethod.GET, "/api/transaction").hasRole("USER")
//                        .requestMatchers(HttpMethod.GET, "/api/transaction/**").hasRole("USER")
//                        .requestMatchers(HttpMethod.POST, "/api/transaction").hasRole("USER")
//                        .requestMatchers(HttpMethod.PUT, "/api/transaction/**").hasRole("USER")
//                        .requestMatchers(HttpMethod.POST, "api/category").hasRole("USER")
        );

        httpSecurity.httpBasic(Customizer.withDefaults());
        httpSecurity.csrf(csrf -> csrf.disable());

        return httpSecurity.build();

    }
}
