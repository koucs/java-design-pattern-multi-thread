package future.Q9_2.content;

import java.util.concurrent.Callable;

public class Retriever {
    public static Content retrieve(String urlStr) {
        AsyncContentImpl content = new AsyncContentImpl(
                new Callable<SyncContentImpl>() {
                    @Override
                    public SyncContentImpl call() throws Exception {
                        return new SyncContentImpl(urlStr);
                    }
                }
        );
        new Thread(content).start();
        return content;
    }
}
