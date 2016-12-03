package ru.sbt.network;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import wrappers.Account;


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
}
