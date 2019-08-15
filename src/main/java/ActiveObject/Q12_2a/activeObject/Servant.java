package ActiveObject.Q12_2a.activeObject;

import java.math.BigInteger;
import java.util.stream.IntStream;

/**
 * RealResultを作成する役目
 *
 * @author acto_mini
 */
class Servant implements ActiveObject {
  @Override
  public Result<String> makeString(int count, char filterChar) {
    char[] buffer = new char[count];
    IntStream.range(0, count)
        .forEach(
            i -> {
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

  @Override
  public Result<String> add(String x, String y) {
    String result = null;
    try {
      BigInteger bix = new BigInteger(x);
      BigInteger biy = new BigInteger(y);
      BigInteger biz = bix.add(biy);
      result = biz.toString();
    } catch (NumberFormatException e) {
      e.printStackTrace();
    }
    return new RealResult<>(result);
  }
}
