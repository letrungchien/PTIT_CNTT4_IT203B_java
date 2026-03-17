package Session8.Bai4;

public class Fan implements Observer{
    @Override
    public void update(int temperature) {
        if (temperature < 20){
            System.out.println("Nhiet do thap , tat quat");
        }else if (temperature > 20 && temperature <= 25){
            System.out.println("Quat chay muc trung binh");
        }else {
            System.out.println("Quat chay so to nhat");
        }
    }
}
