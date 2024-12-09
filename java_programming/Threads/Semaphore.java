import java.util.concurrent.Semaphore;

class Semaphores {
    int val;
    Semaphore semaphore;

    Semaphores() {
        val = 0;
        semaphore = new Semaphore(4);
    }

    public static void main(String[] args) throws InterruptedException {
        Semaphores mt = new Semaphores();
        Thread[] threads = new Thread[10];

        for (int i = 0; i < threads.length; i++) {
            threads[i] = new Thread(mt::increment);
            threads[i].start();
        }

        for (Thread t : threads) {
            t.join();
        }

        System.out.println("Final value: " + mt.val);
    }

    public void increment() {
        if(semaphore.tryAcquire())
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
            semaphore.release();
        }
        else
        {
            System.out.println(Thread.currentThread().getName() + " failed to acquire lock and couldn't update the value");
        }
    }
}
