package twoPhaseTermination.concurrent;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class Main {

    private static final int TASKS = 10;

    public static void main(String[] args) {
        System.out.println("BEGIN");
        ExecutorService service = Executors.newCachedThreadPool();
        CountDownLatch latch = new CountDownLatch(TASKS);

        try {
            IntStream.range(0, TASKS).forEach(i -> service.execute(new MyTask(latch, i)));

            System.out.println("AWAIT");
            latch.await();
        } catch (InterruptedException e) {
        } finally {
            service.shutdown();
            System.out.println("END");
        }
    }
}
