package ua.artcode.week1;

public class TestPassParams {


    public static void main(String[] args) {
        String s = "word";
        s = concat(s,2);
        System.out.println(s);
    }

    public static String concat(String src, int times) {
        src = src + "new"; //Immutable
        return null;
    }

}
