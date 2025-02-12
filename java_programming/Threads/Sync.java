import java.util.concurrent.Semaphore;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReadWriteLock;
import java.util.concurrent.locks.ReentrantLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

public class Sync {
    static int var = 0;
    static final Lock lock = new ReentrantLock();

    static void increment()
    {
        lock.lock();
        try {
            var++;
        }
        finally {
            lock.unlock();
        }
    }

    public static void main(String[] args) throws InterruptedException {
//        Thread[] threads = new Thread[100];
//
//        for(int i = 0; i < 100; i++)
//        {
//            threads[i] = new Thread(() -> {
//                for(int j = 0; j < 1000; j++) increment();
//            });
//            threads[i].start();
//        }
//
//        for(Thread thread : threads)
//        {
//            thread.join();
//        }
//        System.out.println(var);
//        String res = multiplyString("49032948539049238094209384902590096043580939840", "1002304439898239090239423948320943249053485908");
//        System.out.println(res);
    }

    private static String multiplyString(String s1, String s2)
    {
        java.math.BigInteger num1 = new java.math.BigInteger(s1);
        java.math.BigInteger num2 = new java.math.BigInteger(s2);
        java.math.BigInteger num3 = num1.multiply(num2);
        return num3.toString();
    }

    private void pattern(int n)
    {
        for(int i = 1; i <= n; i++)
        {
            if (n % 2 == 0)
            {
                
            }
        }
    }


//    private static synchronized void increment() {
//        var++;
//    }
}
