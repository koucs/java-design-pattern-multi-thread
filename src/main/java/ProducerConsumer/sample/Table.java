package ProducerConsumer.sample;

public class Table {
    private final String[] buffer;
    private int tail; // the place where next put
    private int head; // the place where next take
    private int count;// the count of cake in buffer

    public Table(int count) {
        this.buffer = new String[count];
        this.head = 0;
        this.tail = 0;
        this.count = 0;
    }

    public synchronized void put(String cake) throws InterruptedException {
        System.out.println(Thread.currentThread().getName() + " puts " + cake);
        while (count >= this.buffer.length) {
            System.out.println(Thread.currentThread().getName() + " puts wait START ");
            wait();
            System.out.println(Thread.currentThread().getName() + " puts wait END ");
        }
        buffer[tail] = cake;
        tail = (tail + 1) % buffer.length;
        count++;
        notifyAll();
    }

    public synchronized String take() throws InterruptedException {
        while (count <= 0) {
            System.out.println(Thread.currentThread().getName() + " take wait START ");
            wait();
            System.out.println(Thread.currentThread().getName() + " take wait END ");
        }
        String cake = buffer[head];
        head = (head + 1) % buffer.length;
        count--;
        notifyAll();
        System.out.println(Thread.currentThread().getName() + " takes " + cake);
        return cake;
    }

    public synchronized void clear() throws InterruptedException {
        while (count > 0) {
            String cake = buffer[head];
            System.out.println(Thread.currentThread().getName() + " clears " + cake);
            head = (head + 1) % buffer.length;
            count--;
        }

        this.head = 0;
        this.tail = 0;
        this.count = 0;
    }
}
