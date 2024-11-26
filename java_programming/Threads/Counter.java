public class Counter
{
    int count;
    Counter()
    {
        count = 0;
    }

    public synchronized void increment()
    {
        count++;
    }
}