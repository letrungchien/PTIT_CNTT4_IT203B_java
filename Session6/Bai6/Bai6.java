package Session6.Bai6;

import java.util.Scanner;

public class 2Bai6{

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        CinemaSystem system = new CinemaSystem();

        while (true) {

            System.out.println("\n===== MENU =====");
            System.out.println("1. Bắt đầu mô phỏng");
            System.out.println("2. Tạm dừng");
            System.out.println("3. Tiếp tục");
            System.out.println("4. Thêm vé");
            System.out.println("5. Xem thống kê");
            System.out.println("6. Phát hiện deadlock");
            System.out.println("7. Thoát");

            int choice = sc.nextInt();

            switch (choice) {

                case 1:

                    System.out.print("Số phòng: ");
                    int rooms = sc.nextInt();

                    System.out.print("Vé/phòng: ");
                    int tickets = sc.nextInt();

                    System.out.print("Số quầy: ");
                    int counters = sc.nextInt();

                    system.start(rooms, tickets, counters);

                    break;

                case 5:
                    system.stats();
                    break;

                case 7:
                    system.stop();
                    System.out.println("Kết thúc chương trình.");
                    return;
            }
        }
    }
}
