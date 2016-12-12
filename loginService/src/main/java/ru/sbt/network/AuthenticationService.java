package ru.sbt.network;


import org.springframework.expression.AccessException;
import ru.sbt.network.objects.Account;

public interface AuthenticationService {

    Account login(String login, String password) throws AccessException;

    void logout(long id);
}
