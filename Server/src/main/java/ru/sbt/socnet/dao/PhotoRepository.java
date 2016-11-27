package ru.sbt.socnet.dao;


import wrappers.Account;
import wrappers.Photo;

import java.util.List;

public interface PhotoRepository {

    void addAccount(Account account);

    void addPhoto(Account account, Photo photo);

    List<Photo> getPhotos(Account account);

    void deletePhoto(Account account, Photo photo);

}
