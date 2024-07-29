package com.fj_portal.fj_portal_mysql_tool;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@EnableJpaRepositories(basePackages = "com.fj_portal.fj_portal_mysql_tool.repository")
@EntityScan(basePackages = "com.fj_portal.fj_portal_mysql_tool.entity")
@OpenAPIDefinition
public class FjPortalMysqlToolApplication {

	public static void main(String[] args) {
		SpringApplication.run(FjPortalMysqlToolApplication.class, args);
	}

}
