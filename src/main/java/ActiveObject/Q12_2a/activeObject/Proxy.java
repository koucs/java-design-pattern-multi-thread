package ActiveObject.Q12_2a.activeObject;

/** Futureを作成する役割 */
public class Proxy implements ActiveObject {

  private final SchedulerThread scheduler;
  private final Servant servant;

  Proxy(SchedulerThread scheduler, Servant servant) {
    this.scheduler = scheduler;
    this.servant = servant;
  }

  @Override
  public Result<String> makeString(int count, char filterChar) {
    FutureResult<String> future = new FutureResult<>();
    scheduler.invoke(new MakeStringRequest(servant, future, count, filterChar));
    return future;
  }

  @Override
  public void displayString(String string) {
    scheduler.invoke(new DisplayStringRequest(servant, string));
  }

  @Override
  public Result<String> add(String x, String y) {
    FutureResult<String> future = new FutureResult<>();
    scheduler.invoke(new AddRequest(servant, future, x, y));
    return future;
  }
}
