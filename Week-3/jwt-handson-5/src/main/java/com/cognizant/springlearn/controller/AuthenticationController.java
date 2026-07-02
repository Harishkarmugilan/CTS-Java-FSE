package com.cognizant.springlearn.controller;

import java.nio.charset.StandardCharsets;
import java.util.Base64;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;

@RestController
public class AuthenticationController {

    private static final Logger logger = LoggerFactory.getLogger(AuthenticationController.class);
    private static final String SECRET_KEY = "secretkey";
    private static final long EXPIRY_TIME = 20 * 60 * 1000L;

    @GetMapping(value = "/authenticate", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Map<String, String>> authenticate(HttpServletRequest request) {
        logger.debug("AuthenticationController authenticate start");
        String authorizationHeader = request.getHeader(HttpHeaders.AUTHORIZATION);
        if (authorizationHeader == null || !authorizationHeader.startsWith("Basic ")) {
            logger.debug("AuthenticationController missing or invalid basic authorization header");
            throw new ResponseStatusException(HttpStatus.UNAUTHORIZED, "Unauthorized");
        }
        String username = extractUsername(authorizationHeader);
        String token = generateToken(username);

        Map<String, String> response = new HashMap<>();
        response.put("token", token);

        logger.debug("AuthenticationController authenticate end for user: {}", username);
        return ResponseEntity.ok(response);
    }

    private String extractUsername(String authorizationHeader) {
        String encodedCredentials = authorizationHeader.replace("Basic ", "");
        byte[] decodedCredentials = Base64.getDecoder().decode(encodedCredentials);
        String credentials = new String(decodedCredentials, StandardCharsets.UTF_8);
        return credentials.substring(0, credentials.indexOf(':'));
    }

    private String generateToken(String username) {
        Date issuedAt = new Date();
        Date expiryDate = new Date(issuedAt.getTime() + EXPIRY_TIME);
        return Jwts.builder()
                .setSubject(username)
                .setIssuedAt(issuedAt)
                .setExpiration(expiryDate)
                .signWith(SignatureAlgorithm.HS256, SECRET_KEY)
                .compact();
    }
}
