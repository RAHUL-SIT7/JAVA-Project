/*  2.Create an ATM PIN Verification program that throws an exception for an invalid PIN
entered by the user and uses a finally block to display a message indicating that the verification process has completed.*/
package Experiment15;

import java.util.Scanner;

public class Exp15b {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int correctPIN = 1234;

        System.out.print("Enter ATM PIN: ");
        int pin = sc.nextInt();
        sc.nextLine();

        try {
            if (pin != correctPIN) {
                throw new Exception("Invalid PIN.");
            }

            System.out.println("PIN verified successfully.");
        } 
        catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        } 
        finally {
            System.out.println("PIN verification process completed.");
        }

        sc.close();
    }
}