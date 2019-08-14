package Balking.Q4_5;

public class main {
    public static void main(String[] argv) {
        Thread thread = new TestThread();
        while (true) {
            thread.run();
        }
    }
}
