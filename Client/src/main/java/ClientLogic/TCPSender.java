package ClientLogic;


import messages.Command;

import java.io.IOException;
import java.io.OutputStream;

public class TCPSender implements Sender{
    private OutputStream outputStream;

    public TCPSender(OutputStream outputStream) {
        this.outputStream = outputStream;
    }

    @Override
    public void send(Command message) throws IOException {
        outputStream.write(message.toBytes());
    }
}
