package ActiveObject.Q12_2a.activeObject;

class ActivationQueue {
  private static final int MAX_METHOD_REQUEST = 10;
  private final MethodRequest[] requestQueue;
  private int tail;
  private int count;
  private int head;

  ActivationQueue() {
    this.requestQueue = new MethodRequest[MAX_METHOD_REQUEST];
    this.head = this.count = this.tail = 0;
  }

  public synchronized void putRequest(MethodRequest request) {
    while (count >= requestQueue.length) {
      try {
        wait();
      } catch (InterruptedException e) {
      }
    }
    requestQueue[tail] = request;
    tail = (tail + 1) % requestQueue.length;
    count++;
    notifyAll();
  }

  public synchronized MethodRequest takeRequest() {
    while (count <= 0) {
      try {
        wait();
      } catch (InterruptedException e) {
      }
    }
    MethodRequest request = requestQueue[head];
    head = (head + 1) % requestQueue.length;
    count--;
    notifyAll();
    return request;
  }
}
