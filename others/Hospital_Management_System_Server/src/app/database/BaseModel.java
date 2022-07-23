package app.database;

public abstract class BaseModel implements Cloneable {
    protected int id;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Override
    protected abstract BaseModel clone() throws CloneNotSupportedException;
}
