package ProducerConsumer.Q5_2;

public class main {
    public static void main(String[] args) {
        new MakerThread("Alice", new Table(3), 333333).start();
        new EaterThread("Bobby", new Table(3), 444444).start();
    }
}
