package messages;


public class LoginCommand implements Command{
    private String name;
    private String password;

    public LoginCommand(String name, String password) {
        this.name = name;
        this.password = password;
    }

    @Override
    public byte[] toBytes() {
        String message = "<<LOGIN>>" +
                name +
                ";;" +
                password +
                "<<END>>";
        return message.getBytes();
    }
}
