package legacy;

import messages.Command;

import java.io.IOException;

public interface Sender {
    void send(Command message) throws IOException;
}
