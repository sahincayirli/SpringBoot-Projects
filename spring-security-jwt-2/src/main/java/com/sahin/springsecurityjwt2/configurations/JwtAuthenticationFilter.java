package com.sahin.springsecurityjwt2.configurations;

import com.sahin.springsecurityjwt2.services.CustomUserDetailService;
import com.sahin.springsecurityjwt2.services.JwtUtil;
import io.jsonwebtoken.ExpiredJwtException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;
import org.springframework.web.filter.OncePerRequestFilter;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@Component
public class JwtAuthenticationFilter extends OncePerRequestFilter {

    @Autowired
    private JwtUtil jwtUtil;

    @Override
    protected void doFilterInternal(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, FilterChain filterChain) throws ServletException, IOException {

        String header = httpServletRequest.getHeader("Authorization");

        String token = null;
        String username = null;


        if (header != null && header.startsWith("Bearer ")) {
            token = header.substring(7);

            try {
                if (jwtUtil.validateToken(token) && StringUtils.hasText(token)) {
                    UserDetails userDetails = new User(jwtUtil.getUsernameFromToken(token), "", jwtUtil.getRolesFromToken(token));
                    UsernamePasswordAuthenticationToken usernamePasswordAuthenticationToken = new
                            UsernamePasswordAuthenticationToken(userDetails,null, jwtUtil.getRolesFromToken(token));
                    SecurityContextHolder.getContext().setAuthentication(usernamePasswordAuthenticationToken);
                }
                else {
                    System.out.println("Cannot set the Security Context");
                }
            }
            catch (ExpiredJwtException ex) {
                httpServletRequest.setAttribute("exception",ex);
            }
            catch (BadCredentialsException ex) {
                httpServletRequest.setAttribute("exception",ex);
            }


        }
        else {
            System.out.println("No jwt in this header");
        }

        filterChain.doFilter(httpServletRequest,httpServletResponse);

    }
}
