package ActiveObject.Q12_2b;

import ActiveObject.Q12_2b.activeObject.ActiveObject;
import ActiveObject.Q12_2b.activeObject.ActiveObjectFactory;

public class Main {
  public static void main(String[] args) {
    ActiveObject activeObject = ActiveObjectFactory.createActiveObject();
    try {
      new AddClientThread("Diana", activeObject).start();
      Thread.sleep(5000);
    } catch (InterruptedException e) {
    } finally {
      System.out.println("**** shutdown ****");
      activeObject.shutdown();
    }
  }
}
