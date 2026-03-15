package Session6.Bai6;

import java.util.*;

public class BookingCounter implements Runnable {

    private String name;
    private List<TicketPool> rooms;
    private Random random = new Random();

    private volatile boolean running = true;

    public BookingCounter(String name, List<TicketPool> rooms) {
        this.name = name;
        this.rooms = rooms;
    }

    public void stop() {
        running = false;
    }

    @Override
    public void run() {

        System.out.println(name + " bắt đầu bán vé...");

        while (running) {

            TicketPool room = rooms.get(random.nextInt(rooms.size()));

            Ticket t = room.sellTicket();

            if (t != null) {
                System.out.println(name + " đã bán " + t.getId());
            }

            try {
                Thread.sleep(500);
            } catch (InterruptedException e) {
                break;
            }
        }
    }
}
