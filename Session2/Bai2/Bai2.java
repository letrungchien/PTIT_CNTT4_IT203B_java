package Session2.Bai2;

import java.util.Scanner;

public class Bai2 {
    public static void main(String[] args) {
        passwordValidator validator= password -> password.length() >=8;

        String password;
        Scanner sc =new Scanner(System.in);
        System.out.println("Nhap pass de kie tra");
        password= sc.nextLine();
        if(validator.isValid(password)){
            System.out.println("Mật hợp lệ");
        }else {
            System.out.println("Mật khẩu không hợp lệ ");
        }
    }
}
@FunctionalInterface
interface passwordValidator{
    boolean isValid(String password);
}