package ActiveObject.concurrent.activeObject;

public class ActiveObjectFactory {
  public static ActiveObject createActiveObject() {
    return new ActiveObjectImpl();
  }
}
