package ua.artcode.week3.day1.bank;

public class BankAccount {


    public static final int LIMIT = 1000;
    private int cash;

    public BankAccount(int cash) {
        this.cash = cash;
    }

    // monitor will be this
    public synchronized void withdraw(int money){

        while(cash < LIMIT){
            try {
                this.wait(200);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

        cash = cash - money;
    }

    public void put(int money){
        synchronized (this){

            cash = cash + money;

            if(cash >= LIMIT){
                this.notifyAll();
            }
        }
    }

    public static synchronized void go(){

    }

    @Override
    public String toString() {
        return "BankAccount{" +
                "cash=" + cash +
                '}';
    }
}
