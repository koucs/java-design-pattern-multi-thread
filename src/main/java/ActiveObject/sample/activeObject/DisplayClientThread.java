package ActiveObject.sample.activeObject;

import java.util.stream.IntStream;

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
    } catch (InterruptedException e) {
    }
  }
}
