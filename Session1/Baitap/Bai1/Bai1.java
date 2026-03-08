package Session1.Baitap.Bai1;

import java.util.Scanner;

public class Bai1 {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        try {
            System.out.print("Nhập năm sinh: ");
            String namSinhStr = scanner.nextLine();

            int namSinh = Integer.parseInt(namSinhStr);
            int tuoi = 2026 - namSinh;

            System.out.println("Tuổi của bạn là: " + tuoi);

        } catch (NumberFormatException e) {
            System.out.println("Lỗi: Vui lòng nhập năm sinh bằng số!");

        } finally {
            scanner.close();
            System.out.println("Thực hiện dọn dẹp tài nguyên trong finally...");
        }
    }
}
