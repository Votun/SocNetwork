package ru.sbt.network.dao;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;

public class AccessTokenDAO {
    private final JdbcTemplate template;

    @Autowired
    public AccessTokenDAO(JdbcTemplate template) {
        this.template = template;
    }

    public void addToken(Number id, String password) {
        final String query = "INSERT INTO ACCESS_TOKENS " +
                "(account_id, pswd, ) VALUES (?, ?)";

        template.update(query, id, password);
    }

    public int delete(int accountID, String password) {
        return template.update("DELETE FROM accessTokens WHERE account_id = ? AND pswd = ?", accountID, password);
    }
}
