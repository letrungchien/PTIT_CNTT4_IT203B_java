package Session9;

public class PhysicalProduct extends Product {
     private Double weight;

    public PhysicalProduct(String id, String name, Double price,Double weight) {
        super(id, name, price);
        this.weight=weight;
    }

    public Double getWeight() {
        return weight;
    }

    public void setWeight(Double weight) {
        this.weight = weight;
    }

    public void displayInfo(){
      super.displayInfo();
      System.out.println("Weight: "+getWeight());
    }
}
