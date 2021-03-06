package com.yolanda.kokkinou.airbnbservice.util;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.authentication.www.BasicAuthenticationFilter;

import com.auth0.jwt.JWT;
import com.auth0.jwt.algorithms.Algorithm;

import io.jsonwebtoken.io.IOException;

public class JWTAuthorizationFilter extends BasicAuthenticationFilter {

    private static final Logger logger = LoggerFactory.getLogger(JWTAuthorizationFilter.class);

    private String jwtSecretPassword;

    public JWTAuthorizationFilter(AuthenticationManager authenticationManager, String jwtSecretPassword) {
        super(authenticationManager);
        this.jwtSecretPassword = jwtSecretPassword;
    }

    @Override
    protected void doFilterInternal(HttpServletRequest req, HttpServletResponse res, FilterChain chain)
            throws IOException, ServletException, java.io.IOException {
        String header = req.getHeader("Authorization");

        if (header == null || !header.startsWith("Bearer ")) {
            chain.doFilter(req, res);
            return;
        }

        UsernamePasswordAuthenticationToken authentication = getAuthentication(req);
        SecurityContextHolder.getContext().setAuthentication(authentication);
        chain.doFilter(req, res);
    }

    private UsernamePasswordAuthenticationToken getAuthentication(HttpServletRequest request) {
        String token = request.getHeader("Authorization");
        if (token != null) {
            // parse the token.
            String user = JWT.require(Algorithm.HMAC512(jwtSecretPassword.getBytes())).build()
                    .verify(token.replace("Bearer ", "")).getSubject();
//			Claim claim = JWT.require(Algorithm.HMAC512(jwtSecretPassword.getBytes())).build()
//					.verify(token.replace("Bearer ", "")).getClaim("role");
            // String[] arrayString = claim.asArray(String.class);
            // List<SimpleGrantedAuthority> updatedAuthorities = new
            // ArrayList<SimpleGrantedAuthority>();
            // updatedAuthorities.add(new SimpleGrantedAuthority(arrayString[0]));
            logger.info(user);
            List<SimpleGrantedAuthority> updatedAuthorities = new ArrayList<SimpleGrantedAuthority>();
            updatedAuthorities.add(new SimpleGrantedAuthority("GENERAL_USER"));
            if (user != null) {
                return new UsernamePasswordAuthenticationToken(user, null, updatedAuthorities);
            }
            return null;
        }
        return null;
    }
}