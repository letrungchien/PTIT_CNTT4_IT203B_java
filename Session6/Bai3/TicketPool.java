package Session6.Bai3;

import java.util.LinkedList;
import java.util.Queue;

public class TicketPool {

    private String roomName;
    private Queue<Ticket> tickets = new LinkedList<>();
    private int ticketCounter = 1;

    public TicketPool(String roomName) {
        this.roomName = roomName;
    }

    public synchronized Ticket sellTicket() {

        if (tickets.isEmpty()) {
            return null;
        }

        return tickets.poll();
    }

    public synchronized void addTickets(int count) {

        for (int i = 0; i < count; i++) {

            String id = roomName + "-" + String.format("%03d", ticketCounter++);
            tickets.add(new Ticket(id));

        }

        System.out.println("Nhà cung cấp: Đã thêm "
                + count + " vé vào phòng " + roomName);
    }
    public synchronized int getRemainingTickets() {
        return tickets.size();
    }
}
