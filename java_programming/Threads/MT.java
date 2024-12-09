import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class MT
{
    int val;
    Lock lock;
    MT() { val = 0; lock = new ReentrantLock(); }

    public static void main(String[] args) throws InterruptedException
    {
        MT mt = new MT();
        Thread[] threads = new Thread[10];

        for(int i = 0; i < threads.length; i++)
        {
            threads[i] = new Thread(mt::increment);
            threads[i].start();
        }

        for (Thread t : threads) {
            t.join();
        }

        System.out.println(mt.val);
    }

    public void increment()
    {
        if(lock.tryLock())
        {
            try
            {
                Thread.sleep(100);
                val++;
            }
            catch(InterruptedException e)
            {
                e.printStackTrace();
            }
            System.out.println(Thread.currentThread().getName() + " updated the value to " + val);
            lock.unlock();
        }
        else
        {
            System.out.println(Thread.currentThread().getName() + " failed to acquire lock and couldn't update the value");
        }
    }
}
