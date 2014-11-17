package ua.artcode.week1;

import java.util.ArrayList;
import java.util.Objects;

/**
 * Created by admin on 15.11.2014.
 */
public class TestWrappers {


    public static void main(String[] args) {
        // int, byte, short
        // prim -> Ref   Ref -> Prim
        // AutoBoxing, Unboxing
        // int - Integer
        //
        Object o = 78;// Object o = new Integer(78);


    }

    public static boolean eq(Object o1, Object o2){
        return o1 != null ? o1.equals(o2) : false;
    }


}

class Employee {
    int age;
    String name;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Employee employee = (Employee) o;

        if (age != employee.age) return false;
        if (name != null ? !name.equals(employee.name) : employee.name != null) return false;

        return true;
    }

}



