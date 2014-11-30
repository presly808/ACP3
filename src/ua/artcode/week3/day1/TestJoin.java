package ua.artcode.week3.day1;

public class TestJoin {

    public static void main(String[] args) throws InterruptedException {

        Thread worker = new Thread(new Runnable() {
            @Override
            public void run() {
                for (int i = 0; i < 10; i++) {
                    System.out.println(i);
                    try {
                        Thread.sleep(1000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        });
        worker.yield();

        worker.start();

       // worker.join();
        System.out.println("main action");

    }


}
