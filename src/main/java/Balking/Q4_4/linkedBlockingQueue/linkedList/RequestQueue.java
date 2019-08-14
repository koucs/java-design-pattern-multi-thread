package Balking.Q4_4.linkedBlockingQueue.linkedList;

import Balking.Q4_4.LIvenessException;

import java.util.LinkedList;
import java.util.Queue;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.TimeUnit;

public class RequestQueue {

    private static final long TIMEOUT = 10000;

    private final BlockingQueue<Request> queue = new LinkedBlockingQueue<Request>();

    public Request getRequest() {
        Request req = null;
        try {
            req = queue.poll(TIMEOUT, TimeUnit.MILLISECONDS);
        } catch (InterruptedException e) {
        }
        return req;
    }

    public void putRequest(Request req) {
        try {
            queue.put(req);
        } catch (InterruptedException e) {
        }
    }
}
