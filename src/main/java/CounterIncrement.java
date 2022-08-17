import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class CounterIncrement implements Runnable{
    private Counter counter;
    private Lock lock;

    public CounterIncrement(Counter counter, ReentrantLock lock) {
        this.counter = counter;
        this.lock = lock;
    }

    @Override
    public void run() {
        for (int i = 0; i < 5; i++) {
            lock.lock();
            counter.incrementCount();
            System.out.println(Thread.currentThread().getName() + ": " + counter.getCount());
            lock.unlock();
            try {
                Thread.sleep(10);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
