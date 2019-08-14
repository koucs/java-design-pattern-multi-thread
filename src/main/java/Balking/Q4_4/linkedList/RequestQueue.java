package Balking.Q4_4.linkedList;

import Balking.Q4_4.LIvenessException;

import java.util.LinkedList;
import java.util.Queue;

public class RequestQueue {

    private static final long TIMEOUT = 10000;

    private final Queue<Request> queue = new LinkedList<Request>();

    public synchronized Request getRequest() {
        long start = System.currentTimeMillis();
        while (queue.peek() == null) {
            long now = System.currentTimeMillis();
            long rest = TIMEOUT - (now - start);
            if (rest <= 0) {
                throw new LIvenessException("thrown by " + Thread.currentThread().getName());
            }

            try {
                System.out.println(Thread.currentThread().getName() + ": wait() start;");
                wait(rest);
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
