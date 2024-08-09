package com.fj_portal.fj_portal_mysql_tool.controller;


import com.fj_portal.fj_portal_mysql_tool.response.LoginResponse;
import com.fj_portal.fj_portal_mysql_tool.service.FjtcouserService;
import com.fj_portal.fj_portal_mysql_tool.entity.Fjtcouser;

//import config.JwtUtil;
import com.fj_portal.fj_portal_mysql_tool.service.JwtService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("/api")
public class LoginController {
    @Autowired
    private  JwtService jwtService;
    @Autowired
    private FjtcouserService fjtcouserService;

//    @Autowired
 //   private JwtUtil jwtUtil;

   @PostMapping("/login")
    public ResponseEntity<?> login(@RequestParam String userId, @RequestParam String password) {
       Optional<Fjtcouser> user = fjtcouserService.authenticateUser(userId, password);
       if (user.isPresent()) {
           Fjtcouser users = user.get();
           // Perform password check and return user if valid
           String jwtToken = jwtService.generateToken(users);
           Long expirationTime = jwtService.getExpirationTime();

           LoginResponse  loginResponse = new LoginResponse();
           loginResponse.setToken(jwtToken);
           loginResponse.setExpiresIn(expirationTime);


           return ResponseEntity.ok(loginResponse);
       }

       return ResponseEntity.badRequest().body("Invalid credentials");
   }
}