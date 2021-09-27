package com.notedgeek.notehub.config;

import com.notedgeek.notehub.util.Utils;
import com.zaxxer.hikari.HikariConfig;
import com.zaxxer.hikari.HikariDataSource;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.sql.DataSource;

@Configuration
public class Config {

    @Bean
    public DataSource mysqlDataSource() {
        HikariConfig config = new HikariConfig();
        config.setDriverClassName("com.mysql.cj.jdbc.Driver");
        config.setJdbcUrl("jdbc:mysql://localhost:3306/notehub");
        config.setUsername("notehub");
        config.setPassword("notehub");
        return new HikariDataSource(config);
    }

    @Bean
    public Utils utils() {
        return new Utils();
    }
}
