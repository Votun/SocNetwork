package ClientLogic;

import messages.Response;

public interface Receiver extends Runnable{
    public Response receive();

}
