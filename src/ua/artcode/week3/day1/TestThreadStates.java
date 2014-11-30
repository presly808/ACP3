package ua.artcode.week3.day1;


public class TestThreadStates {


    public static void main(String[] args) throws InterruptedException {
        System.out.println();
        MyOutputThread t = new MyOutputThread();
        t.setDaemon(true);



        System.out.println(t.getName() + " " + t.getState());
        t.start();

        Thread.sleep(100);
        for (int i = 0; i < 10; i++) {
            System.out.println(Thread.currentThread().getName() + " => " + i);
            Thread.sleep(1000);
        }

        System.out.println(t.getName() + " " + t.getState());



    }


}
