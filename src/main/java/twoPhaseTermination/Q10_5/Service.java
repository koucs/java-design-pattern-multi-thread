package twoPhaseTermination.Q10_5;

import twoPhaseTermination.Q10_4.GracefulThread;

public class Service {
    private static GracefulThread thread = null;

    public synchronized static void service() {
        System.out.print("service");

        if (thread != null && thread.isAlive()) {
            System.out.print("balked");
            return;
        }

        thread = new ServiceThread();
        thread.start();
    }

    public synchronized static void cancel() {
        if (thread != null) {
            System.out.print("cancel.");
            thread.shutdownRequest();
        }
    }
}
