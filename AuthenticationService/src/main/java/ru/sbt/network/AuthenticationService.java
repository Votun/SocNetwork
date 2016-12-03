package ru.sbt.network;


import messages.Command;
import messages.Response;

public interface AuthenticationService {

    Response login(Command loginCommand);

    Response logout(Command logoutCommand);
}
