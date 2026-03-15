package Session6.Bai6;

import java.util.*;
import java.util.concurrent.*;

public class CinemaSystem {

    private ExecutorService executor;
    private List<TicketPool> rooms = new ArrayList<>();
    private List<BookingCounter> counters = new ArrayList<>();

    public void start(int roomCount, int ticketPerRoom, int counterCount) {

        executor = Executors.newCachedThreadPool();

        for (int i = 0; i < roomCount; i++) {

            char name = (char) ('A' + i);

            rooms.add(new TicketPool(String.valueOf(name), ticketPerRoom));
        }

        for (int i = 1; i <= counterCount; i++) {

            BookingCounter counter =
                    new BookingCounter("Quầy " + i, rooms);

            counters.add(counter);

            executor.submit(counter);
        }

        executor.submit(new DeadlockDetector());

        System.out.println("Đã khởi tạo hệ thống với "
                + roomCount + " phòng.");
    }

    public void stop() {

        executor.shutdownNow();

        System.out.println("Đang dừng hệ thống...");
    }

    public void stats() {
        StatisticsManager.showStats(rooms);
    }
}
