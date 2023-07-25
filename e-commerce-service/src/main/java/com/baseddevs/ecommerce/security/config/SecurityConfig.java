package com.baseddevs.ecommerce.security.config;

import com.baseddevs.ecommerce.security.filter.ExceptionHandlingFilter;
import com.baseddevs.ecommerce.security.filter.JWTAuthorizationFilter;
import com.baseddevs.ecommerce.security.filter.RestAuthenticationEntryPoint;
import com.baseddevs.ecommerce.security.utils.JwtUtils;
import lombok.AllArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configurers.AbstractHttpConfigurer;
import org.springframework.security.config.annotation.web.configurers.HeadersConfigurer;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
@EnableWebSecurity
@AllArgsConstructor
public class SecurityConfig {

    private final JwtUtils jwtUtils;
    private final RestAuthenticationEntryPoint restAuthenticationEntryPoint;

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        http.csrf(AbstractHttpConfigurer::disable);
        http.cors(AbstractHttpConfigurer::disable);

        http.authorizeHttpRequests(auth -> auth
                .requestMatchers(
                        new AntPathRequestMatcher("/api/products/**"),
                        new AntPathRequestMatcher("/api/orders/**"))
                .authenticated()
        );

        http.exceptionHandling(httpSecurityExceptionHandlingConfigurer -> {
            httpSecurityExceptionHandlingConfigurer.accessDeniedPage("/403");
            httpSecurityExceptionHandlingConfigurer.authenticationEntryPoint(restAuthenticationEntryPoint);
        });

        http.sessionManagement(session -> session.sessionCreationPolicy(SessionCreationPolicy.STATELESS));

        http.addFilterBefore(new ExceptionHandlingFilter(), UsernamePasswordAuthenticationFilter.class);
        http.addFilterAfter(new JWTAuthorizationFilter(jwtUtils), UsernamePasswordAuthenticationFilter.class);

        return http.build();
    }

    @Bean
    public WebMvcConfigurer corsConfigurer() {
        return new WebMvcConfigurer() {
            @Override
            public void addCorsMappings(CorsRegistry registry) {
                registry.addMapping("/**")
                        .allowedOrigins("http://localhost:8081") // Specify the allowed origins here
                        .allowedMethods("GET", "POST", "PUT", "DELETE"); // Specify the allowed methods here
            }
        };
    }
}
