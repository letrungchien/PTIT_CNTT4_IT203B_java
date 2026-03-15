package Session6.Bai6;

import java.util.*;

public class StatisticsManager {

    public static void showStats(List<TicketPool> rooms) {

        System.out.println("\n=== THỐNG KÊ HIỆN TẠI ===");

        int total = 0;

        for (TicketPool room : rooms) {

            int sold = room.soldCount();
            int cap = room.capacity();

            System.out.println("Phòng "
                    + room.getRoomName()
                    + ": Đã bán "
                    + sold + "/" + cap);

            total += sold;
        }

        int revenue = total * 150000;

        System.out.println("Tổng doanh thu: "
                + revenue + " VNĐ");
    }
}