package Session8.Bai3;

import bai1.Factory.Fan;

public class FanOnCommand implements Command{
    protected Fan fan;

    public FanOnCommand(Fan fan) {
        this.fan = fan;
    }

    @Override
    public void execute() {
        fan.turnOn();
    }

    @Override
    public void undo() {
        fan.turnOff();
    }
}
