package Session8.Bai1.Factory;

public class LightFactory extends DeviceFactory{
    @Override
    public Device createDevice() {
        return new Light();
    }
}
