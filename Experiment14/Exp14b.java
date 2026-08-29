/*2. Create an Online Shopping program that handles an invalid product quantity entered by the user using a try-catch block.
 Display an appropriate error message if the quantity is less than or equal to zero.*/
 import java.util.Scanner;

public class Exp14b {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter product name: ");
        String product = sc.nextLine();

        System.out.print("Enter product price: ");
        double price = sc.nextDouble();

        System.out.print("Enter quantity: ");
        int quantity = sc.nextInt();

        try {
            if (quantity <= 0) {
                throw new Exception("Invalid quantity. Quantity must be greater than zero.");
            }

            double total = price * quantity;

            System.out.println("Product: " + product);
            System.out.println("Quantity: " + quantity);
            System.out.println("Total Price: " + total);
        } 
        catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        }

        sc.close();
    }
}