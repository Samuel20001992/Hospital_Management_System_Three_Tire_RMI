package DataTypes;

import app.database.BaseModel;

public class Department extends BaseModel {

    private int id;
    private String name;
    private int headId = -1;
    private int phoneNumber;
    private String email;

    // Set Everything
    public Department(int id, String name, int headId, int phoneNumber, String email) {
        this.id = id;
        this.name = name;
        this.headId = headId;
        this.phoneNumber = phoneNumber;
        this.email = email;
    }

    //Without Id
    public Department(String name, int headId, int phoneNumber, String email) {
        this.name = name;
        this.headId = headId;
        this.phoneNumber = phoneNumber;
        this.email = email;
    }

    //Without head id
    public Department(int id, String name, int phoneNumber, String email) {
        this.id = id;
        this.name = name;
        this.phoneNumber = phoneNumber;
        this.email = email;
    }


    // Without Id and Head Id
    public Department(String name, int phoneNumber, String email) {
        this.name = name;
        this.phoneNumber = phoneNumber;
        this.email = email;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getHeadId() {
        return headId;
    }

    public void setHeadId(int headId) {
        this.headId = headId;
    }

    public int getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(int phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }


    @Override
    public String toString() {
        return "Department{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", headId=" + headId +
                ", phoneNumber=" + phoneNumber +
                ", email='" + email + '\'' +
                '}';
    }

    @Override
    public Department clone() throws CloneNotSupportedException {
        return new Department(
                id,
                name,
                headId,
                phoneNumber,
                email
        );
    }
}
