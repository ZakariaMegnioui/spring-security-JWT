package com.springSecuritywithJwt.spring.Security.Jwt.AllPackagess.Config;

import com.springSecuritywithJwt.spring.Security.Jwt.Entity.User;
import com.springSecuritywithJwt.spring.Security.Jwt.Repository.repository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
@Service
public class CostumUserDetails implements UserDetailsService {
    @Autowired
    private repository ripo;
    @Bean
    public PasswordEncoder passwordEncoder(){
        return new BCryptPasswordEncoder();
    }
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
       User user = ripo.findByUsername(username);
        return new org.springframework.security.core.userdetails.User(user.getUsername(),passwordEncoder().encode(user.getPassword()),new ArrayList<>());
    }

}
