package ru.sberbank.networking.example2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.Scanner;

public class Client {
    private static final String DEFAULT_HOST = "localhost"; // 127.0.0.1
    private static final int DEFAULT_PORT = 1234;

    public static void main(String[] args) throws IOException {
        String serverHost = args.length > 0 ? args[0] : DEFAULT_HOST;
        int serverPort = args.length > 1 ? Integer.parseInt(args[1]) : DEFAULT_PORT;

        try (Socket serverSocket = new Socket(serverHost, serverPort);
             BufferedReader in = new BufferedReader(new InputStreamReader(serverSocket.getInputStream()));
             PrintWriter out = new PrintWriter(serverSocket.getOutputStream(), false)) {
            Scanner scanner = new Scanner(System.in);
            do {
                System.out.print("Enter your number: ");
                String value = scanner.nextLine();
                out.println(value);
                out.flush();
            } while (!"Yes".equalsIgnoreCase(in.readLine()));
            System.out.println("Yes! Yes! Yes!");
        }

        System.out.println("Good bye!");
    }
}
