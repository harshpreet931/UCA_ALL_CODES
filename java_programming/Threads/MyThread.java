public class MyThread extends Thread{
    public Counter counter;
    public int times = 0;

    MyThread(Counter counter)
    {
        this.counter = counter;
        this.times = 10_000_000;
    }

    public void run()
    {
        System.out.println(Thread.currentThread().getName() + " started");
        for (int i = 0; i < times; i++)
        {
            counter.increment();
        }
        System.out.println(Thread.currentThread().getName() + " finished");
    }
}
