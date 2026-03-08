package Session1.Baitap.Bai3;

import Session1.Baitap.Bai5.InvalidAgeException;

public class User {

    private String name;
    private int age;

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    public void setName(String name) {


        if (name != null) {
            this.name = name;
        } else {
            System.out.println("Tên không được null");
        }

    }

    public void setAge(int age) throws InvalidAgeException {


        if (age < 0) {
            throw new InvalidAgeException("Tuổi không thể âm!");
        }

        this.age = age;
    }

    public void printUser() {


        if (name != null) {
            System.out.println("Tên: " + name);
        } else {
            System.out.println("Tên chưa được thiết lập");
        }

        System.out.println("Tuổi: " + age);
    }
}