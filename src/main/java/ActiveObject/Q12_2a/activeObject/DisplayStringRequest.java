package ActiveObject.Q12_2a.activeObject;

class DisplayStringRequest extends MethodRequest<Object> {

  private final String string;

  DisplayStringRequest(Servant servant, String string) {
    super(servant, null);
    this.string = string;
  }

  @Override
  public void execute() {
    servant.displayString(string);
  }
}
