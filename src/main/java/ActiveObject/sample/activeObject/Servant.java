package ActiveObject.sample.activeObject;

import java.util.stream.IntStream;

/**
 * RealResultを作成する役目
 */
class Servant implements ActiveObject {
  @Override
  public Result<String> makeString(int count, char filterChar) {
    char[] buffer = new char[count];
    IntStream.range(0, count).forEach(i -> {
      buffer[i] = filterChar;
      try {
        Thread.sleep(100);
      } catch (InterruptedException e) {
      }
    });
    return new RealResult<>(new String(buffer));
  }

  @Override
  public void displayString(String string) {
    try {
      System.out.println("displayString: " + string);
      Thread.sleep(10);
    } catch (InterruptedException e) {
    }
  }
}
