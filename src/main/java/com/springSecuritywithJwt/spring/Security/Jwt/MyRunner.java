package com.springSecuritywithJwt.spring.Security.Jwt;

import com.springSecuritywithJwt.spring.Security.Jwt.Entity.User;
import com.springSecuritywithJwt.spring.Security.Jwt.Repository.repository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class MyRunner implements CommandLineRunner {
    @Autowired
    private repository repo;
    @Override
    public void run(String... args) throws Exception {

        repo.save(new User("zakaria","megnioui","ziko10sporty@gmail.com"));
        repo.save(new User ("root","root","root@gmail.com"));
        repo.save(new User("username","password","ursername@gmail.com"));


    }

}
