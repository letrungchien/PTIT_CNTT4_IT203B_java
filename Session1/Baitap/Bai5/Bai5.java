package Session1.Baitap.Bai5;

import Session1.Baitap.Bai3.User;

public class Bai5 {
    public static void main(String[] args) {

        User user = new User();

        try {
            user.setAge(-5);
        } catch (InvalidAgeException e) {
            System.out.println("Lỗi: " + e.getMessage());
        }

    }
}
