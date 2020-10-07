package com.springSecuritywithJwt.spring.Security.Jwt.controller;

import com.springSecuritywithJwt.spring.Security.Jwt.AllPackagess.Config.JwtUtil;
import com.springSecuritywithJwt.spring.Security.Jwt.AllPackagess.Config.Token;
import com.springSecuritywithJwt.spring.Security.Jwt.Entity.User;
import com.springSecuritywithJwt.spring.Security.Jwt.Entity.authrequest;
import com.springSecuritywithJwt.spring.Security.Jwt.UserService.service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("Emp/")
public class controller {
    @Autowired
    private service serv;
    @Autowired
    private JwtUtil jwtUtil;
    @Autowired
    private AuthenticationManager authenticationManager;


    @PostMapping("/authenticate")
    public Token generateToken(@RequestBody authrequest request) throws Exception {
    try{
          authenticationManager.authenticate(
                  new UsernamePasswordAuthenticationToken(request.getUsername(),request.getPassword()));
    }catch (Exception e) {
        throw new Exception("invaled username or password !");
    }
    Token jwt = new Token(jwtUtil.generateToken(request.getUsername()));
    return jwt;
    }

    @RequestMapping(method = RequestMethod.GET)
    public List<User> word(){
      return  serv.findAll();
    }

    @PostMapping
    public User insert(@RequestBody User user){
      return serv.insert(user);
    }
    @GetMapping(value = "/{id}")
    public User findById(@PathVariable int id){
        return serv.findById(id);
    }
   @DeleteMapping(value = "/{id}")
    public String deleteById(@PathVariable int id){
       return   serv.deleteById(id);
   }
   @PutMapping(value = "/{id}")
    public User update(@RequestBody User user , @PathVariable int id ){

        return serv.update(user,id);
   }


}
