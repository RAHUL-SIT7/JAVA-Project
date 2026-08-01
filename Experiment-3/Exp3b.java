import java.util.Scanner;

class Restaurant {

    static int totalOrders = 0;

    // Dine-in Bill
    double bill(double amount) {
        totalOrders++;
        return amount;
    }

    // Takeaway Bill
    double bill(double amount, double packingCharge) {
        totalOrders++;
        return amount + packingCharge;
    }

    // Delivery Bill
    double bill(double amount, double packingCharge, double deliveryCharge) {
        totalOrders++;
        return amount + packingCharge + deliveryCharge;
    }

    void displayOrders() {
        System.out.println("Total Orders: " + totalOrders);
    }
}

public class Exp3b {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        Restaurant r = new Restaurant();

        // Dine-in
        System.out.print("Enter Dine-in Bill Amount: ");
        double dine = sc.nextDouble();
        System.out.println("Dine-in Bill: " + r.bill(dine));

        // Takeaway
        System.out.print("Enter Takeaway Bill Amount: ");
        double take = sc.nextDouble();

        System.out.print("Enter Packing Charge: ");
        double pack = sc.nextDouble();

        System.out.println("Takeaway Bill: " + r.bill(take, pack));

        // Delivery
        System.out.print("Enter Delivery Bill Amount: ");
        double del = sc.nextDouble();

        System.out.print("Enter Packing Charge: ");
        double pack1 = sc.nextDouble();

        System.out.print("Enter Delivery Charge: ");
        double delivery = sc.nextDouble();

        System.out.println("Delivery Bill: " + r.bill(del, pack1, delivery));

        r.displayOrders();

        sc.close();
    }
}