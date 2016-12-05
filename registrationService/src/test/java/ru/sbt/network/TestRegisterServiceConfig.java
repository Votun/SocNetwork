package ru.sbt.network;


import objects.Account;
import org.springframework.context.annotation.Bean;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.jdbc.datasource.init.ResourceDatabasePopulator;
import ru.sbt.network.dao.AccountRegDAO;

public class TestRegisterServiceConfig {


    @Bean
    public DriverManagerDataSource dataSource() {
        DriverManagerDataSource dataSource = new DriverManagerDataSource(" jdbc:h2:tcp://localhost/~/test", "sa", "");
        Resource resource = new ClassPathResource("testTable.sql");
        ResourceDatabasePopulator databasePop = new ResourceDatabasePopulator(resource);
        databasePop.execute(dataSource);
        return dataSource;
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
