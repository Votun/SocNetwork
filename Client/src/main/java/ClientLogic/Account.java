package ClientLogic;

import java.awt.*;

public class Account {
    private String name;
    private Image icon;
    private final int ID;

    public Account(String name, Image icon, int ID) {
        this.name = name;
        this.icon = icon;
        this.ID = ID;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Image getIcon() {
        return icon;
    }

    public void setIcon(Image icon) {
        this.icon = icon;
    }

    public int getID() {
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
        return ID;
    }
}
