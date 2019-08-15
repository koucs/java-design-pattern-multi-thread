package ActiveObject.sample;

import ActiveObject.sample.activeObject.ActiveObject;
import ActiveObject.sample.activeObject.ActiveObjectFactory;
import ActiveObject.sample.activeObject.DisplayClientThread;
import ActiveObject.sample.activeObject.MakerClientThread;

public class Main {
  public static void main(String[] args) {
    ActiveObject activeObject = ActiveObjectFactory.createActiveObject();
    new MakerClientThread("Alice", activeObject).start();
    new MakerClientThread("Bobby", activeObject).start();
    new DisplayClientThread("Chris", activeObject).start();
  }
}
