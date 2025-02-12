import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class ExampleIforgotthenumber {
    // how to make the code deadlock
//    public static void main(String[] args) {
//        Lock lock1 = new ReentrantLock();
//        Lock lock2 = new ReentrantLock();
//
//        Thread t1 = new Thread(() -> {
//            try {
//                if(lock1.tryLock()) {
//                    System.out.println("Thread 1 lock1");
//                    try {
//                        Thread.sleep(1000);
//                        if(lock2.tryLock()) {
//                            try {
//                                System.out.println("Thread 1 lock2");
//                            } finally {
//                                lock2.unlock();
//                            }
//                        }
//                    } catch (InterruptedException e) {
//                        e.printStackTrace();
//                    } finally {
//                        lock1.unlock();
//                    }
//                }
//            } catch (Exception e) {
//                e.printStackTrace();
//            }
//        });
//
//        Thread t2 = new Thread(() -> {
//            try {
//                if(lock2.tryLock()) {
//                    System.out.println("Thread 2 lock2");
//                    try {
//                        Thread.sleep(1000);
//                        if(lock1.tryLock()) {
//                            try {
//                                System.out.println("Thread 2 lock1");
//                            } finally {
//                                lock1.unlock();
//                            }
//                        }
//                    } catch (InterruptedException e) {
//                        e.printStackTrace();
//                    } finally {
//                        lock2.unlock();
//                    }
//                }
//            } catch (Exception e) {
//                e.printStackTrace();
//            }
//        });
//
//        t1.start();
//        t2.start();
//    }

    public static void main(String[] args) {
        final Object lock1 = new Object();
        final Object lock2 = new Object();

        Thread thread1 = new Thread(() -> {
            synchronized (lock1) {
                System.out.println(Thread.currentThread().getName() + " locked lock1");

                synchronized (lock2) {
                    System.out.println(Thread.currentThread().getName() + " locked lock2");
                }
            }
        });

        Thread thread2 = new Thread(() -> {
            synchronized (lock1) {  // Same locking order as thread1
                System.out.println(Thread.currentThread().getName() + " locked lock1");

                synchronized (lock2) {
                    System.out.println(Thread.currentThread().getName() + " locked lock2");
                }
            }
        });

        thread1.start();
        thread2.start();
    }


}
