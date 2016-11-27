package ClientLogic;

import messages.Command;
import wrappers.Account;

import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.Socket;
import java.util.Set;

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
            //Receiver inThread = new Receiver(in);
            Sender outThread = new TCPSender(out);
            do{
                Command command = cvi.getMessage();//todo messageFactory
                out.write(command.toBytes());//todo в Sender
            }while(true);
        }
    }

}
