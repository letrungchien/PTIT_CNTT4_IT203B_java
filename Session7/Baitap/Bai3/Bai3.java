package Session7.Baitap.Bai3;

interface PaymentMethod {}

interface CODPayable extends PaymentMethod {
    void processCOD(double amount);
}

interface CardPayable extends PaymentMethod {
    void processCreditCard(double amount);
}

interface EWalletPayable extends PaymentMethod {
    void processMomo(double amount);
}


class CODPayment implements CODPayable {
    public void processCOD(double amount) {
        System.out.println("Xử lý thanh toán COD: " + amount + " - Thành công");
    }
}


class CreditCardPayment implements CardPayable {
    public void processCreditCard(double amount) {
        System.out.println("Xử lý thanh toán thẻ tín dụng: " + amount + " - Thành công");
    }
}


class MomoPayment implements EWalletPayable {
    public void processMomo(double amount) {
        System.out.println("Xử lý thanh toán MoMo: " + amount + " - Thành công");
    }
}


class PaymentProcessor {

    public void pay(PaymentMethod method, double amount) {

        if (method instanceof CODPayable) {
            ((CODPayable) method).processCOD(amount);
        }

        if (method instanceof CardPayable) {
            ((CardPayable) method).processCreditCard(amount);
        }

        if (method instanceof EWalletPayable) {
            ((EWalletPayable) method).processMomo(amount);
        }
    }
}

public class Bai3 {
    public static void main(String[] args) {

        PaymentProcessor processor = new PaymentProcessor();

        PaymentMethod cod = new CODPayment();
        PaymentMethod card = new CreditCardPayment();
        PaymentMethod momo = new MomoPayment();

        processor.pay(cod, 500000);
        processor.pay(card, 1000000);
        processor.pay(momo, 750000);
    }
}
