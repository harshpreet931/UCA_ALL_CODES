public class Basics {
    static int count = 0;
    // we use static because thread has a different scope, so we need to make the variable static
    // so that it can be accessed by the thread
    public static void main(String[] args) throws InterruptedException {
//        Thread t = new Thread(() -> System.out.println("Hello World"));
//        t.start();

//        Thread t2 = new Thread(new MyRunnable());
//        t2.start();

        Thread t = new Thread(() -> {
            for(int i = 0; i < 1000; i++)
            {
                count++;
            }
        });
        t.start();
        t.join(); // if we don't do this join, the main thread will print the count before the thread t finishes
                  // this is because the main thread will not wait for the thread t to finish
        System.out.println(count);
    }

//    static class MyRunnable implements Runnable {
//        public void run() {
//            System.out.println("Hello World");
//        }
//    }
}
