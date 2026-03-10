package Session3.lythu;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;

public class demo_datetime {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");

        System.out.print("Nhập ngày sinh (dd/MM/yyyy): ");
        String input = sc.nextLine();

        LocalDateTime birthday = LocalDateTime.parse(input + " 00:00",
                DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm"));

        System.out.println("Ngày sinh: " + birthday.format(formatter));
    }
}