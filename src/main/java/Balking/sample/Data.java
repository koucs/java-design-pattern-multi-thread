package Balking.sample;

import java.io.FileWriter;
import java.io.IOException;
import java.io.Writer;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Data {
    private final String finleName;
    private String content;
    private boolean changed;
    private static final SimpleDateFormat formatter = new SimpleDateFormat("HH:mm:ss.SSS");

    public Data(String fileName, String content) {
        this.finleName = fileName;
        this.content = content;
    }

    public synchronized void changed(String newContent) {
        this.content = newContent;
        changed = true;
    }

    public void save() throws IOException {
        if (!changed) {
            Date date = new Date(System.currentTimeMillis());
            System.out.println(formatter.format(date) + " " + Thread.currentThread().getName() + " save balked, content = " + this.content + ", changed=" + this.changed);
            return;
        }
        doSave();
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
        }
        changed = false;
    }

    private void doSave() throws IOException {
        Date date = new Date(System.currentTimeMillis());
        System.out.println(formatter.format(date) + " " + Thread.currentThread().getName() + " calls doSave, content = " + this.content);
        Writer writer = new FileWriter(this.finleName);
        writer.write(this.content);
        writer.close();
    }
}
