package future.Q9_4;

import java.util.stream.IntStream;

public class RealData implements Data {
    private final String content;

    public RealData(int count, char c) {
        System.out.println("        making RealData(" + count + ", " + c + "):BEGIN");
        char[] buffer = new char[count];

        IntStream.range(0, count).forEach(i -> {
            buffer[i] = c;
            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
            }
        });
        System.out.println("        making RealData(" + count + ", " + c + "):END");
        this.content = new String(buffer);
    }

    @Override
    public String getContent() {
        return this.content;
    }
}
