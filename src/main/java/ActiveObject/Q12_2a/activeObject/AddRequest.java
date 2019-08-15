package ActiveObject.Q12_2a.activeObject;

public class AddRequest extends MethodRequest<String> {

  private final String x;
  private final String y;

  AddRequest(Servant servant, FutureResult<String> future, String x, String y) {
    super(servant, future);
    this.x = x;
    this.y = y;
  }

  @Override
  public void execute() {
    Result<String> result = servant.add(x, y);
    future.setResult(result);
  }
}
