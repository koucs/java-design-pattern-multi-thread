package ThreadPerMessage.executorService;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class main {
    public static void main(String[] args) {
        System.out.println("main BEGIN");
        ExecutorService executorService = Executors.newCachedThreadPool();
        Host host = new Host(executorService);
        try {
            host.request(10, 'A');
            host.request(20, 'B');
            host.request(30, 'C');
        } finally {
            executorService.shutdown();
            System.out.println("main END");
        }
    }
}
