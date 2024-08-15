package com.fj_portal.fj_portal_mysql_tool.controller;

import com.fj_portal.fj_portal_mysql_tool.entity.Fjtcouser;
//import com.fj_portal.fj_portal_mysql_tool.repository.FjtcouserRepository;
//import org.springframework.beans.factory.annotation.Autowired;
import com.fj_portal.fj_portal_mysql_tool.repository.FjtcouserRepository;
import com.fj_portal.fj_portal_mysql_tool.service.DatabaseService;
import com.fj_portal.fj_portal_mysql_tool.service.FjtcouserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Optional;

@RestController
@RequestMapping("/fjtcouser")
@CrossOrigin(origins = "http://localhost:4200")
public class FjtcouserController {
    @Autowired
    private DatabaseService databaseService;
    @Autowired
    private FjtcouserService fjtcouserService;
    @CrossOrigin(origins = "http://localhost:4200")
    @GetMapping("/all")
    public List<Fjtcouser> getAllUsers() {
        System.out.println("data");
        return fjtcouserService.getAllUsers();
    }

    @GetMapping("/test")
    public String testEndpoint() {
        return "The GET request is working!";
    }
    @GetMapping("/table")
    public List<String> getTables() {
        return databaseService.listTables();
    }
    @GetMapping("/tables")
    public List<String> listTables(@RequestParam(defaultValue = "") String search) {
        return databaseService.listTables(search);
    }
    @GetMapping("/columns")
    public String listColumns() {
        databaseService.listColumns();
        return "Column listing complete. Check the console for results.";
    }
    @GetMapping("/tables/{tableName}/columns")
    public List<Map<String, Object>> getTableColumns(@PathVariable String tableName) {
        return databaseService.getTableColumns(tableName);
    }

    @GetMapping("/tables/{tableName}/data")
    public List<Map<String, Object>> getTableData(@PathVariable String tableName) {
        return databaseService.getTableData(tableName);
    }
    @GetMapping("/{userId}")
    public ResponseEntity<Fjtcouser> getUserById(@PathVariable String userId) {
        Optional<Fjtcouser> user = fjtcouserService.getUserById(userId);
        return user.map(ResponseEntity::ok)
                .orElseGet(() -> ResponseEntity.notFound().build());
    }
    @PutMapping("/{userId}/password")
    public ResponseEntity<Fjtcouser> updatePassword(@PathVariable String userId, @RequestParam String newPassword) {
        Fjtcouser updatedUser = fjtcouserService.updatePassword(userId, newPassword);
        if (updatedUser != null) {
            return ResponseEntity.ok(updatedUser);
        }
        return ResponseEntity.notFound().build();
    }

}
