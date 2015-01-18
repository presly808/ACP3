package ua.artcode.week3.day1;


public class MyOutputThread extends Thread {

    @Override
    public void run() {
        for (int i = 0; i < 10; i++) {
            System.out.println(this + " => " + i);
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    public String toString(){
        return "id = " + getId() + " name = " + getName();
    }

}
