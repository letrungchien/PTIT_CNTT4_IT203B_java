package Session6.Bai6;

import java.util.List;

public class TicketSupplier implements Runnable {

    private List<TicketPool> rooms;

    public TicketSupplier(List<TicketPool> rooms) {
        this.rooms = rooms;
    }

    @Override
    public void run() {

        while (true) {

            try {
                Thread.sleep(5000);
            } catch (InterruptedException e) {
                return;
            }

            for (TicketPool room : rooms) {

                System.out.println("Supplier kiểm tra phòng "
                        + room.getRoomName());
            }
        }
    }
}
