package ActiveObject.sample.activeObject;

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
