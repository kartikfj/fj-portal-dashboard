package com.fj_portal.fj_portal_mysql_tool.secondary.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;

import javax.sql.DataSource;
import java.util.List;
import java.util.Map;

@Service
public class OracleDatabaseService {

    private final JdbcTemplate jdbcTemplate;

    @Autowired
    public OracleDatabaseService(@Qualifier("secondaryDbDataSource") DataSource secondaryDbDataSource) {
        this.jdbcTemplate = new JdbcTemplate(secondaryDbDataSource);
    }

    public List<String> listTables() {
        String schemaName = "FJPORTAL"; // Specify your schema name here
        String sql = "SELECT TABLE_NAME FROM ALL_TABLES WHERE OWNER = ?";
        return jdbcTemplate.queryForList(sql, new Object[]{schemaName}, String.class);
    }

    // Other methods...
}
