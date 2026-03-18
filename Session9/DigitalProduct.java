package Session9;

public class DigitalProduct  extends Product{
   private int size;

    public int getSize() {
        return size;
    }

    public void setSize(int size) {
        this.size = size;
    }

    public DigitalProduct(String id, String name, Double price, int size) {
        super(id, name, price);
        this.size =size;
    }
    public void displayInfo(){
        super.displayInfo();
        System.out.println("Size: "+getSize());
    }
}
