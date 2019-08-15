package ActiveObject.sample.activeObject;

public interface ActiveObject {
  Result<String> makeString(int count, char filterChar);

  void displayString(String string);
}
