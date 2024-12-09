import java.util.concurrent.atomic.AtomicInteger;

public class AtmInteger {
    int val;

    public static void main(String[] args) throws InterruptedException
    {
        AtomicInteger atm = new AtomicInteger();
        Thread[] threads = new Thread[1000];

        for(int i = 0; i < threads.length; i++)
        {
            threads[i] = new Thread(() -> atm.incrementAndGet());
            threads[i].start();
        }

        for (Thread t : threads) {
            t.join();
        }

        System.out.println(atm.get());
    }
}
