package Session6.Bai5;

import java.util.ArrayList;
import java.util.List;

public class TicketPool {

    private String roomName;
    private List<Ticket> tickets = new ArrayList<>();

    public TicketPool(String roomName, int capacity) {

        this.roomName = roomName;

        for (int i = 1; i <= capacity; i++) {

            String id = roomName + "-" + String.format("%03d", i);
            tickets.add(new Ticket(id, roomName));
        }
    }

    public synchronized Ticket holdTicket(boolean vip, String counter) {

        long expiry = System.currentTimeMillis() + 5000;

        for (Ticket t : tickets) {

            if (!t.isSold() && !t.isHeld()) {

                t.hold(vip, expiry);

                System.out.println(counter +
                        ": Đã giữ vé " + t.getTicketId() +
                        (vip ? " (VIP)" : "") +
                        ". Vui lòng thanh toán trong 5s");

                return t;
            }
        }

        return null;
    }

    public synchronized boolean sellHeldTicket(Ticket ticket, String counter) {

        if (ticket != null && ticket.isHeld()) {

            ticket.sell();

            System.out.println(counter +
                    ": Thanh toán thành công vé "
                    + ticket.getTicketId());

            return true;
        }

        return false;
    }

    public synchronized void releaseExpiredTickets() {

        long now = System.currentTimeMillis();

        for (Ticket t : tickets) {

            if (t.isExpired(now)) {

                System.out.println(
                        "TimeoutManager: Vé "
                                + t.getTicketId()
                                + " hết hạn giữ, đã trả lại kho");

                t.release();
            }
        }
    }
}
