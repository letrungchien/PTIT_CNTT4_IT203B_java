package Session8.Bai5;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        Light light = new Light();
        Fan fan = new Fan();
        AirConditioner ac = new AirConditioner();

        TemperatureSensor sensor = new TemperatureSensor();

        sensor.attach(fan);
        sensor.attach(ac);

        Command lightOff = new LightOffCommand(light);
        Command acTemp28 = new ACSetTemperatureCommand(ac, 28);
        Command fanLow = new FanLowCommand(fan);

        Command sleepMode = new SleepModeCommand(
                new Command[]{lightOff, acTemp28, fanLow});

        while (true) {

            System.out.println("\n1. Kich hoat Sleep Mode");
            System.out.println("2. Thay doi nhiet do");
            System.out.println("3. Xem trang thai thiet bi");
            System.out.println("0. Thoat");

            int choice = sc.nextInt();

            switch (choice) {

                case 1:
                    sleepMode.execute();
                    break;

                case 2:
                    System.out.print("Nhap nhiet do: ");
                    int temp = sc.nextInt();
                    sensor.setTemperature(temp);
                    break;

                case 3:
                    System.out.println(light.getStatus());
                    System.out.println(fan.getStatus());
                    System.out.println(ac.getStatus());
                    break;

                case 0:
                    return;
            }
        }
    }
}
