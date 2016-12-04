package ru.sbt.network;


import org.junit.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.sql.SQLException;

public class TestRegistration {


    @Test
    public void registerTest() {
        final AnnotationConfigApplicationContext ctx =
                new AnnotationConfigApplicationContext(TestRegisterServiceConfig.class);
        Registration reg = ctx.getBean(Registration.class);
        try {
            reg.registerAccount();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

}
