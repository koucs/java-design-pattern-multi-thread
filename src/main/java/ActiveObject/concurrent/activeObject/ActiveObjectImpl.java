package ActiveObject.concurrent.activeObject;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.stream.IntStream;

public class ActiveObjectImpl implements ActiveObject {
  private final ExecutorService service = Executors.newSingleThreadExecutor();

  @Override
  public Future<String> makeString(int count, char filterChar) {

    class MakeStringRequest implements Callable<String> {
      @Override
      public String call() throws Exception {
        char[] buffer = new char[count];
        IntStream.range(0, count).forEach(i -> {
          buffer[i] = filterChar;
          try {
            Thread.sleep(100);
          } catch (InterruptedException e) {
          }
        });
        return new String(buffer);
      }
    }

    return service.submit(new MakeStringRequest());
  }

  @Override
  public void displayString(String string) {

    class DisplayStringRequest implements Runnable {
      @Override
      public void run() {
        try {
          System.out.println("displayString: " + string);
          Thread.sleep(10);
        } catch (InterruptedException e) {
        }
      }
    }

    service.execute(new DisplayStringRequest());
  }

  @Override
  public void shutdown() {
    service.shutdown();
  }
}
