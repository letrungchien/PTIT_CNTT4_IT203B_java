package Session8.Bai4;

public class Humidifier implements Observer{

    @Override
    public void update(int temperature) {
        if (temperature > 25) {
            System.out.println("May tao am giam do am");
        }
        else if (temperature < 20) {
            System.out.println("May tao am tang do am");
        }
        else {
            System.out.println("Do am on dinh");
        }
    }
}
