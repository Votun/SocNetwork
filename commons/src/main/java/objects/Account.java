package objects;

public class Account {
    private final String login;
    private long ID;
    private String first_name;
    private String last_name;

    public Account(String login, String first_name, String last_name) {
        this.first_name = first_name;
        this.last_name = last_name;
        this.login = login;
    }

    public String getFirst_Name() {
        return first_name;
    }

    public String getLast_name() {
        return last_name;
    }

    public String getLogin() {
        return login;
    }

    public long getID() {
        return ID;
    }

    public void setID(long id) {
        this.ID = id;
    }



    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Account account = (Account) o;

        return ID == account.ID;

    }

    @Override
    public int hashCode() {
        int result = (int) (ID ^ (ID >>> 32));
        result = 31 * result + login.hashCode();
        return result;
    }
}
