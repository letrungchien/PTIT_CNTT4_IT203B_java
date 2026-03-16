package Session7.Baitap.Bai1;

public class OrderCalculator {
    public double calculateTotalMoneyForOrder(Order order) {
        double money = 0;

        for (Product product : order.getProducts()) {
            money += product.getProPrice() * order.getProducts().size();
        }
        return money;
    }
}
