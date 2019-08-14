package threadSpecificStorage.sample2;

public class Log {
    private static final ThreadLocal<TsLog> tsLogCollection = new ThreadLocal<>();

    public static void println(String s) {
        getTsLog().println(s);
    }

    public static void close() {
        getTsLog().close();
    }

    private static TsLog getTsLog() {
        TsLog log = tsLogCollection.get();

        if (log == null) {
            log = new TsLog(Thread.currentThread().getName() + "-log.txt");
            tsLogCollection.set(log);
        }

        return log;
    }
}
