package com.baseddevs.ecommerce.security.utils;

import io.jsonwebtoken.*;
import io.jsonwebtoken.io.Decoders;
import io.jsonwebtoken.security.Keys;
import io.jsonwebtoken.security.SignatureException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.stereotype.Component;

import javax.crypto.SecretKey;
import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

@Component
public class JwtUtils {

    private static final Logger LOGGER = LoggerFactory.getLogger(JwtUtils.class);

    @Value("${jwt.secret}")
    private String jwtSecret;

    public Collection<GrantedAuthority> getAuthoritiesFromJwtToken(String token) {
        Claims claims = Jwts.parserBuilder()
                .setSigningKey(getSigningKey())
                .build()
                .parseClaimsJws(token)
                .getBody();

        return ((List<?>) claims.get("roles")).stream()
                .map(authority -> new SimpleGrantedAuthority((String) authority))
                .collect(Collectors.toList());
    }

    public String getUserNameFromJwtToken(String token) {
        Claims claims = Jwts.parserBuilder()
                .setSigningKey(getSigningKey())
                .build()
                .parseClaimsJws(token)
                .getBody();

        return claims.getSubject();
    }

    public boolean validateJwtToken(String authToken) {
        try {
            Jwts.parserBuilder()
                    .setSigningKey(getSigningKey())
                    .build()
                    .parseClaimsJws(authToken);
            return true;
        } catch (ExpiredJwtException ex) {
            // Log the exception message or do something specific for expired tokens
            LOGGER.error(ex.getMessage());
            throw new JwtException("JWT token is expired.");
        } catch (SignatureException ex) {
            // Log the exception message or do something specific for signature validation failures
            LOGGER.error(ex.getMessage());
            throw new JwtException("Invalid JWT signature.");
        } catch (MalformedJwtException ex) {
            // Log the exception message or do something specific for malformed tokens
            LOGGER.error(ex.getMessage());
            throw new JwtException("Malformed JWT token.");
        } catch (JwtException ex) {
            // Catch all other JwtException types
            LOGGER.error(ex.getMessage());
            throw new JwtException("Invalid JWT token.");
        }
    }

    private SecretKey getSigningKey() {
        // Be sure to encode your secret
        byte[] keyBytes = Decoders.BASE64.decode(jwtSecret);
        return Keys.hmacShaKeyFor(keyBytes);
    }
}
