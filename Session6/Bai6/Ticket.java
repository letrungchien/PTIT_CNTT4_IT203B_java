package Session6.Bai6;

public class Ticket {

    private String id;
    private boolean sold;

    public Ticket(String id) {
        this.id = id;
        this.sold = false;
    }

    public synchronized boolean sell() {
        if (!sold) {
            sold = true;
            return true;
        }
        return false;
    }

    public boolean isSold() {
        return sold;
    }

    public String getId() {
        return id;
    }
}