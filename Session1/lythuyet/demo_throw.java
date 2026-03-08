package Session1.lythuyet;


import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

public class demo_throw {
    public static void main(String[] args) {
        Date birthday;

        Scanner sc =new Scanner(System.in);
        System.out.println("nhập vào ngày sinh của bạn");
        SimpleDateFormat sdf =new SimpleDateFormat("dd/MM/yyyy");
        try {
            birthday =sdf.parse(sc.nextLine());
        }catch (ParseException e){

        }
    }
}
