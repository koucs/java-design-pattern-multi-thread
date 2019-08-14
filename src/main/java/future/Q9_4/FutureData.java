package future.Q9_4;

import java.util.concurrent.ExecutionException;

public class FutureData implements Data {

    private RealData realData = null;
    private boolean ready = false;
    private ExecutionException exception = null;

    public synchronized void setRealData(RealData realData) {
        if (ready) {
            return; // balks
        }
        this.realData = realData;
        this.ready = true;
        notifyAll();
    }

    @Override
    public synchronized String getContent() throws ExecutionException {
        while (!ready) {
            try {
                wait();
            } catch (InterruptedException e) {
            }
        }
        if (exception != null) {
            throw exception;
        }
        return realData.getContent();
    }

    public synchronized void setException(Throwable throwable) {
        if (ready) {
            return;
        }
        this.exception = new ExecutionException(throwable);
        this.ready = true;
        notifyAll();
    }
}
