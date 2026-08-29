// 1.Create a Login program that throws an exception for invalid password and uses final blocks.
package Experiment15;
import java.util.Scanner;

public class Exp15a {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        String correctPassword = "12345";

        System.out.print("Enter password: ");
        String password = sc.nextLine();

        try {
            if (!password.equals(correctPassword)) {
                throw new Exception("Invalid password.");
            }

            System.out.println("Login successful.");
        } 
        catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        } 
        finally {
            System.out.println("Login process completed.");
        }

        sc.close();
    }
}12345