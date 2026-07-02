package com.example.employeemanagement.config;

import javax.sql.DataSource;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
@ConditionalOnProperty(prefix = "app.reporting-datasource", name = "enabled", havingValue = "true")
public class ReportingDataSourceConfig {

    @Bean
    public DataSource reportingDataSource(
            @Value("${app.reporting-datasource.url}") String url,
            @Value("${app.reporting-datasource.username}") String username,
            @Value("${app.reporting-datasource.password}") String password) {
        return DataSourceBuilder.create()
                .url(url)
                .username(username)
                .password(password)
                .build();
    }
}