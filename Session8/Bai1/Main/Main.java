package Session8.Bai1.Main;

import bai1.Factory.*;
import bai1.Singleton.HardwareConnection;

import java.util.Scanner;

public class Main {
    static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        HardwareConnection connection = null;
        Device device = null;

        while (true) {

            System.out.println("\n===== MENU =====");
            System.out.println("1. Ket noi phan cung");
            System.out.println("2. Tao thiet bi");
            System.out.println("3. Bat thiet bi");
            System.out.println("4. Tat thiet bi");
            System.out.println("5. Thoat");

            int choice = sc.nextInt();

            switch (choice) {

                case 1:
                    connection = HardwareConnection.getInstence();
                    connection.connect();
                    break;

                case 2:
                    System.out.println("Chon thiet bi:");
                    System.out.println("1. Light");
                    System.out.println("2. Fan");
                    System.out.println("3. AirConditioner");

                    int type = sc.nextInt();
                    DeviceFactory factory = null;

                    if (type == 1) factory = new LightFactory();
                    if (type == 2) factory = new FanFactory();
                    if (type == 3) factory = new AirConditionerFactory();

                    if (factory != null) {
                        device = factory.createDevice();
                        System.out.println("Da tao thiet bi");
                    }
                    break;

                case 3:
                    if (device != null) {
                        device.turnOn();
                    } else {
                        System.out.println("Chua tao thiet bi");
                    }
                    break;

                case 4:
                    if (device != null) {
                        device.turnOff();
                    } else {
                        System.out.println("Chua tao thiet bi");
                    }
                    break;

                case 5:
                    System.out.println("Thoat chuong trinh");
                    return;
            }
        }
    }

}
