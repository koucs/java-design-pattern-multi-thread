package workerThread.Q8_2;

public class Channel {

    public Channel(int threads) {
    }

    public void startWorkers() {
    }

    public synchronized void putRequest(Request request) {
        new Thread() {
            @Override
            public void run() {
                request.execute();
            }
        }.start();
    }

}
