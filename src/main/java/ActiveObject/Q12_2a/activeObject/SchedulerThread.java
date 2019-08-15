package ActiveObject.Q12_2a.activeObject;

import ActiveObject.sample.activeObject.ActiveObject;

class SchedulerThread extends Thread {
  private final ActivationQueue queue;

  SchedulerThread(ActivationQueue queue) {
    this.queue = queue;
  }

  public void invoke(MethodRequest request) {
    queue.putRequest(request);
  }

  @Override
  public void run() {
    while (true) {
      MethodRequest request = queue.takeRequest();
      request.execute();
    }
  }
}
