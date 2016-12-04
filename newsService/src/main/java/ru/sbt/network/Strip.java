package ru.sbt.network;

import messages.Command;
import messages.Response;

public interface Strip {
    Response addPost(Command command);
}
