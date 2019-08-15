package ActiveObject.Q12_2b;

import ActiveObject.Q12_2b.activeObject.ActiveObject;

import java.util.concurrent.CancellationException;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;
import java.util.concurrent.RejectedExecutionException;

public class AddClientThread extends Thread {
  private final ActiveObject activeObject;
  private String x = "1";
  private String y = "1";

  public AddClientThread(String name, ActiveObject activeObject) {
    super(name);
    this.activeObject = activeObject;
  }

  @Override
  public void run() {
    try {
      for (int i = 0; true; i++) {
        Future<String> result = activeObject.add(x, y);
        Thread.sleep(100);
        String z = result.get();
        System.out.println(Thread.currentThread().getName() + ": " + x + " + " + y + " = " + z);
        x = y;
        y = z;
      }
    } catch (RejectedExecutionException
        | CancellationException
        | ExecutionException
        | InterruptedException e) {
      System.out.println(Thread.currentThread().getName() + ":" + e);
    }
  }
}
