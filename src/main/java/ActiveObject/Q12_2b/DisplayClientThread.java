package ActiveObject.Q12_2b;

import ActiveObject.Q12_2b.activeObject.ActiveObject;

import java.util.concurrent.CancellationException;
import java.util.concurrent.RejectedExecutionException;

public class DisplayClientThread extends Thread {
  private final ActiveObject activeObject;

  public DisplayClientThread(String name, ActiveObject activeObject) {
    super(name);
    this.activeObject = activeObject;
  }

  @Override
  public void run() {
    try {
      for (int i = 0; ; i++) {
        String string = Thread.currentThread().getName() + " " + i;
        activeObject.displayString(string);
        Thread.sleep(200);
      }
    } catch (InterruptedException | CancellationException | RejectedExecutionException e) {
      System.out.println(Thread.currentThread().getName() + ":" + e);
    }
  }
}
