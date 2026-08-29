import java.util.Scanner;
public class Exp14a {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        double balance = 10000;

        System.out.print("Enter withdrawal amount: ");
        double amount = sc.nextDouble();

        try {
            if (amount <= 0) {
                throw new Exception("Invalid withdrawal amount. Amount must be greater than zero.");
            }

            if (amount > balance) {
                throw new Exception("Insufficient balance.");
            }

            balance = balance - amount;

            System.out.println("Withdrawal successful.");
            System.out.println("Remaining balance: " + balance);
        }
        catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        }

        sc.close();
    }
}