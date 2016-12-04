package ru.sbt.network;


import objects.Account;
import org.springframework.context.annotation.Bean;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import ru.sbt.network.dao.AccountRegDAO;

public class TestRegisterServiceConfig {


    @Bean
    public DriverManagerDataSource dataSource() {
        return new DriverManagerDataSource(" jdbc:h2:tcp://localhost/~/test", "sa", "");
    }

    @Bean
    public Registration registration() {
        Account testAccount = new Account("hemdahl", "Nikolay", "Frolov");
        String pswd = "12345";
        return new RegistrationService(testAccount, pswd);
    }

    @Bean
    public JdbcTemplate jdbcTemplate() {
        return new JdbcTemplate(dataSource());
    }

    @Bean
    public AccountRegDAO accountRegDAO() {
        return new AccountRegDAO(jdbcTemplate());
    }


}
