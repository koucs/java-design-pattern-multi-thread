package ActiveObject.Q12_2a.activeObject;

class RealResult<T> extends Result<T> {
  private final T resultValue;

  RealResult(T resultValue) {
    this.resultValue = resultValue;
  }

  @Override
  public T getResultValue() {
    return resultValue;
  }
}
