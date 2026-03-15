package Session6.Bai5;

public class Ticket {

    private String ticketId;
    private String roomName;

    private boolean isHeld;
    private long holdExpiryTime;

    private boolean isVIP;
    private boolean isSold;

    public Ticket(String ticketId, String roomName) {
        this.ticketId = ticketId;
        this.roomName = roomName;
        this.isHeld = false;
        this.isSold = false;
    }

    public String getTicketId() {
        return ticketId;
    }

    public boolean isHeld() {
        return isHeld;
    }

    public void hold(boolean vip, long expiry) {
        this.isHeld = true;
        this.isVIP = vip;
        this.holdExpiryTime = expiry;
    }

    public void release() {
        this.isHeld = false;
        this.isVIP = false;
        this.holdExpiryTime = 0;
    }

    public boolean isExpired(long now) {
        return isHeld && now > holdExpiryTime;
    }

    public void sell() {
        this.isSold = true;
        this.isHeld = false;
    }

    public boolean isSold() {
        return isSold;
    }
}