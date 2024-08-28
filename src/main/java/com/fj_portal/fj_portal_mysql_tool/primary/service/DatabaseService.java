package com.fj_portal.fj_portal_mysql_tool.primary.service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@Service

public class DatabaseService {
    @Autowired
    private JdbcTemplate jdbcTemplate;

    public  List<String> listTables() {
        String sql = "SHOW TABLES";
        List<Map<String, Object>> tables = jdbcTemplate.queryForList(sql);
        List<String> tableNames = new ArrayList<>();

        for (Map<String, Object> table : tables) {
            tableNames.add((String) table.values().iterator().next());
        }

        return tableNames;
    }
    public List<String> listTables(String searchTerm) {
        String sql = "SHOW TABLES";
        List<Map<String, Object>> tables = jdbcTemplate.queryForList(sql);
        List<String> tableNames = new ArrayList<>();

        for (Map<String, Object> table : tables) {
            String tableName = (String) table.values().iterator().next();
            if (tableName.toLowerCase().contains(searchTerm.toLowerCase())) {
                tableNames.add(tableName);
            }
        }

        return tableNames;
    }
    public void listColumns() {
        String sql = "DESCRIBE fjtcouser";
        List<Map<String, Object>> columns = jdbcTemplate.queryForList(sql);
        for (Map<String, Object> column : columns) {
            System.out.println(column);
        }
    }
    public List<Map<String, Object>> getTableData(String tableName) {
        String sql = "SELECT * FROM " + tableName;
        return jdbcTemplate.queryForList(sql);
    }

    public List<Map<String, Object>> getTableColumns(String tableName) {
        String sql = "DESCRIBE " + tableName;
        return jdbcTemplate.queryForList(sql);
    }
    public List<Map<String, Object>> getUserData(String tableName, String userIdColumn, String userId) {
        String sql = "SELECT * FROM " + tableName + " WHERE " + userIdColumn + " = ?";
        return jdbcTemplate.queryForList(sql, userId);
    }
}
