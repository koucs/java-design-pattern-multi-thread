package Balking.sample;

public class Main {
    public static void main(String[] args) {
        Data data = new Data("data.txt", "(empty)");
        new ChangerThread("Changer", data).start();
        new SaverThread("Saver", data).start();
    }
}
