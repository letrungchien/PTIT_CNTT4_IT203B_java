package bai1.Factory;

public class Fan implements Device{


    @Override
    public void turnOn() {
        System.out.println("Da bat quat");
    }

    @Override
    public void turnOff() {
        System.out.println("Da tat quat");
    }

    @Override
    public void setLowSpeed() {
        System.out.println("Quat chay toc do thap");
    }
}
