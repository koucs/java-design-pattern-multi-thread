package GuradedSuspension.linkedList;

import java.util.Random;

public class ServerThread extends Thread {
    private final Random random;
    private final RequestQueue queue;

    public ServerThread(RequestQueue requestQueue, String name, long seed) {
        super(name);
        queue = requestQueue;
        random = new Random(seed);
    }

    @Override
    public void run() {
        for (int i = 0; i < 10000; i++) {
            Request request = queue.getRequest();
            System.out.println(Thread.currentThread().getName() + " handles  " + request);
            try {
                Thread.sleep(random.nextInt(1000));
            } catch (InterruptedException e) {
            }
        }
    }
}
