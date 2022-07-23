package app.database;

public abstract class BaseModel implements Cloneable {
    public int id;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Override
    public abstract BaseModel clone() throws CloneNotSupportedException;
}
