package Session7.Baitap.Bai2;

interface DiscountStrategy {
    double applyDiscount(double totalAmount);
}

class PercentageDiscount implements DiscountStrategy {
    private double percent;

    public PercentageDiscount(double percent) {
        this.percent = percent;
    }

    public double applyDiscount(double totalAmount) {
        return totalAmount - (totalAmount * percent / 100);
    }
}

class FixedDiscount implements DiscountStrategy {
    private double amount;

    public FixedDiscount(double amount) {
        this.amount = amount;
    }

    public double applyDiscount(double totalAmount) {
        return totalAmount - amount;
    }
}

class NoDiscount implements DiscountStrategy {
    public double applyDiscount(double totalAmount) {
        return totalAmount;
    }
}

class HolidayDiscount implements DiscountStrategy {
    public double applyDiscount(double totalAmount) {
        return totalAmount * 0.85; // giảm 15%
    }
}

class OrderCalculator {
    private DiscountStrategy discountStrategy;

    public OrderCalculator(DiscountStrategy discountStrategy) {
        this.discountStrategy = discountStrategy;
    }

    public double calculateTotal(double amount) {
        return discountStrategy.applyDiscount(amount);
    }
}

public class Bai2 {
    public static void main(String[] args) {
        double total = 1000;

        OrderCalculator order1 = new OrderCalculator(new PercentageDiscount(10));
        System.out.println("Giảm 10%: " + order1.calculateTotal(total));

        OrderCalculator order2 = new OrderCalculator(new FixedDiscount(200));
        System.out.println("Giảm 200: " + order2.calculateTotal(total));

        OrderCalculator order3 = new OrderCalculator(new NoDiscount());
        System.out.println("Không giảm: " + order3.calculateTotal(total));

        OrderCalculator order4 = new OrderCalculator(new HolidayDiscount());
        System.out.println("Holiday giảm 15%: " + order4.calculateTotal(total));
    }
}
