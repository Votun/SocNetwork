package ru.sbt.network.dao;


import org.junit.Test;
import ru.sbt.network.AuService;
import ru.sbt.network.AuthenticationService;
import ru.sbt.network.objects.Account;

public class ServiceTest {
    @Test
    public void firstTest() throws Exception {
        AuthenticationService service = new AuService();
        Account acc = service.login("first", "12345");
        System.out.println(acc.getFirst_Name() + " " + acc.getLast_name());
    }

    @Test(expected = NullPointerException.class)
    public void secondTest() throws Exception {
        AuthenticationService service = new AuService();
        Account acc = service.login("first", "qwerty");
        System.out.println(acc.getFirst_Name() + " " + acc.getLast_name());
    }
}
