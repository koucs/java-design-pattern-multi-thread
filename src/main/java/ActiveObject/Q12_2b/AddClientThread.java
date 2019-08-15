package ActiveObject.Q12_2b;

import ActiveObject.Q12_2b.activeObject.ActiveObject;

import java.util.concurrent.CancellationException;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;
import java.util.concurrent.RejectedExecutionException;

public class AddClientThread extends Thread {
  private final ActiveObject activeObject;
  private final char filterChar;

  public AddClientThread(String name, ActiveObject activeObject) {
    super(name);
    this.activeObject = activeObject;
    this.filterChar = name.charAt(0);
  }

  @Override
  public void run() {
    try {
      for (int i = 0; true; i++) {
        Future<String> result = activeObject.makeString(i, filterChar);
        Thread.sleep(10);
        String value = result.get();
        System.out.println(Thread.currentThread().getName() + ": value = " + value);
      }
    } catch (RejectedExecutionException | CancellationException | ExecutionException | InterruptedException e) {
      System.out.println(Thread.currentThread().getName() + ":" + e);
    }
  }
}
