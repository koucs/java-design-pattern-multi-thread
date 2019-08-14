package GuradedSuspension.Q3_5;

import GuradedSuspension.linkedList.ClientThread;
import GuradedSuspension.linkedList.ServerThread;

public class Main {
    public static void main(String[] args) {
        RequestQueue req1 = new RequestQueue();
        RequestQueue req2 = new RequestQueue();
        req1.putRequest(new Request("Hi"));
        new TalkThread(req1, req2, "Alice").start();
        new TalkThread(req2, req1, "Bob").start();
    }
}
