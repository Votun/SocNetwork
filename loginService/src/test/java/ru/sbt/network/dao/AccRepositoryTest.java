package ru.sbt.network.dao;

import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runners.Parameterized;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.support.TransactionTemplate;
import ru.sbt.network.AuService;
import ru.sbt.network.MainConfig;
import ru.sbt.network.objects.Account;

import static ru.sbt.network.AuService.inTransaction;


public class AccRepositoryTest {
    private static AccRepository accRepository;

    private static TransactionTemplate tt;
    @Parameterized.Parameter
    private Account acc1 = new Account("first", "James", "Bond");
    @Parameterized.Parameter
    private Account acc2 = new Account("second", "Mata", "Hary");

    @BeforeClass
    public static void beforeTests() {
        AnnotationConfigApplicationContext ctx = new AnnotationConfigApplicationContext(MainConfig.class);
        JdbcTemplate template = ctx.getBean(JdbcTemplate.class);
        accRepository = ctx.getBean(AccRepository.class);
        final PlatformTransactionManager transactionalManager = ctx.getBean(PlatformTransactionManager.class);
        tt = new TransactionTemplate(transactionalManager);
    }

    @Test
    public void findByLoginTest() throws Exception {
        System.out.println(accRepository.findByLogin("first").getFirst_Name());
    }

    @Test
    public void setOnline() throws Exception {
        inTransaction(tt, () -> {
            System.out.println(accRepository.setOnline(1));
            System.out.println(accRepository.findByLogin("first").isOnline());
        });
    }

    @Test
    public void setOffline() throws Exception {
        inTransaction(tt, () -> {
            System.out.println(accRepository.setOffline(AuService.getCurTime(), 1));
            System.out.println(accRepository.findByLogin("first").isOnline());
        });
    }


}