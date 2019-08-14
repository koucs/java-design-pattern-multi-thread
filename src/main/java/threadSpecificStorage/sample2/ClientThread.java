package threadSpecificStorage.sample2;

import java.util.stream.IntStream;

public class ClientThread extends Thread {
    public ClientThread(String name) {
        super(name);
    }

    @Override
    public void run() {
        System.out.println(getName() + " BEGIN");
        IntStream.range(0, 10).forEach(i -> {
            Log.println("i = " + i);
            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
            }
        });
        Log.close();
        System.out.println(getName() + " END");
    }
}
