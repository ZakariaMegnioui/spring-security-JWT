package com.springSecuritywithJwt.spring.Security.Jwt.AllPackagess.Config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfiguration;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.web.authentication.WebAuthenticationDetailsSource;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
@Component
public class fillter extends OncePerRequestFilter {
    @Autowired
    private JwtUtil jwtutil;
    @Autowired
    private  CostumUserDetails service;
    @Override
    protected void doFilterInternal(HttpServletRequest httpRequest, HttpServletResponse httpResponse, FilterChain filterChain) throws ServletException, IOException {
      String authorizationhedear = httpRequest.getHeader("Authorization");
      String token = null;
      String username = null;
      if(authorizationhedear!=null && authorizationhedear.startsWith("Bearer ")){
        token = authorizationhedear.substring(7);

            username = jwtutil.extractUsername(token);
      }
      if (username!=null && SecurityContextHolder.getContext().getAuthentication()==null){
        UserDetails userDetails =  service.loadUserByUsername(username);
        if(jwtutil.validateToken(token , userDetails)) {
            UsernamePasswordAuthenticationToken usernamePasswordAuthenticationToken = new
                    UsernamePasswordAuthenticationToken(userDetails, null, userDetails.getAuthorities());
            usernamePasswordAuthenticationToken.setDetails(new WebAuthenticationDetailsSource().buildDetails(httpRequest));
            SecurityContextHolder.getContext().setAuthentication(usernamePasswordAuthenticationToken);
        }
      }
     filterChain.doFilter(httpRequest,httpResponse);
    }
}
