package com.fj_portal.fj_portal_mysql_tool.controller;


import com.fj_portal.fj_portal_mysql_tool.service.FjtcouserService;
import com.fj_portal.fj_portal_mysql_tool.entity.Fjtcouser;

//import config.JwtUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("/api")
public class LoginController {

    @Autowired
    private FjtcouserService fjtcouserService;

//    @Autowired
 //   private JwtUtil jwtUtil;

  /*  @PostMapping("/login")
    public ResponseEntity<?> login(@RequestParam String userId, @RequestParam String password) {
        Optional<Fjtcouser> user = fjtcouserService.authenticateUser(userId, password);
        if (user.isPresent()) {
            String token = jwtUtil.generateToken(userId);
            return ResponseEntity.ok().body(token); // Return JWT token
        }
        return ResponseEntity.status(401).body("Invalid credentials");
    }*/
}