package Session8.Bai1.Factory;

public class Light implements Device{

    @Override
    public void turnOn() {
        System.out.println("Da bat den");
    }

    @Override
    public void turnOff() {
        System.out.println("Da tat den");
    }

    @Override
    public void setLowSpeed() {
        System.out.println("Anh sang thap");
    }
}
