
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Random;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Server {
    private static final int DEFAULT_PORT = 1234;

    public static void main(String[] args) throws IOException {
        int port = args.length == 0 ? DEFAULT_PORT : Integer.parseInt(args[0]);

        try (ServerSocket serverSocket = new ServerSocket(port)) {
            ExecutorService executorService = Executors.newFixedThreadPool(10);// Limits client sockets count

            Random random = new Random();

            while (true) {
                final Socket clientSocket = serverSocket.accept();

                final String valueToGuess = String.valueOf(random.nextInt(10));

                Runnable task = () -> {
                    System.out.println("Awaiting for " + valueToGuess);

                    try (Socket socket = clientSocket;
                         BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
                         PrintWriter out = new PrintWriter(socket.getOutputStream(), true)) {
                        do {
                            String receivedValue = in.readLine();

                            if (valueToGuess.equalsIgnoreCase(receivedValue)) {
                                System.out.println("Client is right. It is " + valueToGuess);
                                out.println("Yes");
                                break;
                            }
                            System.out.println("You are wrong! It isn't " + receivedValue);
                            out.println("No");
                        } while (true);
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                };

                executorService.execute(task);
            }
        }
    }
}
