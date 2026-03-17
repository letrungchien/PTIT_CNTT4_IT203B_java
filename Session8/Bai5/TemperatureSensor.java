package Session8.Bai5;

import java.util.ArrayList;
import java.util.List;

public class TemperatureSensor implements Subject {

    private List<Observer> observers = new ArrayList<>();
    private int temperature;

    public void setTemperature(int temperature) {
        this.temperature = temperature;
        System.out.println("Nhiet do moi: " + temperature + "C");
        notifyObservers();
    }

    public void attach(Observer o) {
        observers.add(o);
    }

    public void notifyObservers() {
        for (Observer o : observers) {
            o.update(temperature);
        }
    }
}
