package com.fj_portal.fj_portal_mysql_tool.secondary.repository;

import com.fj_portal.fj_portal_mysql_tool.secondary.entity.DailyTask;
import org.springframework.data.jpa.repository.JpaRepository;

public interface FjTaskRepository extends JpaRepository<DailyTask, String> {
    // You can define custom query methods here if needed
}
