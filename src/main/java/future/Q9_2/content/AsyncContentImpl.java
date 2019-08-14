package future.Q9_2.content;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.FutureTask;

public class AsyncContentImpl extends FutureTask<SyncContentImpl> implements Content {

    public AsyncContentImpl(Callable<SyncContentImpl> callable) {
        super(callable);
    }

    @Override
    public byte[] getBytes() {
        byte[] bytes = new byte[1];
        try {
            bytes = get().getBytes();
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        }
        return bytes;
    }
}
