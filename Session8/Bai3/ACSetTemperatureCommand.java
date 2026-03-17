package Session8.Bai3;

import bai1.Factory.AirConditioner;
import bai2.OldThermometer;
import bai2.TemperatureSensor;
import bai2.ThermometerAdapter;

public class ACSetTemperatureCommand implements Command{
    // de luu nhiet do cu
    protected AirConditioner airConditioner;
    protected Double newCon;
    protected Double oldCon;

    public ACSetTemperatureCommand(AirConditioner airConditioner, Double newCon) {
        this.airConditioner = airConditioner;
        this.newCon = newCon;
    }


    OldThermometer old = new OldThermometer();
    TemperatureSensor t = new ThermometerAdapter(old);
    double res = t.getTemperatureCelsius();

    @Override
    public void execute() {
        oldCon = airConditioner.setTemperature(res);
        airConditioner.setTemperature(newCon);
    }

    @Override
    public void undo() {
        airConditioner.setTemperature(oldCon);
    }
}
