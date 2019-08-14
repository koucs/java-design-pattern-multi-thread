package future.Q9_4;

public class Host {

    public Data request(final int count, final char c) {
        System.out.println("    request(" + count + ", " + c + "):BEGIN");
        FutureData futureData = new FutureData();

        new Thread() {
            @Override
            public void run() {
                try {
                    RealData realData = new RealData(count, c);
                    futureData.setRealData(realData);
                } catch (Exception e){
                    futureData.setException(e);
                }
            }
        }.start();
        System.out.println("    request(" + count + ", " + c + "):END");

        return futureData;
    }
}