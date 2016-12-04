package ru.sbt.network;

import objects.Account;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import ru.sbt.network.dao.AccountRegDAO;

import java.sql.SQLException;

@Component
public class RegistrationService implements Registration {
    private final Account account;
    private final String password;
    private AccountRegDAO registerDao;


    public RegistrationService(Account account, String password) {
        this.account = account;
        this.password = password;
    }

    @Autowired
    public void setDao(AccountRegDAO registerDao) {
        this.registerDao = registerDao;
    }

    public void registerAccount() throws SQLException {
        if (registerDao.checkUnic(account)) {
            registerDao.insert(account);
        }
    }
}
