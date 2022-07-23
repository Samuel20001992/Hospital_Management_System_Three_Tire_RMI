package DataTypes;

import app.database.BaseModel;

public class Password extends BaseModel {

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    private int id;
    private String password;

    public Password(int id, String password) {
        this.id = id;
        this.password = password;
    }



    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Override
    public String toString() {
        return "Password{" + "id=" + id + ", password='" + password + '\'' + '}';
    }


    @Override
    public Password clone() throws CloneNotSupportedException {
        return new Password(getId(),getPassword());
    }
}
