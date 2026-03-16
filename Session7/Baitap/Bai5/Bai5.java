package Session7.Baitap.Bai5;

import java.util.*;



class Product {
    String id;
    String name;
    double price;
    String category;

    public Product(String id, String name, double price, String category) {
        this.id = id;
        this.name = name;
        this.price = price;
        this.category = category;
    }
}

class Customer {
    String name;
    String email;
    String phone;

    public Customer(String name, String email, String phone) {
        this.name = name;
        this.email = email;
        this.phone = phone;
    }
}

class OrderItem {
    Product product;
    int quantity;

    public OrderItem(Product p, int q) {
        this.product = p;
        this.quantity = q;
    }

    public double getTotal() {
        return product.price * quantity;
    }
}

class Order {
    String id;
    Customer customer;
    List<OrderItem> items = new ArrayList<>();
    double finalAmount;

    public Order(String id, Customer customer) {
        this.id = id;
        this.customer = customer;
    }
}



interface DiscountStrategy {
    double applyDiscount(double total);
}

class PercentageDiscount implements DiscountStrategy {
    double percent;

    public PercentageDiscount(double percent) {
        this.percent = percent;
    }

    public double applyDiscount(double total) {
        return total - total * percent / 100;
    }
}

class FixedDiscount implements DiscountStrategy {
    double amount;

    public FixedDiscount(double amount) {
        this.amount = amount;
    }

    public double applyDiscount(double total) {
        return total - amount;
    }
}

class HolidayDiscount implements DiscountStrategy {
    public double applyDiscount(double total) {
        return total * 0.85;
    }
}



interface PaymentMethod {
    void pay(double amount);
}

class CODPayment implements PaymentMethod {
    public void pay(double amount) {
        System.out.println("Thanh toán COD: " + amount);
    }
}

class CreditCardPayment implements PaymentMethod {
    public void pay(double amount) {
        System.out.println("Thanh toán thẻ tín dụng: " + amount);
    }
}

class MomoPayment implements PaymentMethod {
    public void pay(double amount) {
        System.out.println("Thanh toán MoMo: " + amount);
    }
}

class VNPayPayment implements PaymentMethod {
    public void pay(double amount) {
        System.out.println("Thanh toán VNPay: " + amount);
    }
}



interface OrderRepository {
    void save(Order order);
    List<Order> findAll();
}

class FileOrderRepository implements OrderRepository {

    List<Order> orders = new ArrayList<>();

    public void save(Order order) {
        orders.add(order);
        System.out.println("Đã lưu đơn hàng " + order.id + " vào file");
    }

    public List<Order> findAll() {
        return orders;
    }
}

class DatabaseOrderRepository implements OrderRepository {

    List<Order> orders = new ArrayList<>();

    public void save(Order order) {
        orders.add(order);
        System.out.println("Đã lưu đơn hàng " + order.id + " vào database");
    }

    public List<Order> findAll() {
        return orders;
    }
}


interface NotificationService {
    void send(String message);
}

class EmailNotification implements NotificationService {
    public void send(String message) {
        System.out.println("Gửi email: " + message);
    }
}

class SMSNotification implements NotificationService {
    public void send(String message) {
        System.out.println("Gửi SMS: " + message);
    }
}


class InvoiceGenerator {

    public void printInvoice(Order order, double total, double finalAmount) {

        System.out.println("=== HÓA ĐƠN ===");
        System.out.println("Khách: " + order.customer.name);

        for (OrderItem item : order.items) {
            System.out.println(item.product.id + " - SL: " + item.quantity +
                    " - Giá: " + item.product.price +
                    " - Thành tiền: " + item.getTotal());
        }

        System.out.println("Tổng tiền: " + total);
        System.out.println("Cần thanh toán: " + finalAmount);
    }
}



class OrderService {

    private OrderRepository repository;
    private NotificationService notification;

    public OrderService(OrderRepository repo, NotificationService noti) {
        this.repository = repo;
        this.notification = noti;
    }

    public Order createOrder(String id, Customer c) {
        return new Order(id, c);
    }

    public void checkout(Order order,
                         DiscountStrategy discount,
                         PaymentMethod payment,
                         InvoiceGenerator invoice) {

        double total = 0;

        for (OrderItem item : order.items) {
            total += item.getTotal();
        }

        double finalAmount = discount.applyDiscount(total);

        invoice.printInvoice(order, total, finalAmount);

        payment.pay(finalAmount);

        order.finalAmount = finalAmount;

        repository.save(order);

        notification.send("Đơn hàng " + order.id + " đã được tạo");
    }

    public List<Order> getOrders() {
        return repository.findAll();
    }
}



public class Bai5 {

    static Scanner sc = new Scanner(System.in);

    static List<Product> products = new ArrayList<>();
    static List<Customer> customers = new ArrayList<>();

    public static void main(String[] args) {

        OrderRepository repo = new FileOrderRepository();
        NotificationService noti = new EmailNotification();
        OrderService service = new OrderService(repo, noti);

        InvoiceGenerator invoice = new InvoiceGenerator();

        while (true) {

            System.out.println("\n1. Thêm sản phẩm");
            System.out.println("2. Thêm khách hàng");
            System.out.println("3. Tạo đơn hàng");
            System.out.println("4. Xem đơn hàng");
            System.out.println("5. Tính doanh thu");
            System.out.println("0. Thoát");

            int choice = sc.nextInt();
            sc.nextLine();

            switch (choice) {

                case 1:
                    System.out.print("Mã: ");
                    String id = sc.nextLine();
                    System.out.print("Tên: ");
                    String name = sc.nextLine();
                    System.out.print("Giá: ");
                    double price = sc.nextDouble();
                    sc.nextLine();
                    System.out.print("Danh mục: ");
                    String cate = sc.nextLine();

                    products.add(new Product(id, name, price, cate));

                    System.out.println("Đã thêm sản phẩm " + id);
                    break;

                case 2:
                    System.out.print("Tên: ");
                    String cname = sc.nextLine();
                    System.out.print("Email: ");
                    String email = sc.nextLine();
                    System.out.print("ĐT: ");
                    String phone = sc.nextLine();

                    customers.add(new Customer(cname, email, phone));

                    System.out.println("Đã thêm khách hàng");
                    break;

                case 3:

                    if (products.isEmpty() || customers.isEmpty()) {
                        System.out.println("Chưa có dữ liệu");
                        break;
                    }

                    Customer c = customers.get(0);
                    Product p = products.get(0);

                    Order order = service.createOrder("ORD001", c);

                    order.items.add(new OrderItem(p, 1));

                    DiscountStrategy discount = new PercentageDiscount(10);
                    PaymentMethod payment = new CreditCardPayment();

                    service.checkout(order, discount, payment, invoice);

                    break;

                case 4:

                    for (Order o : service.getOrders()) {
                        System.out.println(o.id + " - " + o.customer.name + " - " + o.finalAmount);
                    }

                    break;

                case 5:

                    double revenue = 0;

                    for (Order o : service.getOrders()) {
                        revenue += o.finalAmount;
                    }

                    System.out.println("Tổng doanh thu: " + revenue);

                    break;

                case 0:
                    return;
            }
        }
    }
}
