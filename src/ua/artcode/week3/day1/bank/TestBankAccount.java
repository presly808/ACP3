package ua.artcode.week3.day1.bank;

/**
 * Created by admin on 29.11.2014.
 */
public class TestBankAccount {

    public static void main(String[] args) throws InterruptedException {
        BankAccount bankAccount = new BankAccount(1000);

        Thread producer = new Thread(new ProducerThread(bankAccount));
        producer.start();

        Thread producer1 = new Thread(new ProducerThread(bankAccount));
        producer1.start();

        Thread consumer = new Thread(new ConsumerThread(bankAccount));
        consumer.start();

        Thread consumer1 = new Thread(new ConsumerThread(bankAccount));
        consumer1.start();

        producer.join();
        producer1.join();
        consumer.join();
        consumer1.join();

        System.out.println(bankAccount);


    }
}
