package Session6.Bai5;

import java.util.Random;

public class BookingCounter implements Runnable {

    private String counterName;
    private TicketPool[] pools;

    private Random random = new Random();

    public BookingCounter(String name, TicketPool[] pools) {
        this.counterName = name;
        this.pools = pools;
    }

    @Override
    public void run() {

        while (true) {

            int roomIndex = random.nextInt(pools.length);
            boolean vip = random.nextBoolean();

            TicketPool pool = pools[roomIndex];

            Ticket ticket = pool.holdTicket(vip, counterName);

            if (ticket != null) {

                try {
                    Thread.sleep(3000);
                } catch (InterruptedException e) {}

                pool.sellHeldTicket(ticket, counterName);
            }

            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {}
        }
    }
}
