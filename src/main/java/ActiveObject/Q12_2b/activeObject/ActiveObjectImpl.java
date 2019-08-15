package ActiveObject.Q12_2b.activeObject;

import java.math.BigInteger;
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
        IntStream.range(0, count)
            .forEach(
                i -> {
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
  public Future<String> add(String x, String y) {
    class AddRequest implements Callable<String> {
      @Override
      public String call() throws Exception {
        String result = null;
        try {
          BigInteger bix = new BigInteger(x);
          BigInteger biy = new BigInteger(y);
          BigInteger biz = bix.add(biy);
          result = biz.toString();
        } catch (NumberFormatException e) {
          e.printStackTrace();
        }
        return result;
      }
    }

    return service.submit(new AddRequest());
  }

  @Override
  public void shutdown() {
    service.shutdown();
  }
}
