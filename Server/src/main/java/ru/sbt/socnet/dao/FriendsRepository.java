package ru.sbt.socnet.dao;

import wrappers.Account;

import java.util.Set;

public interface FriendsRepository {
    void addAccount(Account account);

    void addFriend(Account account, Account friend);

    Set<Account> getFriendList(Account account);

    void deleteFriend(Account account, Account formerFriend);

}
