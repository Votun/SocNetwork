package ru.sbt.network.dao;

import org.junit.Before;
import org.junit.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.support.TransactionTemplate;
import ru.sbt.network.MainConfig;


public class AccessVerificationDAOTest {
    private AccessVerificationDAO accessDao;
    private TransactionTemplate tt;

    @Before
    public void beforeTest() {
        AnnotationConfigApplicationContext ctx = new AnnotationConfigApplicationContext(MainConfig.class);
        JdbcTemplate template = ctx.getBean(JdbcTemplate.class);
        accessDao = ctx.getBean(AccessVerificationDAO.class);
        final PlatformTransactionManager transactionalManager = ctx.getBean(PlatformTransactionManager.class);
        tt = new TransactionTemplate(transactionalManager);
    }

    @Test
    public void verifyTest() throws Exception {
        System.out.println(accessDao.verify(1, "12345"));
        System.out.println(accessDao.verify(1, "2314"));

    }

}