package Session6.Bai1;



public class Bai1 {

    public static void main(String[] args) {

        TicketPool roomA = new TicketPool("A");
        TicketPool roomB = new TicketPool("B");

        roomA.addTicket(new Ticket("A-001"));
        roomA.addTicket(new Ticket("A-002"));

        roomB.addTicket(new Ticket("B-001"));
        roomB.addTicket(new Ticket("B-002"));

        BookingCounter counter1 = new BookingCounter(
                "Quầy 1", roomA, roomB);

        BookingCounter counter2 = new BookingCounter(
                "Quầy 2", roomB, roomA);
        counter1.start();
        counter2.start();
    }
}