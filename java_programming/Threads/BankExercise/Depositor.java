package BankExercise;

public class Depositor extends Thread{
    Bank bank;

    public Depositor(Bank bank)
    {
        this.bank = bank;
    }

    public void run()
    {
        synchronized (bank)
        {
            int deposit = (int) (Math.random() * 100);
            bank.balance += deposit;
            System.out.println("Deposited: " + deposit + " Balance: " + bank.balance);
        }
    }
}
