package ru.sbt.socnet.dao;


public interface PasswordDAO {
    void add(String login, String password);

    int getID(String login, String password);
}
