package ru.sbt.network;

import objects.Account;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.DriverManagerDataSource;

import javax.sql.DataSource;


@Configuration
@ComponentScan
public class RegisterServiceConfig {


    @Bean
    public DriverManagerDataSource dataSource() {
        return new DriverManagerDataSource("magic");
    }

    @Bean
    public Registration registration() {
        Account testAccount = new Account("Yrwing", "Nikolay", "Frolov");
        String pswd = "12345";
        return new RegistrationService(testAccount, pswd);
    }

    @Bean
    public JdbcTemplate jdbcTemplate(DataSource dataSource) {
        return new JdbcTemplate(dataSource);
    }
}
