package dev.rayh.supservice.auth.service.impl;

import dev.rayh.supservice.auth.config.KeyLoader;
import dev.rayh.supservice.auth.domain.UserCredentials;
import dev.rayh.supservice.auth.service.JwtService;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.security.Keys;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Component;

import java.security.Key;
import java.security.PrivateKey;
import java.util.Date;

@Component
public class JwtServiceImpl implements JwtService {

    @Value("${jwt.secret}")
    private String secret;
    @Value("${jwt.expiration}")
    private Long expiration;
    private PrivateKey privateKey;

    JwtServiceImpl(KeyLoader keyLoader){
        this.privateKey = keyLoader.loadPrivateKey();
    }

    private Key getSigningKey(){
        return Keys.hmacShaKeyFor(secret.getBytes());
    }

    @Override
    public String createNewToken(UserCredentials user) {
        return Jwts.builder()
                .setSubject(user.getEmail())
                .claim("email", user.getEmail())
                .claim("roles", user.getRoles())
                .setIssuedAt(new Date())
                .setExpiration(new Date(System.currentTimeMillis() + expiration))
                .signWith(privateKey, SignatureAlgorithm.RS256)
                .compact();
    }

    public Claims extractClaims(String token){
        return (Claims) Jwts.parser()
                .setSigningKey(getSigningKey()).build()
                .parse(token).getBody();
    }

    public boolean isTokenValid(String token, UserDetails userDetails) {
        final String userId = extractClaims(token).getSubject();
        return (userId.equals(userDetails.getUsername()) && !isTokenExpired(token));
    }

    private boolean isTokenExpired(String token) {
        return extractClaims(token).getExpiration().before(new Date());
    }

    @Override
    public String renewToken() {
        return "";
    }
}
