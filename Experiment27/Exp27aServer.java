package Experiment27;
import java.io.*;
import java.net.*;
public class Exp27aServer {
    public static void main(String[] args) {
        try {
            ServerSocket serverSocket = new ServerSocket(5050);

            System.out.println("Server started...");
            System.out.println("Waiting for client...");

            Socket socket = serverSocket.accept();

            System.out.println("Client connected!");

            BufferedReader input = new BufferedReader(
                    new InputStreamReader(socket.getInputStream()));

            PrintWriter output = new PrintWriter(
                    socket.getOutputStream(), true);

            BufferedReader keyboard = new BufferedReader(
                    new InputStreamReader(System.in));

            while (true) {

                // Receive message from client
                String clientMessage = input.readLine();

                if (clientMessage == null) {
                    break;
                }

                System.out.println("Client: " + clientMessage);
                if (clientMessage.equalsIgnoreCase("exit")) {
                    break;
                }
                // Send reply to client
                System.out.print("Server: ");
                String serverMessage = keyboard.readLine();

                output.println(serverMessage);

                if (serverMessage.equalsIgnoreCase("exit")) {
                    break;
                }
            }
            socket.close();
            serverSocket.close();
        } catch (IOException e) {
            System.out.println("Error: " + e);
        }
    }
}