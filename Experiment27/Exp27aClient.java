package Experiment27;
import java.io.*;
import java.net.*;
public class Exp27aClient {

    public static void main(String[] args) {
        try {
            Socket socket = new Socket("localhost", 5050);

            System.out.println("Connected to server!");

            BufferedReader input = new BufferedReader(
                    new InputStreamReader(socket.getInputStream()));

            PrintWriter output = new PrintWriter(
                    socket.getOutputStream(), true);

            BufferedReader keyboard = new BufferedReader(
                    new InputStreamReader(System.in));

            while (true) {

                // Send message to server
                System.out.print("Client: ");
                String clientMessage = keyboard.readLine();

                output.println(clientMessage);

                if (clientMessage.equalsIgnoreCase("exit")) {
                    break;
                }

                // Receive server reply
                String serverMessage = input.readLine();

                if (serverMessage == null) {
                    break;
                }

                System.out.println("Server: " + serverMessage);

                if (serverMessage.equalsIgnoreCase("exit")) {
                    break;
                }
            }

            socket.close();

        } catch (IOException e) {
            System.out.println("Error: " + e);
        }
    }
}