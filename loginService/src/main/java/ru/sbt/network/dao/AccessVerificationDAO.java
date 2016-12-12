package ru.sbt.network.dao;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;

public class AccessVerificationDAO {
    private final JdbcTemplate template;

    @Autowired
    public AccessVerificationDAO(JdbcTemplate template) {
        this.template = template;
    }

    public boolean verify(long acc_id, String password) {
        try {
            String query = "SELECT * from ACCESSTOKENS WHERE acc_id = ? AND pswd = ?";
            Number id = (Number) template.queryForMap(query, acc_id, password).get(acc_id);
            return true;
        } catch (EmptyResultDataAccessException emResEx) {
            return false;
        }
    }
}
