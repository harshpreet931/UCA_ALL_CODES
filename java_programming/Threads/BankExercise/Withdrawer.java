package BankExercise;

public class Withdrawer extends Thread {

    Bank bank;
    int sleepCount = 0;
    Withdrawer(Bank bank)
    {
        this.bank = bank;
        synchronized (bank)
        {
            bank.activeUsers++;
        }
    }

    public void run()
    {
        int withdraw = (int) (Math.random() * 100);
        synchronized (bank)
        {
            while (bank.balance < withdraw)
            {
                System.out.println("Insufficient balance for withdrawal of " + withdraw + ". Waiting... Thread: " + Thread.currentThread().getName());
                try {
                    bank.wait(1000);
                }
                catch (InterruptedException e) {
                    e.printStackTrace();
                }
                if (bank.balance < withdraw)
                {
                    System.out.println("Balance still insufficient after waiting. Terminating thread: " + Thread.currentThread().getName());
                    bank.activeUsers--;
                    return;
                }
            }
            bank.balance -= withdraw;
            System.out.println("Withdrawn: " + withdraw + " Balance: " + bank.balance + " Thread: " + Thread.currentThread().getName());
        }
        try {
            Thread.sleep(1000);
        }
        catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
