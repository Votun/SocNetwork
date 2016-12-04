package ru.sbt.network;


import messages.Command;
import messages.Response;

public interface PhotoManager {

    Response addAlbom(Command command);

    Response deleteAlbom(Command command);

    Response getAlbom(Command command);

    Response addPhoto(Command command);

    Response deletePhoto(Command command);

    Response getPhoto(Command command);

}
