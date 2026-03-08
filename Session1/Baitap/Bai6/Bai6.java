package Session1.Baitap.Bai6;

import Session1.Baitap.Bai3.User;
import Session1.Baitap.Bai5.InvalidAgeException;

public class Bai6{

    public static void main(String[] args) {

        User user = new User();

        try {

            user.setName("Chien");
            user.setAge(-5);

            user.printUser();

        } catch (InvalidAgeException e) {

            Logger.logError(e.getMessage());

        }

    }
}