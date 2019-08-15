package ActiveObject.concurrent.activeObject;


import java.util.concurrent.Future;

public interface ActiveObject {
  Future<String> makeString(int count, char filterChar);

  void displayString(String string);

  void shutdown();
}
