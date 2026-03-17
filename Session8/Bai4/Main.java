package Session8.Bai4;

import java.util.Scanner;

public class Main {
    static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        TemperatureSensor sensor = new TemperatureSensor();

        Fan fan = new Fan();
        Humidifier humidifier = new Humidifier();

        while (true) {

            System.out.println("\n1. Dang ky Fan");
            System.out.println("2. Dang ky Humidifier");
            System.out.println("3. Thay doi nhiet do");
            System.out.println("0. Thoat");

            int choice = sc.nextInt();

            switch (choice) {

                case 1:
                    sensor.attach(fan);
                    break;

                case 2:
                    sensor.attach(humidifier);
                    break;

                case 3:
                    System.out.print("Nhap nhiet do: ");
                    int temp = sc.nextInt();
                    sensor.setTemperature(temp);
                    break;

                case 0:
                    return;
            }
        }
    }
}
