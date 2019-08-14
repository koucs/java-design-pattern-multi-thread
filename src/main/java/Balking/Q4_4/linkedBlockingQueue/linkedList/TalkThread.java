package Balking.Q4_4.linkedBlockingQueue.linkedList;

public class TalkThread extends Thread {
    private final RequestQueue input;
    private final RequestQueue output;

    public TalkThread(RequestQueue input, RequestQueue output, String name) {
        super(name);
        this.input = input;
        this.output = output;
    }

    @Override
    public void run() {
        System.out.println(Thread.currentThread().getName() + " :BEGIN");
        for (int i = 0; i < 20; i++) {
            Request req1 = input.getRequest();
            System.out.println(Thread.currentThread().getName() + " gets " + req1);

            Request req2 = new Request(req1.getName() + "!");
            System.out.println(Thread.currentThread().getName() + " puts " + req2);
            output.putRequest(req2);
        }
        System.out.println(Thread.currentThread().getName() + " :END");
    }
}
