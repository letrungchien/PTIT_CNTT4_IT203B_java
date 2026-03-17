package Session8.Bai2;

import Session8.Bai1.Factory.Light;

public class Main {
    static void main() {
        // xem nhiet do
        OldThermometer old = new OldThermometer();
        TemperatureSensor t1 = new ThermometerAdapter(old);

        double res = t1.getTemperatureCelsius();
        System.out.printf("Nhiet do hien tai : %.2f " , res);
        System.out.println();
        // che do roi nha
        SmartHomeFacade s = new SmartHomeFacade(t1);
        s.leaveHome();

        // che do ngu
        s.sleepMode();
    }
}
