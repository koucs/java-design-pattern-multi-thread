package Balking.Q4_4.linkedList;

public class Main {
    public static void main(String[] args) {
        RequestQueue req1 = new RequestQueue();
        RequestQueue req2 = new RequestQueue();
//        req1.putRequest(new Request("Hi"));
        new TalkThread(req1, req2, "Alice").start();
        new TalkThread(req2, req1, "Bob").start();
    }
}
