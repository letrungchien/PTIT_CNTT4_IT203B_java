package Session8.Bai1.Factory;

public class AirConditioner implements Device{
    @Override
    public void turnOn() {
        System.out.println("Da bat dieu hoa");
    }

    @Override
    public void turnOff() {
        System.out.println("Da tat dieu hoa");
    }

    @Override
    public void setLowSpeed() {
        System.out.println("Nhiet do o muc phu hop");
    }

    public double setTemperature(double temp) {
        return temp;
    }
}
