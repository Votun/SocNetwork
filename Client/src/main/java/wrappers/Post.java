package wrappers;


import java.awt.*;

public class Post {
    private final Account author;
    private String text;
    private Image illustration;

    public Post(Account author, String text, Image illustration) {
        this.author = author;
        this.text = text;
        this.illustration = illustration;
    }

    public Account getAuthor() {
        return author;
    }

    public String getText() {
        return text;
    }

    public Image getIllustration() {
        return illustration;
    }
}
