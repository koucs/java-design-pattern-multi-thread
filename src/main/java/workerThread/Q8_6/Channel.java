package workerThread.Q8_6;

import java.util.stream.IntStream;

public class Channel {
    private static final int MAX_REQUEST = 100;
    private final Request[] requestQueue;
    private int tail;
    private int head;
    private int count;

    private final WorkerThread[] threadPool;

    public Channel(int threads) {
        this.requestQueue = new Request[MAX_REQUEST];
        this.head = 0;
        this.tail = 0;
        this.count = 0;

        this.threadPool = new WorkerThread[threads];
        IntStream.range(0, threadPool.length - 1).forEach(i -> {
            threadPool[i] = new WorkerThread("Worker-" + i, this);
        });
    }

    public void startWorkers() {
        IntStream.range(0, threadPool.length - 1).forEach(i -> threadPool[i].start());
    }

    public void stopAllWorkers() {
        IntStream.range(0, threadPool.length - 1).forEach(i -> {
            threadPool[i].stopThread();
        });
    }

    public synchronized void putRequest(Request request) throws InterruptedException {
        while (count >= requestQueue.length) {
            wait();
        }
        requestQueue[tail] = request;
        tail = (tail + 1) % requestQueue.length;
        count++;
        notifyAll();
    }

    public synchronized Request takeRequest() throws InterruptedException {
        while (count <= 0) {
            wait();
        }
        Request request = requestQueue[head];
        head = (head + 1) % requestQueue.length;
        count--;
        notifyAll();
        return request;
    }

}
