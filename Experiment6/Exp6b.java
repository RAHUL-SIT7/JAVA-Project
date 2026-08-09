import java.util.Scanner;

class FoodDelivery {

    String foodName;
    int quantity;

    FoodDelivery(String foodName, int quantity) {
        this.foodName = foodName;
        this.quantity = quantity;
    }

    // Inner Class
    class OrderDetails {

        void displayOrder() {
            System.out.println("---- Order Details ----");
            System.out.println("Food Name: " + foodName);
            System.out.println("Quantity: " + quantity);
        }
    }

    // Interface for Delivery Status
    interface DeliveryStatus {
        void updateStatus();
    }

    void deliveryUpdates() {

        // Anonymous Class 1
        DeliveryStatus d1 = new DeliveryStatus() {
            public void updateStatus() {
                System.out.println("Order has been placed.");
            }
        };

        // Anonymous Class 2
        DeliveryStatus d2 = new DeliveryStatus() {
            public void updateStatus() {
                System.out.println("Order is out for delivery.");
            }
        };

        // Anonymous Class 3
        DeliveryStatus d3 = new DeliveryStatus() {
            public void updateStatus() {
                System.out.println("Order has been delivered.");
            }
        };

        d1.updateStatus();
        d2.updateStatus();
        d3.updateStatus();
    }
}

public class Exp6b {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.print("Enter Food Name: ");
        String foodName = sc.nextLine();

        System.out.print("Enter Quantity: ");
        int quantity = sc.nextInt();

        FoodDelivery order = new FoodDelivery(foodName, quantity);

        // Creating Inner Class Object
        FoodDelivery.OrderDetails details = order.new OrderDetails();

        // Display Order Details
        details.displayOrder();

        // Anonymous Classes for Delivery Status
        order.deliveryUpdates();

        sc.close();
    }
}