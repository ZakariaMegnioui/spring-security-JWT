package com.springSecuritywithJwt.spring.Security.Jwt.Repository;


import com.springSecuritywithJwt.spring.Security.Jwt.Entity.User;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface repository extends CrudRepository<User,Integer> {


    User findByUsername(String username);
}

