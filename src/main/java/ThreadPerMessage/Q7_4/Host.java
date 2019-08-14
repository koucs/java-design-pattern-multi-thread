package ThreadPerMessage.Q7_4;

public class Host {

    public void request(final int count, final char c) {
        System.out.println("  request(" + count + ", " + c + ") BEGIN");
        new MyThread(count, c).start();
        System.out.println("  request(" + count + ", " + c + ") END");
    }
}

class MyThread extends Thread {
    private final int count;
    private final char c;
    private final Helper helper = new Helper();

    public MyThread(int count, char c) {
        super("name");
        this.count = count;
        this.c = c;
    }

    @Override
    public void run() {
        helper.handle(count, c);
    }
}