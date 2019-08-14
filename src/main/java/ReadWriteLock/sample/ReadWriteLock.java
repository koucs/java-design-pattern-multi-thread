package ReadWriteLock.sample;

public class ReadWriteLock {
    private int readingReaders = 0; // (A) 実際に読んでいる最中のthread
    private int waitingWriters = 0; // (B) 書くのを待っているthraed数
    private int writingWriters = 0; // (C) 書いている最中のthread数
    private boolean preferWriter = true; // 書くのを優先するならtrue

    public synchronized void readLock() throws InterruptedException {
        while (writingWriters > 0 || (preferWriter && waitingWriters > 0)) {
            wait();
        }
        readingReaders++;                       // (A) 実際に読んでいるthreadを++
    }

    public synchronized void readUnlock() {
        readingReaders--;                       // (A) 実際に読んでいるthreadを--
        preferWriter = true;
        notifyAll();
    }

    public synchronized void writeLock() throws InterruptedException {
        waitingWriters++;                       // (B) 書くのを待っているtheadを++
        try {
            while (readingReaders > 0 || writingWriters > 0) {
                wait();
            }
        } finally {
            waitingWriters--;                   // (B) 書くのを待っているtheadを--
        }
        writingWriters++;                       // (C) 書いている最中のthreadを++
    }

    public synchronized void writeUnlock() {
        writingWriters--;                       // (C) 書いている最中のthreadを++
        preferWriter = false;
        notifyAll();
    }
}
