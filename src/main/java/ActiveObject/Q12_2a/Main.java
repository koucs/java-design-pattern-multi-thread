package ActiveObject.Q12_2a;

import ActiveObject.Q12_2a.activeObject.ActiveObject;
import ActiveObject.Q12_2a.activeObject.ActiveObjectFactory;

public class Main {
  public static void main(String[] args) {
    ActiveObject activeObject = ActiveObjectFactory.createActiveObject();
    new AddClientThread("Diana", activeObject).start();
  }
}
