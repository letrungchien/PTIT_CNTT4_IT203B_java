package Session6.Bai4;

import java.util.ArrayList;
import java.util.List;

public class TicketPool {

    private String roomName;
    private List<Ticket> tickets;

    public TicketPool(String roomName, int ticketCount) {

        this.roomName = roomName;
        tickets = new ArrayList<>();

        for (int i = 1; i <= ticketCount; i++) {

            String id = roomName + "-" + String.format("%03d", i);
            tickets.add(new Ticket(id, roomName));
        }
    }

    public synchronized Ticket sellTicket() {

        for (Ticket t : tickets) {

            if (!t.isSold()) {
                t.setSold(true);
                return t;
            }
        }

        return null;
    }

    public synchronized boolean hasTickets() {

        for (Ticket t : tickets) {
            if (!t.isSold()) {
                return true;
            }
        }

        return false;
    }

    public synchronized int remainingTickets() {

        int count = 0;

        for (Ticket t : tickets) {
            if (!t.isSold()) count++;
        }

        return count;
    }
}
