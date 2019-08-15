package ActiveObject.Q12_2a.activeObject;

public interface ActiveObject {
  Result<String> makeString(int count, char filterChar);

  void displayString(String string);

  Result<String> add(String x, String y);
}
