package messages;


import wrappers.Account;
import wrappers.Post;

import javax.swing.*;
import java.util.List;
import java.util.Set;

public class LoginResponse implements Response {
    Set<Account> accountList;
    List<ImageIcon> imageSamples;
    List<Post> posts;
    private String name;

    @Override
    public void getData(byte[] bytes) {

    }
}

