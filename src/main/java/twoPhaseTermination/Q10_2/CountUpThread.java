package twoPhaseTermination.Q10_2;

public class CountUpThread extends Thread {
    private long counter = 0;
    private volatile boolean shutdownRequested = false;

    public void shutdownRequest() {
//        this.shutdownRequested = true;
        interrupt();
    }

    public boolean isShutdownRequested() {
        return this.shutdownRequested;
    }

    @Override
    public void run() {
        try {
            while (!isInterrupted()) {
                doWork();
            }
        } catch (InterruptedException e) {
        } finally {
            doShutdown();
        }
    }

    private void doWork() throws InterruptedException {
        counter++;
        System.out.println("doWork: counter = " + counter);
        try {
            Thread.sleep(500);
        } catch (InterruptedException e) {
        }
    }

    private void doShutdown() {
        System.out.println("doShutdown: counter = " + counter);
    }
}
