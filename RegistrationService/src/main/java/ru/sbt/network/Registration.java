package ru.sbt.network;


import org.springframework.stereotype.Service;

import java.sql.SQLException;

@Service
public interface Registration {

    void registerAccount() throws SQLException;

}
