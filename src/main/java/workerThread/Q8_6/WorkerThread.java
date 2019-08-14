package workerThread.Q8_6;

public class WorkerThread extends Thread {
    private final Channel channel;
    private volatile boolean terminated = false;

    public WorkerThread(String name, Channel channel) {
        super(name);
        this.channel = channel;
    }

    @Override
    public void run() {
        try {
            while (!terminated) {
                Request request = channel.takeRequest();
                request.execute();
            }
        } catch (InterruptedException e){
            terminated = true;
        } finally {
            System.out.println(Thread.currentThread().getName() + " is trminted.");
        }
    }

    public void stopThread(){
        terminated = true;
        interrupt();
    }
}
