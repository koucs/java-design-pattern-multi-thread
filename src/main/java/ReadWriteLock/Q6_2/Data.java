package ReadWriteLock.Q6_2;

import ReadWriteLock.sample.ReadWriteLock;

public class Data {
    private final char[] buffer;
    private final ReadWriteLock lock = new ReadWriteLock();

    public Data(int size) {
        this.buffer = new char[size];
        for (int i = 0; i < buffer.length; i++) {
            buffer[i] = '*';
        }
    }

    public synchronized char[] read() throws InterruptedException {
        return doRead();
    }

    public synchronized void write(char c) throws InterruptedException {
        doWrite(c);
    }

    private char[] doRead() {
        char[] newbuf = new char[buffer.length];
//        newbuf = buffer.clone();
        for (int i = 0; i < buffer.length; i++) {
            newbuf[i] = buffer[i];
        }
        slowly();
        return newbuf;
    }

    private void doWrite(char c) {
        for (int i = 0; i < buffer.length; i++) {
            buffer[i] = c;
            slowly();
        }
    }

    private void slowly() {
        try {
            Thread.sleep(50);
        } catch (InterruptedException e) {
        }
    }
}
