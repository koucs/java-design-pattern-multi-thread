package ProducerConsumer.Q5_6;

import java.util.ArrayList;
import java.util.List;

public class main {
    public static void main(String[] args) {
        Table table = new Table(3);
        List<Thread> threads = new ArrayList<Thread>();
        threads.add(new MakerThread("Mkr-1", table, 333333));
        threads.add(new MakerThread("Mkr-2", table, 222222));
        threads.add(new MakerThread("Mkr-3", table, 111111));
        threads.add(new EaterThread("Etr-1", table, 444444));
        threads.add(new EaterThread("Etr-2", table, 555555));
        threads.add(new EaterThread("Etr-3", table, 666666));

        threads.forEach(Thread::start);

        try {
            Thread.sleep(10000);
        } catch (InterruptedException e) {
        }

        threads.forEach(Thread::interrupt);
    }
}
