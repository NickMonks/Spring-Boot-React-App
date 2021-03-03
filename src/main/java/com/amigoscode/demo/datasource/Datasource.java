package com.amigoscode.demo.datasource;

import com.zaxxer.hikari.HikariDataSource;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class Datasource {

    @Bean // will perform all dependencies injection, as the datasource instance
    @ConfigurationProperties("app.datasource") // this will search in the yml file the properties that we wrote
    public HikariDataSource hikariDataSource() {
        // this is the database class that spring boot recommends us to use
        return DataSourceBuilder
                .create()
                .type(HikariDataSource.class)
                .build();
    }
}
