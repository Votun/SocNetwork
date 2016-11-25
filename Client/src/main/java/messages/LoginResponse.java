package messages;



import javax.swing.*;
import java.util.List;
import java.util.Set;

import ClientLogic.*;

public class LoginResponse implements Response {
    private String name;
    Set<Account> accountList;
    List<ImageIcon> imageSamples;
    List<Post> posts;

    @Override
    public void getData() {

    }
}
