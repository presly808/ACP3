package data_structures;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Objects;
import java.util.Set;

/**
 * Created by admin on 16.11.2014.
 */
public class TestHashSet {

    public static void main(String[] args) {
        Set<Cat> set = new HashSet<Cat>();
        set.add(new Cat(10, "Mursik", 4));
        set.add(new Cat(4, "Barsic", 2));
        set.add(new Cat(4, "Barsic", 2));
        set.add(new Cat(2, "Masd", 1));
        set.add(new Cat(9, "Kil", 8));

        Iterator<Cat> catIterator = set.iterator();
        while(catIterator.hasNext()){
            System.out.println(catIterator.next());
        }


    }
}

class Cat implements Comparable<Cat> {

    int age;
    String name;
    double weight;

    Cat(int age, String name, double weight) {
        this.age = age;
        this.name = name;
        this.weight = weight;
    }


    //Contract if(a1.equals(a2) == (a1.hashCode() == a2.hashCode()))
    @Override
    public boolean equals(Object o){
        if(this == o){
            return true;
        }

        if(o.getClass() != Cat.class){
            return false;
        }

        Cat other  = (Cat) o;

        return age == other.age && (name != null && name.equals(other.name)) && weight == other.weight;
    }

    //Java effective
    @Override
    public int hashCode(){
        int hash = 31;
        hash = 31 * hash + (name != null ? name.hashCode() : 0);
        hash = 31 * hash + age;
        hash = 31 * hash + (int)(Double.doubleToLongBits(weight) << 32);
        return hash;

    }

    @Override
    public String toString() {
        return "Cat{" +
                "age=" + age +
                ", name='" + name + '\'' +
                ", weight=" + weight +
                '}';
    }

    @Override
    public int compareTo(Cat o) {
        return this.name.compareTo(o.name);
    }
}
