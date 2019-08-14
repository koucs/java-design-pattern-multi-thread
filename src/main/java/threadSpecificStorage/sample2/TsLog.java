package threadSpecificStorage.sample2;

import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

public class TsLog {
    private PrintWriter writer = null;

    public TsLog(String fileName) {
        try {
            writer = new PrintWriter(new FileWriter(fileName));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void println(String s) {
        writer.println(s);
    }

    public void close() {
        writer.println("===== End of Log =====");
        writer.close();
    }
}
