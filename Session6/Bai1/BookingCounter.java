package Session6.Bai1;

public class BookingCounter extends Thread {

    private String counterName;
    private TicketPool firstRoom;
    private TicketPool secondRoom;

    public BookingCounter(String name, TicketPool first, TicketPool second) {
        this.counterName = name;
        this.firstRoom = first;
        this.secondRoom = second;
    }

    public void sellCombo() {

        synchronized (firstRoom) {

            Ticket ticket1 = firstRoom.getTicket();

            if (ticket1 != null) {
                System.out.println(counterName + ": Đã lấy vé " + ticket1.getId());
            } else {
                System.out.println(counterName + ": Hết vé phòng " + firstRoom.getRoomName());
                return;
            }

            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {}

            System.out.println(counterName + ": Đang chờ vé " + secondRoom.getRoomName());

            synchronized (secondRoom) {

                Ticket ticket2 = secondRoom.getTicket();

                if (ticket2 != null) {
                    System.out.println(counterName + " bán combo thành công: "
                            + ticket1.getId() + " & " + ticket2.getId());
                } else {

                    System.out.println(counterName + ": Phòng "
                            + secondRoom.getRoomName() + " hết vé, trả lại vé");

                    firstRoom.returnTicket(ticket1);
                }
            }
        }
    }

    @Override
    public void run() {
        sellCombo();
    }
}
