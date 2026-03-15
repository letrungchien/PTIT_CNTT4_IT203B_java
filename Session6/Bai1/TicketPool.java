package Session6.Bai1;

import java.util.LinkedList;
import java.util.Queue;

public class TicketPool {

    private String roomName;
    private Queue<Ticket> tickets = new LinkedList<>();

    public TicketPool(String roomName) {
        this.roomName = roomName;
    }

    public void addTicket(Ticket ticket) {
        tickets.add(ticket);
    }

    public Ticket getTicket() {
        return tickets.poll();
    }

    public void returnTicket(Ticket ticket) {
        tickets.add(ticket);
    }

    public String getRoomName() {
        return roomName;
    }

    public boolean isEmpty() {
        return tickets.isEmpty();
    }
}
