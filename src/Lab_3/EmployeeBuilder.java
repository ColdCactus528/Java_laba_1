package Lab_3;
import Lab_3.Employee;

public class EmployeeBuilder {
    public void setGivenName(String givenName) {
        this.givenName = givenName;
    }

    public void setSurName(String surName) {
        this.surName = surName;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public void setGender(Employee.Gender gender) {
        this.gender = gender;
    }

    public void setRole(Employee.Role role) {
        this.role = role;
    }

    public void setDept(Employee.Dept dept) {
        this.dept = dept;
    }

    public void setEMail(String eMail) {
        this.eMail = eMail;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public void setState(String state) {
        this.state = state;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public Employee getResult() {
        return new Employee(givenName, surName, age, gender, role, dept, eMail, phone, address, city, state, code);
    }

    private String givenName;
    private String surName;
    private int age;
    private Employee.Gender gender;
    private Employee.Role role;
    private Employee.Dept dept;
    private String eMail;
    private String phone;
    private String address;
    private String city;
    private String state;
    private int code;
}
