package com.enigmacamp.enigmacoop.security;

import jakarta.servlet.DispatcherType;
import lombok.AllArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.method.configuration.EnableMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configurers.AbstractHttpConfigurer;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;

@Configuration
@EnableWebSecurity
@EnableMethodSecurity
@AllArgsConstructor
public class SecurityConfiguration {

    private final JwtAthenticationFilter jwtAthenticationFilter;

    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
        return http.httpBasic(AbstractHttpConfigurer::disable)
                .csrf(AbstractHttpConfigurer::disable)
                .cors(cors -> {
                    UrlBasedCorsConfigurationSource source = new UrlBasedCorsConfigurationSource();
                    CorsConfiguration config = new CorsConfiguration();
                    config.addAllowedOrigin("*"); // Ganti dengan asal yang diizinkan
                    config.addAllowedMethod("*");
                    config.addAllowedHeader("*");
                    source.registerCorsConfiguration("/**", config);
                    cors.configurationSource(source);
                })
                .sessionManagement(cfg -> cfg.sessionCreationPolicy(SessionCreationPolicy.STATELESS))
                .authorizeHttpRequests(request ->
                        request.dispatcherTypeMatchers(DispatcherType.ERROR).permitAll()
                                .requestMatchers("api/v1/auth/**", "api/v1/image/**").permitAll()
                                .anyRequest().authenticated()
                )
                .addFilterBefore(jwtAthenticationFilter, UsernamePasswordAuthenticationFilter.class)
                .build();
    }
}
