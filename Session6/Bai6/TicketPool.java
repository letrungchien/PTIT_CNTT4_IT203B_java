package Session6.Bai6;

import java.util.*;

public class TicketPool {

    private String roomName;
    private List<Ticket> tickets = new ArrayList<>();

    public TicketPool(String roomName, int capacity) {

        this.roomName = roomName;

        for (int i = 1; i <= capacity; i++) {
            tickets.add(new Ticket(roomName + "-" + i));
        }
    }

    public synchronized Ticket sellTicket() {

        for (Ticket t : tickets) {

            if (!t.isSold()) {

                if (t.sell()) {
                    return t;
                }
            }
        }

        return null;
    }

    public int soldCount() {

        int count = 0;

        for (Ticket t : tickets) {
            if (t.isSold()) count++;
        }

        return count;
    }

    public int capacity() {
        return tickets.size();
    }

    public String getRoomName() {
        return roomName;
    }
}
