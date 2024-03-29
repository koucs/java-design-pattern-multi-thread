package ThreadPerMessage.Q7_7;

public class Blackhole {
    public static void enter(Object obj) {
        System.out.println("Step 1");
        magic(obj);
        System.out.println("Step 2");
        synchronized (obj) {
            System.out.println("Step 3 (never reached here)");
        }
    }

    public static void magic(Object obj) {
        Thread thread = new Thread() {
            @Override
            public void run() {
                synchronized (obj) {
                    synchronized (this) {
                        this.setName("done");
                        notifyAll();
                    }
                    while (true) {
                    }
                }
            }
        };
        synchronized (thread) {
            thread.setName("");
            thread.start();
            while (thread.getName().equals("")) {
                try {
                    thread.wait();
                } catch (InterruptedException e) {
                }
            }
        }
    }
}
