package ProducerConsumer.Q5_7;

public class main {
    public static void main(String[] args) {
        Thread exec = new Thread() {
            @Override
            public void run() {
                try {
                    Host.execute(2);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        };
        exec.start();

        try {
            Thread.sleep(12000);
        } catch (InterruptedException e) {
        }

        exec.interrupt();

        System.out.println(" interruptted ");
    }

}
