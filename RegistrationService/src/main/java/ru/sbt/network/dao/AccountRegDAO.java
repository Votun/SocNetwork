package ru.sbt.network.dao;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.namedparam.BeanPropertySqlParameterSource;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;
import org.springframework.jdbc.core.simple.SimpleJdbcInsert;
import org.springframework.stereotype.Component;
import wrappers.Account;

import javax.sql.DataSource;
import java.util.HashMap;
import java.util.Map;

@Component
public class AccountRegDAO {
    private final SimpleJdbcInsert insertAccount;
    private JdbcTemplate template;

    @Autowired
    public AccountRegDAO(DataSource dataSource) {
        this.template = new JdbcTemplate(dataSource);
        insertAccount = new SimpleJdbcInsert(dataSource);
    }

    public boolean checkUnic(Account account, String password) {
        String login = account.getLogin();
        Map<String, Object> result = template.queryForMap("SELECT login FROM accounts where login = ?", login);
        return (!result.isEmpty());
    }

    public void insert(Account account, String password) {
        Number id = updateAccountsTable(account);
        updatePasswordTable(id, password);
    }

    private Number updateAccountsTable(Account account) {
        insertAccount.withTableName("accounts");
        SqlParameterSource params = new BeanPropertySqlParameterSource(account);
        Number result = insertAccount.executeAndReturnKey(params);
        System.out.println("New account id:" + result);
        return result;
    }

    private void updatePasswordTable(Number id, String password) {
        Map<String, ? super Object> paramMap = new HashMap<>();
        paramMap.put("id", id);
        paramMap.put("password", password);
        insertAccount.withTableName("access").execute(paramMap);
    }
}
