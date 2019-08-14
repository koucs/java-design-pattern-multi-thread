package future.Q9_2;

import future.Q9_2.content.Content;
import future.Q9_2.content.Retriever;

import java.io.FileOutputStream;
import java.io.IOException;

public class Main {
    public static void main(String[] args) {
        long start = System.currentTimeMillis();

        Content content1 = Retriever.retrieve("http://abehiroshi.la.coocan.jp/");
        Content content2 = Retriever.retrieve("http://www.google.com/");
        Content content3 = Retriever.retrieve("http://www.google.com/");

        saveToFile("content1.html", content1);
        saveToFile("content2.html", content2);
        saveToFile("content3.html", content3);

        long end = System.currentTimeMillis();

        System.out.println("Elapsed time = " + (end - start) + "msec.");
    }

    private static void saveToFile(String filename, Content content) {
        byte[] bytes = content.getBytes();
        try {
            System.out.println(Thread.currentThread().getName() + ": Saving to " + filename);
            FileOutputStream out = new FileOutputStream(filename);
            for (int i = 0; i < bytes.length; i++) {
                out.write(bytes[i]);
            }
            out.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


}
