package ActiveObject.Q12_2a;

import ActiveObject.Q12_2a.activeObject.ActiveObject;
import ActiveObject.Q12_2a.activeObject.Result;

public class MakerClientThread extends Thread {
  private final ActiveObject activeObject;
  private final char filterChar;

  public MakerClientThread(String name, ActiveObject activeObject) {
    super(name);
    this.activeObject = activeObject;
    this.filterChar = name.charAt(0);
  }

  @Override
  public void run() {
    try {
      for (int i = 0; true; i++) {
        Result<String> result = activeObject.makeString(i, filterChar);
        Thread.sleep(10);
        String value = result.getResultValue();
        System.out.println(Thread.currentThread().getName() + ": value = " + value);
      }
    } catch (InterruptedException e) {
    }
  }
}
