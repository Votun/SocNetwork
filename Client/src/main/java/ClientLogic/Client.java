package ClientLogic;

import messages.Command;

import java.io.*;
import java.net.Socket;
import java.util.Set;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Client {
    private static final String DEFAULT_HOST = "localhost"; // 127.0.0.1
    private static final int DEFAULT_PORT = 1234;
    Account myAccount;
    Set<Account> friends;
    public static void startGUI(){}

    public static void main(String[] args) throws IOException{
        String serverHost = args.length > 0 ? args[0] : DEFAULT_HOST;
        int serverPort = args.length > 1 ? Integer.parseInt(args[1]) : DEFAULT_PORT;
        startGUI();
        try(Socket serverSocket = new Socket(serverHost, serverPort);
                InputStreamReader in = new InputStreamReader(serverSocket.getInputStream());
                OutputStream out = serverSocket.getOutputStream())
        {
            Receiver inThread = new Receiver(in);
            Sender outThread = new Sender(out);
            do{
                Command command = cvi.getMesaage();//todo messageFactory
                out.write(command.toBytes());//todo в Sender
            }while(true);
        }
    }

}
