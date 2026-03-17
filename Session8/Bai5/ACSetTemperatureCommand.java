package Session8.Bai5;

public class ACSetTemperatureCommand implements Command {

    private AirConditioner ac;
    private int temperature;

    public ACSetTemperatureCommand(AirConditioner ac, int temperature) {
        this.ac = ac;
        this.temperature = temperature;
    }

    public void execute() {
        ac.setTemperature(temperature);
    }
}
