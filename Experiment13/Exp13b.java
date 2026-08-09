import java.io.FileWriter;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;

public class Exp13b {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.print("Enter Patient ID: ");
        int patientId = sc.nextInt();
        sc.nextLine();

        System.out.print("Enter Patient Name: ");
        String name = sc.nextLine();

        System.out.print("Enter Patient Age: ");
        int age = sc.nextInt();
        sc.nextLine();

        System.out.print("Enter Diagnosis: ");
        String diagnosis = sc.nextLine();

        try {

            FileWriter writer = new FileWriter("patient.txt");

            writer.write("Patient ID: " + patientId + "\n");
            writer.write("Patient Name: " + name + "\n");
            writer.write("Patient Age: " + age + "\n");
            writer.write("Diagnosis: " + diagnosis + "\n");

            writer.close();

            System.out.println("Patient details written to file successfully.");

            FileReader reader = new FileReader("patient.txt");

            int ch;

            System.out.println("\n----- Patient Details from File -----");

            while ((ch = reader.read()) != -1) {
                System.out.print((char) ch);
            }

            reader.close();

        } catch (IOException e) {
            System.out.println("An error occurred: " + e.getMessage());
        }

        sc.close();
    }
}