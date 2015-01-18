package ua.artcode.week1;

/**
 * Created by admin on 15.11.2014.
 */
public class Container<T> {

    private T val;

    public Container(T val) {
        this.val = val;
    }

    public T getVal() {
        return val;
    }

    public void setVal(T val) {
        this.val = val;
    }


}
