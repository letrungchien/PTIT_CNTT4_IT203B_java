package Session6.Bai2;

public class Bai2 {

    public static void main(String[] args) {

        TicketPool roomA = new TicketPool("A");
        TicketPool roomB = new TicketPool("B");

        roomA.addTickets(2, "A");
        roomB.addTickets(5, "B");

        BookingCounter counter1 = new BookingCounter("Quầy 1", roomA);
        BookingCounter counter2 = new BookingCounter("Quầy 2", roomB);

        TicketSupplier supplier = new TicketSupplier(roomA);

        counter1.start();
        counter2.start();
        supplier.start();
    }
}
