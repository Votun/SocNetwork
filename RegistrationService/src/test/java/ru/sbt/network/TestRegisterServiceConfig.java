package ru.sbt.network;


import org.springframework.context.annotation.Bean;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import ru.sbt.network.dao.AccountRegDAO;
import wrappers.Account;

public class TestRegisterServiceConfig {


    @Bean
    public DriverManagerDataSource dataSource() {
        return new DriverManagerDataSource("jdbc:mysql://127.0.0.1:1111/users", "root", "");
    }

    @Bean
    public Registration registration() {
        Account testAccount = new Account("Yrwing", "Nikolay", "Frolov");
        String pswd = "12345";
        return new RegistrationService(testAccount, pswd);
    }

    @Bean
    public AccountRegDAO accountRegDAO(DriverManagerDataSource dataSource) {
        return new AccountRegDAO(dataSource);
    }

}
