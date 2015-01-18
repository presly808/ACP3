package data_structures;

import java.util.Comparator;
import java.util.Set;
import java.util.TreeSet;

/**
 * Created by admin on 16.11.2014.
 */
public class TestTreeSet {
    public static void main(String[] args) {
        Set<Cat> treeSet = new TreeSet<Cat>(new Comparator<Cat>() {
            @Override
            public int compare(Cat o1, Cat o2) {
                return o1.age - o2.age;
            }
        });
        treeSet.add(new Cat(2, "Jack", 2));
        treeSet.add(new Cat(6, "C", 2));
        treeSet.add(new Cat(1, "B", 2));
        treeSet.add(new Cat(5, "A", 2));

        for(Cat cat : treeSet){//for-each
            System.out.println(cat);
        }
    }

}
