import java.util.Scanner;

class Calculator {

    static int count = 0;

    // Addition of integers
    int add(int a, int b) {
        count++;
        return a + b;
    }

    // Addition of decimals
    double add(double a, double b) {
        count++;
        return a + b;
    }

    void displayCount() {
        System.out.println("Total Calculations Performed: " + count);
    }
}

public class Exp3a {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        Calculator c = new Calculator();

        // Integer Addition
        System.out.print("Enter first integer: ");
        int a = sc.nextInt();

        System.out.print("Enter second integer: ");
        int b = sc.nextInt();

        System.out.println("Sum of Integers: " + c.add(a, b));

        // Decimal Addition
        System.out.print("Enter first decimal number: ");
        double x = sc.nextDouble();

        System.out.print("Enter second decimal number: ");
        double y = sc.nextDouble();

        System.out.println("Sum of Decimals: " + c.add(x, y));

        c.displayCount();

        sc.close();
    }
}