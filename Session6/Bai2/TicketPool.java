package Session6.Bai2;


import java.util.LinkedList;
import java.util.Queue;

public class TicketPool {

    private String roomName;
    private Queue<Ticket> tickets = new LinkedList<>();

    public TicketPool(String roomName) {
        this.roomName = roomName;
    }

    public synchronized Ticket sellTicket(String counterName) {

        while (tickets.isEmpty()) {
            try {

                System.out.println(counterName +
                        ": Hết vé phòng " + roomName + ", đang chờ...");

                wait();

            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

        Ticket ticket = tickets.poll();

        System.out.println(counterName +
                " bán vé " + ticket.getId());

        return ticket;
    }

    public synchronized void addTickets(int amount, String prefix) {

        int start = tickets.size() + 1;

        for (int i = 0; i < amount; i++) {
            tickets.add(new Ticket(prefix + "-" + (start + i)));
        }

        System.out.println("Nhà cung cấp: Đã thêm "
                + amount + " vé vào phòng " + roomName);

        notifyAll();
    }
}
