package BankExercise;

public class Withdrawer extends Thread {

    Bank bank;
    Withdrawer(Bank bank)
    {
        this.bank = bank;
    }

    public void run()
    {
        synchronized (bank)
        {
            int withdraw = (int) (Math.random() * 100);
            if(bank.balance < withdraw)
            {
                System.out.println("Not enough balance to withdraw: " + withdraw);
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            }
            else
            {
                bank.balance -= withdraw;
                System.out.println("Withdrawn: " + withdraw + " Balance: " + bank.balance);
            }
        }
    }
}
