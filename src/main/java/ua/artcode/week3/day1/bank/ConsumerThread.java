package ua.artcode.week3.day1.bank;

/**
 * Created by admin on 29.11.2014.
 */
public class ConsumerThread implements Runnable {

    private BankAccount bankAccount;

    public ConsumerThread(BankAccount bankAccount) {
        this.bankAccount = bankAccount;
    }

    @Override
    public void run() {
        for(int i = 0; i < 100000; i++){
            bankAccount.withdraw(1);
            System.out.println(Thread.currentThread() + " withdraw " + bankAccount);
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
