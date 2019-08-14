package twoPhaseTermination.Q10_2;

public class Main {
    public static void main(String[] args) {
        System.out.println("main: BEGIN");
        try {
            CountUpThread t = new CountUpThread();
            t.start();

            Thread.sleep(10000);

            System.out.println("main: shutdonwRequest");
            t.shutdownRequest();

            System.out.println("main: join: isAlive=" + t.isAlive());
            t.join();
            System.out.println("main: join: isAlive=" + t.isAlive());
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("main: END");
    }
}
