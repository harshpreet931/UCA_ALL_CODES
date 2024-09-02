import java.util.*;

public class testThread {
    public static void main(String[] args) {
        long startTime = System.currentTimeMillis();
        List<Integer> l = new ArrayList<>();
        Thread t1 = new ListAdder(l, 1);
        Thread t2 = new ListAdder(l, 2);
        Thread t3 = new ListAdder(l, 3);
        Thread t4 = new ListAdder(l, 4);

        t1.start();
        t2.start();
        t3.start();
        t4.start();
        System.out.println(Thread.currentThread().getName() + " is adding " + 3); 
        l.add(3);
        try {
            t1.join();
            t2.join();
            t3.join();
            t4.join();
        } 
        catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println(l);
        long endTime = System.currentTimeMillis();
        System.out.println("Time taken: " + (endTime - startTime) + "ms");
    }

    private static class ListAdder extends Thread {
        private List<Integer> l;
        private int i;
        
        public ListAdder(List<Integer> l, int i) {
            this.l = l;
            this.i = i;
        }

        public void run() {
            synchronized (this.l) {
                // Critical section
                System.out.println(Thread.currentThread().getName() + " is adding " + i);
                this.l.add(i);
            }
            
            // Simulating some work Non-critical section
            try {
                Thread.sleep(1000);
            } 
            catch (InterruptedException e) {
                e.printStackTrace();
            }            
        }
    }
}
