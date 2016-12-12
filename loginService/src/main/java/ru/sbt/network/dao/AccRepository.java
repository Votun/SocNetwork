package ru.sbt.network.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import ru.sbt.network.objects.Account;

import java.sql.Timestamp;


public interface AccRepository extends JpaRepository<Account, Long> {
    Account findByLogin(String login);

    @Modifying
    @Query("UPDATE Account a  SET a.isOnline = true WHERE a.ID = ?1")
    int setOnline(long id);

    @Modifying
    @Query("UPDATE Account a SET a.isOnline = false, a.lastAccess = ?1 WHERE a.ID = ?2")
    int setOffline(Timestamp time, long id);
}

