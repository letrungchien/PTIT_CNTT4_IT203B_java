package Session8.Bai5;

public class Light {
    private boolean isOn = true;

    public void off() {
        isOn = false;
        System.out.println("Den tat");
    }

    public String getStatus() {
        return isOn ? "Den dang bat" : "Den dang tat";
    }
}
