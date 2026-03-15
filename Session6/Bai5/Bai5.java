package Session6.Bai5;

public class Bai5 {

    public static void main(String[] args) {

        TicketPool roomA = new TicketPool("A", 10);
        TicketPool roomB = new TicketPool("B", 8);
        TicketPool roomC = new TicketPool("C", 12);

        TicketPool[] pools = {roomA, roomB, roomC};

        for (int i = 1; i <= 5; i++) {

            Thread t = new Thread(
                    new BookingCounter("Quầy " + i, pools));

            t.start();
        }

        Thread timeoutThread =
                new Thread(new TimeoutManager(pools));

        timeoutThread.start();
    }
}
