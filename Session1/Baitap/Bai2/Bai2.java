package Session1.Baitap.Bai2;

import java.util.Scanner;

public class Bai2 {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        try {
            System.out.print("Nhập tổng số người: ");
            int tongNguoi = scanner.nextInt();

            System.out.print("Nhập số nhóm: ");
            int soNhom = scanner.nextInt();

            int moiNhom = tongNguoi / soNhom;

            System.out.println("Mỗi nhóm có: " + moiNhom + " người");

        } catch (ArithmeticException e) {
            System.out.println("Không thể chia cho 0!");
        } finally {
            scanner.close();
            System.out.println("Thực hiện dọn dẹp tài nguyên trong finally...");
        }
    }
}
