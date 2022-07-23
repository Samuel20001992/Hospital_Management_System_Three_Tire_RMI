package DataTypes;

import app.database.BaseModel;

import java.io.Serializable;
import java.sql.Date;

public class Patient extends BaseModel implements Serializable {
    private static final long serialVersionUID= 652968;
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    private int id;
    private String firstName;
    private String middleName;
    private String lastName;
    private String sex;
    private int age;
    private int phoneNumber;
    private String address;
    private Date registrationDate;


    public Patient(int id, String firstName, String middleName, String lastName, String sex, int age, int phoneNumber, String address, Date registrationDate) {
        this.id = id;
        this.firstName = firstName;
        this.middleName = middleName;
        this.lastName = lastName;
        setSex(sex);
        this.age = age;
        this.phoneNumber = phoneNumber;
        this.address = address;
        this.registrationDate = registrationDate;
    }

//    public int getId() {
//        return id;
//    }
//
//    public void setId(int id) {
//        this.id = id;
//    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getMiddleName() {
        return middleName;
    }

    public void setMiddleName(String middleName) {
        this.middleName = middleName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        if(sex.length() > 1) {
            String firstChar = sex.substring(0,1);
            System.err.println("Warning: the sex should be only a single char ( provided string '" + sex + "' ), selecting only the first character '" + firstChar + "'." );
            this.sex = sex.substring(0,1);
        }
        else {
            this.sex = sex;
        }
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public int getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(int phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public Date getRegistrationDate() {
        return registrationDate;
    }

    public void setRegistrationDate(Date registrationDate) {
        this.registrationDate = registrationDate;
    }

    @Override
    public String toString() {
        return "Patient{" +
                "id=" + id +
                ", firstName='" + firstName + '\'' +
                ", middleName='" + middleName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", sex='" + sex + '\'' +
                ", age=" + age +
                ", phoneNumber=" + phoneNumber +
                ", address='" + address + '\'' +
                ", registrationDate=" + registrationDate +
                '}';
    }

    @Override
    protected Patient clone() throws CloneNotSupportedException {
        return new Patient(
                getId(),
                getFirstName(),
                getMiddleName(),
                getLastName(),
                getSex(),
                getAge(),
                getPhoneNumber(),
                getAddress(),
                getRegistrationDate()
        );
    }
}
