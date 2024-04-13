package com.deadlock.fastjk.configuration;

import com.deadlock.fastjk.core.service.TokenService;
import com.deadlock.fastjk.exceptions.UnauthorizedException;
import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import java.io.IOException;


import static java.util.Objects.isNull;

@Component
@RequiredArgsConstructor
@Slf4j
public class JwtFilter extends OncePerRequestFilter {

    private final TokenService tokenService;
    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain) throws ServletException, IOException {
        log.info("Processing Request validating JWT");
        String token = extractTokenFromRequest(request);

        log.info("VALID TOKEN...");
        filterChain.doFilter(request, response);
    }

    private String extractTokenFromRequest(HttpServletRequest request) {
        String authorization = request.getHeader("Authorization");

        if (isNull(authorization) || authorization.isBlank() || !authorization.startsWith("Bearer ")) {
            throw new UnauthorizedException("Bearer Token not found.");
        }

        return authorization.replace("Bearer ", "");
    }
}
