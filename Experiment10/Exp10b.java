import java.util.Scanner;

abstract class FoodOrder {

    double amount;

    FoodOrder(double amount) {
        this.amount = amount;
    }

    abstract void calculateBill();
}

class DineInOrder extends FoodOrder {

    double serviceCharge;

    DineInOrder(double amount, double serviceCharge) {
        super(amount);
        this.serviceCharge = serviceCharge;
    }

    void calculateBill() {
        double total = amount + serviceCharge;

        System.out.println("----- Dine-In Order -----");
        System.out.println("Food Amount: " + amount);
        System.out.println("Service Charge: " + serviceCharge);
        System.out.println("Total Bill: " + total);
    }
}

class TakeAwayOrder extends FoodOrder {

    double packingCharge;

    TakeAwayOrder(double amount, double packingCharge) {
        super(amount);
        this.packingCharge = packingCharge;
    }

    void calculateBill() {
        double total = amount + packingCharge;

        System.out.println("----- Takeaway Order -----");
        System.out.println("Food Amount: " + amount);
        System.out.println("Packing Charge: " + packingCharge);
        System.out.println("Total Bill: " + total);
    }
}

public class Exp10b {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.print("Enter Food Amount: ");
        double amount = sc.nextDouble();

        System.out.print("Enter Dine-In Service Charge: ");
        double serviceCharge = sc.nextDouble();

        System.out.print("Enter Takeaway Packing Charge: ");
        double packingCharge = sc.nextDouble();

        FoodOrder dineIn = new DineInOrder(amount, serviceCharge);
        FoodOrder takeAway = new TakeAwayOrder(amount, packingCharge);

        System.out.println();

        dineIn.calculateBill();

        System.out.println();

        takeAway.calculateBill();

        sc.close();
    }
}