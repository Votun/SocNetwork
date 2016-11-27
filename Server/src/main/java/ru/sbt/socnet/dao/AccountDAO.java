package ru.sbt.socnet.dao;


import wrappers.Account;

import java.awt.*;
import java.util.Set;

public interface AccountDAO {
    void addAccount(String name, Image icon);

    void removeAccount(long accountId);

    void updateAccount(Account account);

    Account getAccount(long accountId);

    Set<Account> getByName(String name);
}
