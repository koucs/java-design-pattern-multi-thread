package workerThread.sample;

public class Main {
    public static void main(String[] argv) {
        Channel channel = new Channel(5);
        channel.startWorkers();
        new ClientThread("Alice", channel).start();
        new ClientThread("Bobby", channel).start();
        new ClientThread("Chris", channel).start();
        try {
            Thread.sleep(30000);
        } catch (InterruptedException e) {
        }

        System.exit(0);
    }
}
