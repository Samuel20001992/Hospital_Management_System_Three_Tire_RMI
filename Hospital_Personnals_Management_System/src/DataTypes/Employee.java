package DataTypes;

import java.io.Serializable;
import java.sql.Date;

public class Employee implements Serializable {
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
    private String email;
    private String address;
    private Date hiredDate;
    private int salary;
    private String jobType;
    private int departmentId = -1;
    private String imageAddress;

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    private String password;

    public Employee(int id, String firstName, String middleName, String lastName, String sex, int age, int phoneNumber,
                    String email, String address, Date hiredDate, int salary, String jobType, int departmentId,
                    String imageAddress, String password) {
        this.id = id;
        this.firstName = firstName;
        this.middleName = middleName;
        this.lastName = lastName;
        this.sex = sex;
        this.age = age;
        this.phoneNumber = phoneNumber;
        this.email = email;
        this.address = address;
        this.hiredDate = hiredDate;
        this.salary = salary;
        this.jobType = jobType;
        this.departmentId = departmentId;
        this.imageAddress = imageAddress;
        this.password = password;
    }

    // Department Id is optional
    public Employee(int id, String firstName, String middleName, String lastName, String sex, int age, int phoneNumber,
                    String email, String address, Date hiredDate, int salary, String jobType, String imageAddress, String password) {
        this.id = id;
        this.firstName = firstName;
        this.middleName = middleName;
        this.lastName = lastName;
        this.sex = sex;
        this.age = age;
        this.phoneNumber = phoneNumber;
        this.email = email;
        this.address = address;
        this.hiredDate = hiredDate;
        this.salary = salary;
        this.jobType = jobType;
        this.imageAddress = imageAddress;
        this.password = password;
    }



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
        this.sex = sex;
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

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public Date getHiredDate() {
        return hiredDate;
    }

    public void setHiredDate(Date hiredDate) {
        this.hiredDate = hiredDate;
    }

    public int getSalary() {
        return salary;
    }

    public void setSalary(int salary) {
        this.salary = salary;
    }

    public String getJobType() {
        return jobType;
    }

    public void setJobType(String jobType) {
        this.jobType = jobType;
    }

    public int getDepartmentId() {
        return departmentId;
    }

    public void setDepartmentId(int departmentId) {
        this.departmentId = departmentId;
    }

    public String getImageAddress() {
        return imageAddress;
    }

    public void setImageAddress(String imageAddress) {
        this.imageAddress = imageAddress;
    }

    @Override
    public String toString() {
        return "Employee{" + "id=" + id + ", firstName='" + firstName + '\'' + ", middleName='" + middleName + '\''
                + ", lastName='" + lastName + '\'' + ", sex='" + sex + '\'' + ", age=" + age + ", phoneNumber="
                + phoneNumber + ", email='" + email + '\'' + ", address='" + address + '\'' + ", hiredDate=" + hiredDate
                + ", salary=" + salary + ", jobType='" + jobType + '\'' + ", departmentId=" + departmentId
                + ", imageAddress='" + imageAddress + '\'' + '}';
    }

    @Override
    protected Employee clone() throws CloneNotSupportedException {
        return new Employee(
                getId(),
                getFirstName(),
                getMiddleName(),
                getLastName(),
                getSex(),
                getAge(),
                getPhoneNumber(),
                getEmail(),
                getAddress(),
                getHiredDate(),
                getSalary(),
                getJobType(),
                getDepartmentId(),
                getImageAddress(),
                getPassword()
        );
    }
}
