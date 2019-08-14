package GuradedSuspension.Q3_5;

import java.util.LinkedList;
import java.util.Queue;

public class RequestQueue {
    private final Queue<Request> queue = new LinkedList<Request>();

    public synchronized Request getRequest() {
        while (queue.peek() == null) {
            try {
                System.out.println(Thread.currentThread().getName() + ": wait() start;");
                wait();
                System.out.println(Thread.currentThread().getName() + ": wait() end;");
            } catch (InterruptedException e) {

            }
        }
        return queue.remove();
    }

    public synchronized void putRequest(Request req) {
        queue.offer(req);
        System.out.println(Thread.currentThread().getName() + ": notifyAll() start;");
        notifyAll();
        System.out.println(Thread.currentThread().getName() + ": notifyAll() end;");
    }
}
