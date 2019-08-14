package threadSpecificStorage.sample1;

import java.util.stream.IntStream;

public class Main {
    public static void main(String[] args) {
        System.out.println("BEGIN");
        IntStream.range(0, 10).forEach(i -> {
            Log.println("main: i = " + i);
            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
            }
        });
        Log.close();
        System.out.println("END");
    }
}
