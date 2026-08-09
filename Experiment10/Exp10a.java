import java.util.Scanner;

abstract class Payment {

    double amount;

    Payment(double amount) {
        this.amount = amount;
    }

    abstract void makePayment();
}

class CreditCardPayment extends Payment {

    CreditCardPayment(double amount) {
        super(amount);
    }

    void makePayment() {
        System.out.println("Payment Method: Credit Card");
        System.out.println("Payment Amount: " + amount);
        System.out.println("Credit Card Payment Successful.");
    }
}

class UPIPayment extends Payment {

    UPIPayment(double amount) {
        super(amount);
    }

    void makePayment() {
        System.out.println("Payment Method: UPI");
        System.out.println("Payment Amount: " + amount);
        System.out.println("UPI Payment Successful.");
    }
}

public class Exp10a {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.print("Enter Payment Amount: ");
        double amount = sc.nextDouble();

        Payment creditCard = new CreditCardPayment(amount);
        Payment upi = new UPIPayment(amount);

        System.out.println();

        creditCard.makePayment();

        System.out.println();

        upi.makePayment();

        sc.close();
    }
}