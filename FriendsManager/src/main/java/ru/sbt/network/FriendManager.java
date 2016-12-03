package ru.sbt.network;


import messages.Command;
import messages.Response;

public interface FriendManager {
    Response addFriend(Command command);

    Response getFriendList(Command command);

    Response deleteFriend(Command command);
}
