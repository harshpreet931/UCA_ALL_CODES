package BankExercise;

public class Depositor extends Thread{
    Bank bank;

    public Depositor(Bank bank)
    {
        this.bank = bank;
    }

    public void run()
    {
        while(true)
        {
            synchronized (bank)
            {
                int deposit = (int) (Math.random() * 50);
                bank.balance += deposit;
                System.out.println("Deposited: " + deposit + " Balance: " + bank.balance + " Thread:" + Thread.currentThread().getName());
                bank.notifyAll();
            }

            try
            {
                Thread.sleep(1000);
            }
            catch (InterruptedException e)
            {
                e.printStackTrace();
            }

            if(bank.activeUsers == 0)
            {
                break;
            }
        }
    }
}
