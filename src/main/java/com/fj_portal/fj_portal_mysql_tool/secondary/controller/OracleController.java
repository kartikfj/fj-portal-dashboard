package com.fj_portal.fj_portal_mysql_tool.secondary.controller;

import com.fj_portal.fj_portal_mysql_tool.secondary.service.OracleDatabaseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/oracle")
@CrossOrigin(origins = "*")  // Allow requests from any origin
public class OracleController {

    @Autowired
    private OracleDatabaseService oracleDatabaseService;

    // Get all tables from the Oracle database
    @GetMapping("/tables")
    public ResponseEntity<List<String>> getTables() {
        List<String> tables = oracleDatabaseService.listTables();
        return tables.isEmpty() ? ResponseEntity.noContent().build() : ResponseEntity.ok(tables);
    }
/*
    // Search for tables by name in the Oracle database
    @GetMapping("/tables/search")
    public ResponseEntity<List<String>> searchTables(@RequestParam(defaultValue = "") String search) {
        List<String> tables = oracleDatabaseService.listTables(search);
        return tables.isEmpty() ? ResponseEntity.noContent().build() : ResponseEntity.ok(tables);
    }

    // Get all columns of a specific table in the Oracle database
    @GetMapping("/tables/{tableName}/columns")
    public ResponseEntity<List<Map<String, Object>>> getTableColumns(@PathVariable String tableName) {
        List<Map<String, Object>> columns = oracleDatabaseService.getTableColumns(tableName);
        return columns.isEmpty() ? ResponseEntity.noContent().build() : ResponseEntity.ok(columns);
    }

    // Get all data from a specific table in the Oracle database
    @GetMapping("/tables/{tableName}/data")
    public ResponseEntity<List<Map<String, Object>>> getTableData(@PathVariable String tableName) {
        List<Map<String, Object>> data = oracleDatabaseService.getTableData(tableName);
        return data.isEmpty() ? ResponseEntity.noContent().build() : ResponseEntity.ok(data);
    }

    // Example endpoint to get user data by user ID from a specific table in the Oracle database
    @GetMapping("/tables/{tableName}/users/{userId}")
    public ResponseEntity<List<Map<String, Object>>> getUserData(
            @PathVariable String tableName,
            @RequestParam String userIdColumn,
            @PathVariable String userId) {
        List<Map<String, Object>> userData = oracleDatabaseService.getUserData(tableName, userIdColumn, userId);
        return userData.isEmpty() ? ResponseEntity.notFound().build() : ResponseEntity.ok(userData);
    }*/

    // Simple test endpoint to verify OracleController is working
    @GetMapping("/test")
    public ResponseEntity<String> testEndpoint() {
        return ResponseEntity.ok("Oracle GET request is working!");
    }
}
