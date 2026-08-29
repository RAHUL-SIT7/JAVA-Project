// 1.Create a Voting System that throws a custom exception if age is below 18
package Experiment16;
import java.util.Scanner;

class InvalidAgeException extends Exception {
    public InvalidAgeException(String message) {
        super(message);
    }
}

public class Exp16a {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter your age: ");
        int age = sc.nextInt();

        try {
            if (age < 18) {
                throw new InvalidAgeException("You are not eligible to vote.");
            }

            System.out.println("You are eligible to vote.");
        } 
        catch (InvalidAgeException e) {
            System.out.println("Error: " + e.getMessage());
        }

        sc.close();
    }
}
