package Session8.Bai5;

public class Fan implements Observer {

    private String speed = "OFF";

    public void setLow() {
        speed = "LOW";
        System.out.println("Quat muc thap");
    }

    @Override
    public void update(int temperature) {

        if (temperature < 20) {
            speed = "OFF";
        }
        else if (temperature <= 25) {
            speed = "MEDIUM";
        }
        else {
            speed = "HIGH";
        }

        System.out.println("Quat tu dong dieu chinh: " + speed);
    }

    public String getStatus() {
        return "Quat: " + speed;
    }
}
