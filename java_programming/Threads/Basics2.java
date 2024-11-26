public class Basics2 {
    public static void main(String[] args) throws InterruptedException {
        Counter counter = new Counter();
        MyThread[] threads = new MyThread[10];

        for(int i = 0; i < 10; i++)
        {
            threads[i] = new MyThread(counter);
            threads[i].start();
        }

        for(int i = 0; i < 10; i++)
        {
            threads[i].join();
        }


        // The output of this program is not always 100_000_000
        // because the increment operation is not atomic... cause the threads can interfere with each other

        System.out.println(counter.count);
    }
}
