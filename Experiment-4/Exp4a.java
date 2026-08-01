import java.util.Scanner;

public class Exp4a {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.print("Enter marks of Subject 1: ");
        String mark1 = sc.nextLine();

        System.out.print("Enter marks of Subject 2: ");
        String mark2 = sc.nextLine();

        System.out.print("Enter marks of Subject 3: ");
        String mark3 = sc.nextLine();

        // Convert String to Integer
        Integer m1 = Integer.valueOf(mark1);
        Integer m2 = Integer.valueOf(mark2);
        Integer m3 = Integer.valueOf(mark3);

        int total = m1 + m2 + m3;

        System.out.println("Total Marks: " + total);

        sc.close();
    }
}