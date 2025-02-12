public class Threads {
    static class MyThread extends Thread {
        public void run() {
            System.out.println("Hello, From MyThread");
        }
    }

    static class MyRunnable implements Runnable {
        public void run() {
            System.out.println("Hello, From MyRunnable");
        }
    }

    volatile int val = 0;

    public static void main(String[] args) {
        Thread t1 = new Thread(() -> System.out.println("Hello"));
        //runnable -> .start()
        t1.start();

        MyThread t2 = new MyThread();
        t2.start();

        Thread t3 = new Thread(new MyRunnable());
        t3.start();

        // wait() -> .notify() -> .notifyAll()
        // MAX -> 10, MIN -> 1.

    }
}
