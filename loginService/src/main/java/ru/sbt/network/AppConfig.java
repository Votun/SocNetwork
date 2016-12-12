package ru.sbt.network;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.JpaVendorAdapter;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.orm.jpa.vendor.AbstractJpaVendorAdapter;
import org.springframework.orm.jpa.vendor.HibernateJpaVendorAdapter;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import ru.sbt.network.dao.AccessVerificationDAO;

import javax.persistence.EntityManagerFactory;
import javax.sql.DataSource;
import java.beans.PropertyVetoException;
import java.util.Properties;

@Configuration
@EnableTransactionManagement
@EnableJpaRepositories
public class AppConfig {

    @Bean
    public DriverManagerDataSource dataSource() {
        DriverManagerDataSource dataSource = new DriverManagerDataSource(" jdbc:h2:tcp://localhost/~/test", "sa", "");
//        Resource resource = new ClassPathResource("testTable.sql");
//        ResourceDatabasePopulator databasePop = new ResourceDatabasePopulator(resource);
//        databasePop.execute(dataSource);
        return dataSource;
    }

    @Bean
    public JdbcTemplate jdbcTemplate() {
        return new JdbcTemplate(dataSource());
    }

    @Bean
    public JpaVendorAdapter jpaVendorAdapter() {
        AbstractJpaVendorAdapter adapter = new HibernateJpaVendorAdapter();
        adapter.setShowSql(true);
        adapter.setGenerateDdl(true);
        return adapter;
    }

    @Bean
    public EntityManagerFactory entityManagerFactory(DataSource dataSource, JpaVendorAdapter adapter) {
        LocalContainerEntityManagerFactoryBean factory = new LocalContainerEntityManagerFactoryBean();
        factory.setJpaVendorAdapter(adapter);
        factory.setDataSource(dataSource);
        factory.setPackagesToScan("ru.sbt.network.objects");
        factory.setJpaProperties(jpaProperties());
        factory.afterPropertiesSet();
        return factory.getObject();
    }

    @Bean
    public Properties jpaProperties() {
        Properties props = new Properties();
        props.put("hibernate.dialect", "org.hibernate.dialect.H2Dialect");
        return props;
    }

    @Bean
    public PlatformTransactionManager transactionManager(EntityManagerFactory emf)
            throws PropertyVetoException {
        return new JpaTransactionManager(emf);
    }

    @Bean
    public AuthenticationService authenticationService() {
        return new AuService();
    }

    @Bean
    public AccessVerificationDAO accessVerificationDAO(JdbcTemplate template) {
        return new AccessVerificationDAO(template);
    }
}
