package com.fj_portal.fj_portal_mysql_tool.primary.controller;


import com.fj_portal.fj_portal_mysql_tool.primary.entity.Fjtcouser;
import com.fj_portal.fj_portal_mysql_tool.primary.response.LoginResponse;
import com.fj_portal.fj_portal_mysql_tool.primary.service.FjtcouserService;
import com.fj_portal.fj_portal_mysql_tool.primary.service.JwtService;

//import config.JwtUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@CrossOrigin(origins = "http://localhost:4200")

@RestController
@RequestMapping("/api")
public class LoginController {
    @Autowired
    private JwtService jwtService;
    @Autowired
    private FjtcouserService fjtcouserService;

//    @Autowired
 //   private JwtUtil jwtUtil;
   @CrossOrigin(origins = "http://10.10.4.198:4200")
   @PostMapping("/login")
    public ResponseEntity<?> login(@RequestParam String userId, @RequestParam String password) {
       Optional<Fjtcouser> user = fjtcouserService.authenticateUser(userId, password);
       if (user.isPresent()) {
           Fjtcouser users = user.get();
           // Perform password check and return user if valid
           String jwtToken = jwtService.generateToken(users);
           Long expirationTime = jwtService.getExpirationTime();

           LoginResponse loginResponse = new LoginResponse();
           loginResponse.setToken(jwtToken);
           loginResponse.setExpiresIn(expirationTime);


           return ResponseEntity.ok(loginResponse);
       }

       return ResponseEntity.badRequest().body("Invalid credentials");
   }
}