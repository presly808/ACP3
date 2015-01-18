package ua.artcode.week3.day1;

/**
 * Created by admin on 29.11.2014.
 */
public class TestThread {

    public static void main(String[] args) {

        Thread t = new Thread(new MyOutputRunnable());
        t.start();

        MyOutputThread myOutputThread = new MyOutputThread();
        myOutputThread.start();

        for (int i = 0; i < 100; i++) {
            System.out.println("main thread => " + i);
        }





    }


}
