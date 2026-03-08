package Session1.lythuyet;

import java.util.Date;

public class Employee {
    private String empId;
    private String fullname;
    private boolean gender;
    private Date    birthday;
    private String   address;
    private float    yearInWorks;
    private  double salary;

    public Employee(String address, Date birthday, String empId, String fullname, boolean gender, double salary, float yearInWorks) {
        this.address = address;
        this.birthday = birthday;
        this.empId = empId;
        this.fullname = fullname;
        this.gender = gender;
        this.salary = salary;
        this.yearInWorks = yearInWorks;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public Date getBirthday() {
        return birthday;
    }

    public void setBirthday(Date birthday) {
        this.birthday = birthday;
    }

    public String getEmpId() {
        return empId;
    }

    public void setEmpId(String empId) {
        this.empId = empId;
    }

    public String getFullname() {
        return fullname;
    }

    public void setFullname(String fullname) {
        this.fullname = fullname;
    }

    public boolean isGender() {
        return gender;
    }

    public void setGender(boolean gender) {
        this.gender = gender;
    }

    public double getSalary() {
        return salary;
    }

    public void setSalary(double salary) {
        this.salary = salary;
    }

    public float getYearInWorks() {
        return yearInWorks;
    }

    public void setYearInWorks(float yearInWorks) {
        this.yearInWorks = yearInWorks;
    }
}
