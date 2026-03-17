package Session8.Bai3;
import bai1.Factory.Light;

public class LightOffCommand implements Command{
    protected Light light;

    public LightOffCommand(Light light) {
        this.light = light;
    }

    @Override
    public void execute() {
        light.turnOff();
    }

    @Override
    public void undo() {
        light.turnOn();
    }
}
