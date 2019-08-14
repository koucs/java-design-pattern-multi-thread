package ProducerConsumer.Q5_8;

public class main {
    public static void main(String[] args) {
        Table table = new Table(3);
        new MakerThread("Mkr-1", table, 333333).start();
        new MakerThread("Mkr-2", table, 222222).start();
        new MakerThread("Mkr-3", table, 111111).start();
        new EaterThread("Etr-1", table, 444444).start();
        new EaterThread("Etr-2", table, 555555).start();
        new EaterThread("Etr-3", table, 666666).start();
    }
}
