package legacy;

import messages.Response;

public interface Receiver extends Runnable{
    Response receive();

}
