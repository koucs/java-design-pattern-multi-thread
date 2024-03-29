package twoPhaseTermination.Q10_5;

import twoPhaseTermination.Q10_4.GracefulThread;

public class ServiceThread extends GracefulThread {

    private int count = 0;

    @Override
    protected void doWork() throws InterruptedException {
        System.out.print(".");
        Thread.sleep(100);
        count++;
        if(count >= 50){
            this.shutdownRequest();
        }
    }

    @Override
    protected void doShutdown() {
        System.out.println("done");
    }
}
