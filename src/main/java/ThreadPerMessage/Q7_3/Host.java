package ThreadPerMessage.Q7_3;

public class Host {
    private final Helper helper = new Helper();

    public void request(final int count, final char c) {
        System.out.println("  request(" + count + ", " + c + ") BEGIN");
        new Thread() {
            @Override
            public void run() {
                helper.handle(count, c);
            }
        }.run();
        System.out.println("  request(" + count + ", " + c + ") END");
    }
}
