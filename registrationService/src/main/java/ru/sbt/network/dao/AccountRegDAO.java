package ru.sbt.network.dao;


import objects.Account;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.context.annotation.Scope;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.namedparam.BeanPropertySqlParameterSource;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;
import org.springframework.jdbc.core.simple.SimpleJdbcInsert;
import org.springframework.stereotype.Component;

import java.util.Map;

@Component
@Scope(BeanDefinition.SCOPE_PROTOTYPE)
public class AccountRegDAO {
    private SimpleJdbcInsert insertAccount;
    private JdbcTemplate template;

    @Autowired
    public AccountRegDAO(JdbcTemplate jdbcTemplate) {
        template = jdbcTemplate;
    }


    /**
     * login should be unic. Это нужно отслеживать в бизнес-логике
     *
     * @param account
     * @return
     */
    public boolean checkUnic(Account account) {
        String login = account.getLogin();
        try {
            Map<String, Object> result = template.queryForMap("SELECT login FROM accounts where login = ?", login);
            return false;
        } catch (EmptyResultDataAccessException emResEx) {
            return true;
        }
    }

    public void insert(Account account) {
        insertAccount = new SimpleJdbcInsert(template);
        insertAccount.withTableName("accounts");
        SqlParameterSource params = new BeanPropertySqlParameterSource(account);
        insertAccount.usingGeneratedKeyColumns("acc_id");
        insertAccount.usingColumns("login", "first_name", "last_name");
        int result = insertAccount.executeAndReturnKey(params).intValue();
        System.out.println("New account id:" + result);
        account.setID(result);
    }

    public int delete(Number accountID) {
        return template.update("DELETE FROM accounts WHERE acc_id = ?", accountID);
    }
}
