package ru.sbt.socnet.logic;


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Server {

    private static final int DEFAULT_PORT = 1234;

    public static void main(String[] args) throws IOException {
        int port = args.length == 0 ? DEFAULT_PORT : Integer.parseInt(args[0]);


        try (ServerSocket serverSocket = new ServerSocket(port)) {
            ExecutorService executorService = Executors.newFixedThreadPool(10);// Limits client sockets count

            while (true) {
                final Socket clientSocket = serverSocket.accept();

                Runnable task = () -> {
                    try (Socket socket = clientSocket;
                         BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
                         PrintWriter out = new PrintWriter(socket.getOutputStream(), true)) {
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                };
            }
        }
    }
}
