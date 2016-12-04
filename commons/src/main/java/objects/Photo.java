package objects;


import java.awt.*;
import java.sql.Date;


public class Photo {
    private final Image image;
    private final Date creationDate;
    private final long ID;

    public Photo(Image image, Date creationDate, long ID) {
        this.image = image;
        this.creationDate = creationDate;
        this.ID = ID;
    }

    public Image getImage() {
        return image;
    }

    public Date getCreationDate() {
        return creationDate;
    }

    public long getID() {
        return ID;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Photo photo = (Photo) o;
        return ID == photo.ID;

    }

    @Override
    public int hashCode() {
        int result = image != null ? image.hashCode() : 0;
        result = 31 * result + (creationDate != null ? creationDate.hashCode() : 0);
        result = 31 * result + (int) (ID ^ (ID >>> 32));
        return result;
    }
}
