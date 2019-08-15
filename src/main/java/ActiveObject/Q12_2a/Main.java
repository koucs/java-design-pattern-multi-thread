package ActiveObject.Q12_2a;

import ActiveObject.Q12_2a.activeObject.ActiveObject;
import ActiveObject.Q12_2a.activeObject.ActiveObjectFactory;

public class Main {
  public static void main(String[] args) {
    ActiveObject activeObject = ActiveObjectFactory.createActiveObject();
    new MakerClientThread("Alice", activeObject).start();
    new MakerClientThread("Bobby", activeObject).start();
    new DisplayClientThread("Chris", activeObject).start();
  }
}
