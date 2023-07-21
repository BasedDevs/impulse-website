package com.baseddevs.userservice.security.filter;

import com.baseddevs.userservice.dto.auth.AuthenticationResponseDTO;
import com.baseddevs.userservice.dto.auth.LoginRequest;
import com.baseddevs.userservice.exception.dto.ApiResponse;
import com.baseddevs.userservice.model.RefreshToken;
import com.baseddevs.userservice.security.model.SecurityUser;
import com.baseddevs.userservice.security.utils.JwtUtils;
import com.baseddevs.userservice.service.RefreshTokenService;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import jakarta.servlet.FilterChain;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.ws.rs.BadRequestException;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

import java.io.IOException;
import java.time.ZonedDateTime;

public class JWTAuthenticationFilter extends UsernamePasswordAuthenticationFilter {

    private final JwtUtils jwtUtils;
    private final AuthenticationManager authenticationManager;
    private final RefreshTokenService refreshTokenService;

    public JWTAuthenticationFilter(JwtUtils jwtUtils, AuthenticationManager authenticationManager, RefreshTokenService refreshTokenService) {
        this.jwtUtils = jwtUtils;
        this.authenticationManager = authenticationManager;
        this.refreshTokenService = refreshTokenService;
        this.setFilterProcessesUrl("/auth/login");
    }

    @Override
    public Authentication attemptAuthentication(HttpServletRequest req, HttpServletResponse res)
            throws AuthenticationException {
        try {
            LoginRequest loginRequest = new ObjectMapper().readValue(req.getInputStream(), LoginRequest.class);

            return authenticationManager.authenticate(
                    new UsernamePasswordAuthenticationToken(
                            loginRequest.getUsername(),
                            loginRequest.getPassword()
                    )
            );
        } catch (IOException e) {
            throw new BadRequestException("Invalid login request format.");
        }
    }

    @Override
    protected void successfulAuthentication(HttpServletRequest req, HttpServletResponse res, FilterChain chain, Authentication auth) throws IOException {
        String token = jwtUtils.generateJwtToken(auth);

        // Generate the refresh token
        SecurityUser securityUser = (SecurityUser) auth.getPrincipal();
        RefreshToken newRefreshToken = refreshTokenService.createRefreshToken(securityUser.getUsername());

        // Put JWT and refresh token in the response
        AuthenticationResponseDTO responseDTO = new AuthenticationResponseDTO(token, newRefreshToken.getToken());
        ApiResponse<AuthenticationResponseDTO> response = new ApiResponse<>(ZonedDateTime.now(), "success", responseDTO);
        ObjectMapper mapper = new ObjectMapper();
        mapper.registerModule(new JavaTimeModule());
        mapper.disable(SerializationFeature.WRITE_DATES_AS_TIMESTAMPS);
        String responseBody = mapper.writeValueAsString(response);

        res.getWriter().write(responseBody);
        res.getWriter().flush();
        res.getWriter().close();
    }
}
