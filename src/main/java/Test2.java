import java.util.concurrent.locks.ReentrantLock;

public class Test2 {
    public static void main(String[] args) {
        Counter counter = new Counter();
        ReentrantLock lock = new ReentrantLock();
        Thread t1 = new Thread(new CounterIncrement(counter, lock));
        Thread t2 = new Thread(new CounterIncrement(counter, lock));
        Thread t3 = new Thread(new CounterIncrement(counter, lock));

        t1.setName("Thread 1");
        t2.setName("Thread 2");
        t3.setName("Thread 3");

        t1.start();
        t2.start();
        t3.start();
    }
}
