package com.cognizant.spring_learn.controller;

import java.util.HashMap;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RestController;
import java.nio.charset.StandardCharsets;
import java.util.Base64;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.security.Keys;

import javax.crypto.SecretKey;

import java.util.Date;

@RestController
public class AuthenticationController {

    private static final Logger LOGGER =
            LoggerFactory.getLogger(AuthenticationController.class);

    @GetMapping("/authenticate")
    public Map<String, String> authenticate(
            @RequestHeader("Authorization") String authHeader) {

        LOGGER.info("START");

        LOGGER.debug("Authorization Header: {}", authHeader);

        String user = getUser(authHeader);

        LOGGER.info("User : {}", user);

        Map<String, String> map = new HashMap<>();

        String token = generateJwt(user);

        map.put("token", token);

        LOGGER.info("END");

        return map;
    }
    private String generateJwt(String user) {

        LOGGER.info("START");

        SecretKey key =
                Keys.hmacShaKeyFor(
                        "secretkeysecretkeysecretkey12345".getBytes()
                );

        String token = Jwts.builder()
                .subject(user)
                .issuedAt(new Date())
                .expiration(new Date(System.currentTimeMillis() + 1200000))
                .signWith(key)
                .compact();

        LOGGER.debug("JWT : {}", token);

        LOGGER.info("END");

        return token;
    }
    private String getUser(String authHeader) {

        LOGGER.info("START");

        // Remove "Basic "
        String encodedCredentials = authHeader.substring(6);

        LOGGER.info("Encoded : {}", encodedCredentials);

        // Decode Base64
        byte[] decodedBytes =
                Base64.getDecoder().decode(encodedCredentials);

        String credentials =
                new String(decodedBytes, StandardCharsets.UTF_8);

        LOGGER.info("Decoded : {}", credentials);

        // Get username before ':'
        String user = credentials.substring(0, credentials.indexOf(":"));

        LOGGER.info("User : {}", user);

        LOGGER.info("END");

        return user;
    }
}