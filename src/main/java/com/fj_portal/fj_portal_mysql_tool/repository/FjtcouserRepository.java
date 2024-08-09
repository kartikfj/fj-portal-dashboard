package com.fj_portal.fj_portal_mysql_tool.repository;

import com.fj_portal.fj_portal_mysql_tool.entity.Fjtcouser;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface FjtcouserRepository extends JpaRepository<Fjtcouser,String> {
    Fjtcouser findByUserId(String userId);


}
