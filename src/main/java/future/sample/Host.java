package future.sample;

public class Host {

    public Data request(final int count, final char c) {
        System.out.println("    request(" + count + ", " + c + "):BEGIN");
        FutureData futureData = new FutureData();

        new Thread() {
            @Override
            public void run() {
                RealData realData = new RealData(count, c);
                futureData.setRealData(realData);
            }
        }.start();
        System.out.println("    request(" + count + ", " + c + "):END");

        return futureData;
    }
}