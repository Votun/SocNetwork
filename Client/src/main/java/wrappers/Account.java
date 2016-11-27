package wrappers;

import java.awt.*;

public class Account {
    private final long ID;
    private String name;
    private Image icon;

    public Account(String name, Image icon, int ID) {
        this.name = name;
        this.icon = icon;
        this.ID = ID;
    }

    public String getName() {
        return name;
    }

    public void changeName(String name) {
        this.name = name;
    }

    public Image getIcon() {
        return icon;
    }

    public void changeIcon(Image icon) {
        this.icon = icon;
    }

    public long getID() {
        return ID;
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
        int result = name.hashCode();
        result = 31 * result + (icon != null ? icon.hashCode() : 0);
        result = 31 * result + (int) (ID ^ (ID >>> 32));
        return result;
    }
}
