package mountin.tmp;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;

/**
 * Created by mountin on 11/12/2014.
 */
public class generics{
    public static void main(String[] args) {
        Gen<Integer> iOb;

        Object a = new Object();
        iOb = new Gen<Integer>(77);
        iOb.getType();

        System.out.println("значение  пременной " + iOb.getOb());

        Gen<String>asdT = new Gen<String>("Эпросто какаято строка");
        asdT.getType();
        System.out.println("значение  пременной " + asdT.getOb());

        //iOb = new Gen<Integer>(new Integer(88));
        //iob.getType();



        GetPro<Object>getpro2 = new GetPro<Object>("kio123");
        getpro2.add("просто 3456");
        getpro2.add("просто 678");
        getpro2.add("просто 908");
        getpro2.add("просто 111");
        getpro2.add("просто 999");

        //getpro2.getGetPro();
        getpro2.useWhileLoop(getpro2.ggg);


    }
}

class Gen <ASDF1> {

    ASDF1 ob;
    public Gen(ASDF1 getOb) {
        this.ob = getOb;
    }

    public ASDF1 getOb() {
        return this.ob;
    }

    public void getType() {
        System.out.println("тип пременной " + ob.getClass().getName());
    }
}
class GetPro <E>{
    List<E> ggg = new ArrayList<E>();

    public  GetPro (E asd) {
        this.ggg.add(asd);
    }

    public void add (E asd2) {
        this.ggg.add(asd2);
    }

    public int getGetPro(){

        Iterator<E> iterator = this.ggg.iterator();
        while(iterator.hasNext()){
            System.out.println("значение  =" + iterator.next());
        }

        //return this.ggg;
        return 0;
    }


    protected void useWhileLoop(Collection<E> aFlavours) {
        Iterator<E> flavoursIter = aFlavours.iterator();
        while (flavoursIter.hasNext()){
            System.out.println(flavoursIter.next());
        }
    }

}

