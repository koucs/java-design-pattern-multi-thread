package ActiveObject.Q12_2a;

import ActiveObject.Q12_2a.activeObject.ActiveObject;

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
