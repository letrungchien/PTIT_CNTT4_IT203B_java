package Session8.Bai5;

public class AirConditioner implements Observer {

    private int temperature = 25;

    public void setTemperature(int temp) {
        temperature = temp;
        System.out.println("Dieu hoa dat " + temp + "C");
    }

    @Override
    public void update(int temp) {

        if (temp > 28) {
            temperature = 24;
        }

        System.out.println("Dieu hoa tu dong dieu chinh: " + temperature + "C");
    }

    public String getStatus() {
        return "Dieu hoa: " + temperature + "C";
    }
}
