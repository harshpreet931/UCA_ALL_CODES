package BankExercise;

public class Main {
    // Bank class - 1 Persons -> AccountNo, Balance
    // 10 Depositer threads - x money
    // 10 Withdrawer threads - RandomMoney withdrawing (0 - 100) if balance is not enough kill the thread, otherwise wait

    public static void main(String[] args) {
        Bank bank = new Bank();

        for (int i = 0; i < 10; i++) {
            new Depositor(bank).start();
            new Withdrawer(bank).start();
        }
    }
}
