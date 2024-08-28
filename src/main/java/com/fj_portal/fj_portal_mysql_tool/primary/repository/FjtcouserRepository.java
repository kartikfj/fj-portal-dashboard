package com.fj_portal.fj_portal_mysql_tool.primary.repository;

import com.fj_portal.fj_portal_mysql_tool.primary.entity.Fjtcouser;
import org.springframework.data.jpa.repository.JpaRepository;



public interface FjtcouserRepository extends JpaRepository<Fjtcouser,String> {
    Fjtcouser findByUserId(String userId);


}
