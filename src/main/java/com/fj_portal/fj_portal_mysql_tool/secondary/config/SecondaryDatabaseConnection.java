package com.fj_portal.fj_portal_mysql_tool.secondary.config;

import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.context.annotation.Configuration;

import jakarta.persistence.EntityManagerFactory;
import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.boot.orm.jpa.EntityManagerFactoryBuilder;
import org.springframework.context.annotation.Bean;

import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.transaction.PlatformTransactionManager;

@Configuration
@EnableJpaRepositories(
        entityManagerFactoryRef = "secondaryEntityManagerFactory",
        transactionManagerRef = "secondaryTransactionManager",
        basePackages = {"com.fj_portal.fj_portal_mysql_tool.secondary.repository"}
)
public class SecondaryDatabaseConnection {

    @Value("${spring.secondary.datasource.url}")
    private String url;

    @Value("${spring.secondary.datasource.username}")
    private String username;

    @Value("${spring.secondary.datasource.password}")
    private String password;

    /**
     * Configure and return the secondary data source.
     */
    @Bean(name = "secondaryDbDataSource")
    public DataSource secondaryDbDataSource() {
        return DataSourceBuilder.create()
                .url(url)
                .username(username)
                .password(password)
                .build();
    }

    /**
     * Configure and return the EntityManagerFactory for the secondary database.
     */
    @Bean(name = "secondaryEntityManagerFactory")
    public LocalContainerEntityManagerFactoryBean secondaryEntityManagerFactory(
            EntityManagerFactoryBuilder builder) {
        return builder
                .dataSource(secondaryDbDataSource())
                .packages("com.fj_portal.fj_portal_mysql_tool.secondary.entity")
                .build();
    }

    /**
     * Configure and return the transaction manager for the secondary database.
     */
    @Bean(name = "secondaryTransactionManager")
    public PlatformTransactionManager secondaryTransactionManager(
            EntityManagerFactory secondaryEntityManagerFactory) {
        return new JpaTransactionManager(secondaryEntityManagerFactory);
    }
}
