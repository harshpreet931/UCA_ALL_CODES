package BankExercise;

public class Main {
    // Bank class - 1 Persons -> AccountNo, Balance
    // 10 Depositer threads - x money
    // 10 Withdrawer threads - RandomMoney withdrawing (0 - 100) if balance is not enough kill the thread, otherwise wait

    public static void main(String[] args) {
        int n = 10;
        Bank bank = new Bank();
        Depositor[] depositors = new Depositor[n];
        Withdrawer[] withdrawers = new Withdrawer[n];

        for (int i = 0; i < n; i++) {
            depositors[i] = new Depositor(bank);
            withdrawers[i] = new Withdrawer(bank);

            depositors[i].start();
            withdrawers[i].start();
        }
    }
}
