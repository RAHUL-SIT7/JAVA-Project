/*2. Create a Driving License System that throws a custom exception if the user’s age
is below 18. If the age is valid, display that the user is eligible for a driving license*/
package Experiment16;

import java.util.Scanner;

class InvalidDrivingAgeException extends Exception {
    public InvalidDrivingAgeException(String message) {
        super(message);
    }
}

public class Exp16b {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter your age: ");
        int age = sc.nextInt();

        try {
            if (age < 18) {
                throw new InvalidDrivingAgeException(
                    "You are not eligible for a driving license."
                );
            }

            System.out.println("You are eligible for a driving license.");
        } 
        catch (InvalidDrivingAgeException e) {
            System.out.println("Error: " + e.getMessage());
        }

        sc.close();
    }
}