package ThreadPerMessage.scheduledExecutor.executorService;

import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;

public class main {
    public static void main(String[] args) {
        System.out.println("main BEGIN");
        ScheduledExecutorService executorService = Executors.newScheduledThreadPool(5);
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
