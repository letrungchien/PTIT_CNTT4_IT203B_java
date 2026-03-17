package Session8.Bai3;

import bai1.Factory.Fan;

public class FanOffCommand implements Command{
    protected Fan fan;

    public FanOffCommand(Fan fan) {
        this.fan = fan;
    }

    @Override
    public void execute() {
        fan.turnOff();
    }

    @Override
    public void undo() {
        fan.turnOn();
    }
}
