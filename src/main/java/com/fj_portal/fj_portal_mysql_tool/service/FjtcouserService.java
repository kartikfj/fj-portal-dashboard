package com.fj_portal.fj_portal_mysql_tool.service;

import com.fj_portal.fj_portal_mysql_tool.entity.Fjtcouser;
import com.fj_portal.fj_portal_mysql_tool.repository.FjtcouserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class FjtcouserService {

    @Autowired
    private FjtcouserRepository fjtcouserRepository;

    public List<Fjtcouser> getAllUsers() {
        return fjtcouserRepository.findAll();
    }
    public Optional<Fjtcouser> getUserById(String userId) {
        return Optional.ofNullable(fjtcouserRepository.findByUserId(userId));
    }

    public Fjtcouser updatePassword(String userId, String newPassword) {
        Optional<Fjtcouser> userOptional = Optional.ofNullable(fjtcouserRepository.findByUserId(userId));
        if (userOptional.isPresent()) {
            Fjtcouser user = userOptional.get();
            user.setPassword(newPassword);
            return fjtcouserRepository.save(user);
        }
        return null; // Return null or handle this case as needed
    }
    public Optional<Fjtcouser> authenticateUser(String userId, String password) {
        Fjtcouser user = fjtcouserRepository.findByUserId(userId);
        if (user != null && user.getPassword().equals(password)) {
            return Optional.of(user);
        }
        return Optional.empty();
    }
}
