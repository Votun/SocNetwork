package ru.sbt.network;

import objects.Account;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runners.Parameterized;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.jdbc.core.JdbcTemplate;
import ru.sbt.network.dao.AccountRegDAO;

import java.util.List;
import java.util.Map;


public class AccountDaoTest {
    private static AccountRegDAO testDao;
    private static JdbcTemplate template;
    int id;
    @Parameterized.Parameter
    private Account acc1 = new Account("first", "James", "Bond");
    @Parameterized.Parameter
    private Account acc2 = new Account("second", "Mata", "Hary");

    @BeforeClass
    public static void beforeTests() {
        AnnotationConfigApplicationContext ctx = new AnnotationConfigApplicationContext(TestRegisterServiceConfig.class);
        testDao = ctx.getBean(AccountRegDAO.class);
        template = ctx.getBean(JdbcTemplate.class);
    }

    @Test
    public void insertTest() {
        testDao.insert(acc1);
        List<Map<String, Object>> accountList = template.queryForList("SELECT * FROM accounts;");
        for (Map<String, Object> account : accountList) {
            System.out.println(account);
        }
    }

    @Before
    public void setUpDeleteTest() {
        id = testDao.insert(acc2);
    }

    @Test
    public void deleteTest() {
        testDao.delete(id);
        Map<String, Object> account = template.queryForMap("SELECT * FROM accounts;");
        System.out.println(account);
    }
}
