package com.springSecuritywithJwt.spring.Security.Jwt.UserService;

import com.springSecuritywithJwt.spring.Security.Jwt.Entity.User;
import com.springSecuritywithJwt.spring.Security.Jwt.Repository.repository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class service {

    @Autowired
    private repository repo;

    public List<User> findAll(){
        List<User> users=new ArrayList<>();

       repo.findAll().iterator().forEachRemaining(users::add);
       return users;
    }
    public User insert(User user){
        return repo.save(user);
    }
    public  String deleteById(int id){
          try {
              repo.delete(findById(id));
              return "done";
          }catch (Exception e){
              return  e.getMessage();
          }

    }

    public User findById(int id) {
        return repo.findById(id).get();
    }
    public User update(User user , int id){
        User user1=new User();
        user1.setId(id);
        user1.setUsername(user.getUsername());
        user1.setPassword(user.getPassword());
        user1.setEmail(user.getEmail());
       repo.save(user1);
        return user1;
    }
}
