package ua.artcode.week3.day1;

/**
 * Created by admin on 29.11.2014.
 */
public class TestInterrupt {


    public static void main(String[] args) throws InterruptedException {

        Thread t1 = new Thread(new Runnable() {
            @Override
            public void run() {
                while(!Thread.currentThread().isInterrupted()){
                    System.out.println(Thread.currentThread());

                }
            }
        });
        t1.start();


        Thread.sleep(2000);

        t1.interrupt();



    }

}
