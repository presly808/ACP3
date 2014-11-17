package ua.artcode.week1;

/**
 * Created by admin on 15.11.2014.
 */
public class TestGen {

    public static void main(String[] args) {
        Container<String> c1 = new Container<String>("String");
        c1.setVal("some");
        String s = c1.getVal();


        Container c2 = new Container(23);

        if(c1.getVal() instanceof String){
            String o1 = (String) c1.getVal();//cast
        }

        String s2 = (String) c2.getVal();// Class
        System.out.println(s2);
    }
}
