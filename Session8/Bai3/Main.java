package Session8.Bai3;

import bai1.Factory.AirConditioner;
import bai1.Factory.Fan;
import bai1.Factory.Light;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        Light light = new Light();
        Fan fan = new Fan();
        AirConditioner ac = new AirConditioner();

        UndoManager undoManager = new UndoManager();
        RemoteControl remote = new RemoteControl(3, undoManager);

        remote.setCommand(0,
                new LightOnCommand(light),
                new LightOffCommand(light));

        remote.setCommand(1,
                new FanOnCommand(fan),
                new FanOffCommand(fan));

        remote.setCommand(2,
                new ACSetTemperatureCommand(ac, 20.0),
                new ACSetTemperatureCommand(ac, 25.0));

        while (true) {

            System.out.println("\n1. Light ON");
            System.out.println("2. Light OFF");
            System.out.println("3. Fan ON");
            System.out.println("4. Fan OFF");
            System.out.println("5. AC set 20C");
            System.out.println("6. AC set 25C");
            System.out.println("7. Undo");
            System.out.println("0. Exit");

            int choice = sc.nextInt();

            switch (choice) {

                case 1:
                    remote.pressOn(0);
                    break;

                case 2:
                    remote.pressOff(0);
                    break;

                case 3:
                    remote.pressOn(1);
                    break;

                case 4:
                    remote.pressOff(1);
                    break;

                case 5:
                    remote.pressOn(2);
                    break;

                case 6:
                    remote.pressOff(2);
                    break;

                case 7:
                    remote.undo();
                    break;

                case 0:
                    return;
            }
        }
    }
}
