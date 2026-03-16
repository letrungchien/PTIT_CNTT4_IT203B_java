package Session7.Baitap.Bai6;

import java.util.*;



class Customer {
    String name;
    String email;

    public Customer(String name, String email) {
        this.name = name;
        this.email = email;
    }
}

class Order {
    Customer customer;
    double total;
    double finalAmount;

    public Order(Customer customer, double total) {
        this.customer = customer;
        this.total = total;
    }
}



interface DiscountStrategy {
    double applyDiscount(double total);
}

class PercentageDiscount implements DiscountStrategy {
    public double applyDiscount(double total) {
        return total * 0.9;
    }
}

class FixedDiscount implements DiscountStrategy {
    public double applyDiscount(double total) {
        return total - 50000;
    }
}

class NoDiscount implements DiscountStrategy {
    public double applyDiscount(double total) {
        return total;
    }
}


class HolidayDiscount implements DiscountStrategy {
    public double applyDiscount(double total) {
        return total * 0.85;
    }
}



interface PaymentMethod {
    boolean process(double amount);
}

class CODPayment implements PaymentMethod {
    public boolean process(double amount) {
        System.out.println("Thanh toán COD: " + amount + " - Thành công!");
        return true;
    }
}

class CreditCardPayment implements PaymentMethod {
    public boolean process(double amount) {
        System.out.println("Thanh toán thẻ tín dụng: " + amount + " - Thành công!");
        return true;
    }
}


class MomoPayment implements PaymentMethod {
    public boolean process(double amount) {
        System.out.println("Thanh toán MoMo: " + amount + " - Thành công!");
        return true;
    }
}



interface NotificationService {
    void send(String message, String recipient);
}

class EmailService implements NotificationService {
    public void send(String message, String recipient) {
        System.out.println("Gửi email đến " + recipient + ": " + message);
    }
}



interface OrderRepository {
    void save(Order order);
}

class FileOrderRepository implements OrderRepository {
    public void save(Order order) {
        System.out.println("Đã lưu đơn hàng vào file.");
    }
}


class OrderService {

    private DiscountStrategy discount;
    private PaymentMethod payment;
    private NotificationService notification;
    private OrderRepository repository;

    public OrderService(DiscountStrategy discount,
                        PaymentMethod payment,
                        NotificationService notification,
                        OrderRepository repository) {

        this.discount = discount;
        this.payment = payment;
        this.notification = notification;
        this.repository = repository;
    }

    public void processOrder(Order order) {

        double afterDiscount = discount.applyDiscount(order.total);
        order.finalAmount = afterDiscount;

        System.out.println("Tổng tiền: " + order.total);
        System.out.println("Sau giảm giá: " + afterDiscount);

        if (payment.process(afterDiscount)) {
            repository.save(order);
            notification.send("Đơn hàng của bạn đã được xác nhận.", order.customer.email);
        }
    }
}



public class Bai6{

    static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {

        while (true) {

            System.out.println("\n===== HỆ THỐNG ĐƠN HÀNG =====");
            System.out.println("1. Tạo đơn hàng mới");
            System.out.println("0. Thoát");

            int choice = sc.nextInt();
            sc.nextLine();

            if (choice == 0) break;

            if (choice == 1) {

                System.out.print("Nhập tên khách hàng: ");
                String name = sc.nextLine();

                System.out.print("Nhập email: ");
                String email = sc.nextLine();

                System.out.print("Nhập tổng tiền đơn hàng: ");
                double total = sc.nextDouble();

                Customer customer = new Customer(name, email);
                Order order = new Order(customer, total);



                System.out.println("Chọn loại giảm giá:");
                System.out.println("1. Giảm 10%");
                System.out.println("2. Giảm 50000");
                System.out.println("3. Không giảm");

                int d = sc.nextInt();

                DiscountStrategy discount;

                if (d == 1) discount = new PercentageDiscount();
                else if (d == 2) discount = new FixedDiscount();
                else discount = new NoDiscount();


                System.out.println("Chọn phương thức thanh toán:");
                System.out.println("1. COD");
                System.out.println("2. Credit Card");

                int p = sc.nextInt();

                PaymentMethod payment;

                if (p == 1) payment = new CODPayment();
                else payment = new CreditCardPayment();

                NotificationService notification = new EmailService();
                OrderRepository repository = new FileOrderRepository();

                OrderService service =
                        new OrderService(discount, payment, notification, repository);

                service.processOrder(order);
            }
        }
    }
}