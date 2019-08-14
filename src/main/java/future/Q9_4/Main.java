package future.Q9_4;

public class Main {
    public static void main(String[] args) {

        try {
            System.out.println(" main:BEGIN");
            Host host = new Host();

            Data data1 = host.request(-1, 'A');

            System.out.println("data1 = " + data1.getContent());
            System.out.println(" main:END");
        } catch (Exception e) {
            e.printStackTrace();
        }

    }
}
