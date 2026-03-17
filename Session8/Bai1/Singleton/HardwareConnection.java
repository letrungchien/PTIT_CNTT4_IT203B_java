package Session8.Bai1.Singleton;

public class HardwareConnection {
    // tạo instence
    private static HardwareConnection instence;

    private  HardwareConnection(){
        System.out.println("khoi tao");
    }

    public static HardwareConnection getInstence() {
        if (instence == null){
            instence = new HardwareConnection();
        }
        return instence;
    }

    // phuong thuc xu li thanh cong
    public void connect(){
        System.out.println("Da ket noi thanh cong");
    }
    // phuong thuc xu li that bai
    public void disconnect(){
        System.out.println("Ket noi that bai");
    }
}
