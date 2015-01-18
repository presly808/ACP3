package ua.artcode.week2.day2.reflect;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;

/**
 * Created by admin on 23.11.2014.
 */
public class TestReflection {


    public static void main(String[] args) throws IllegalAccessException, InstantiationException,
            NoSuchMethodException, InvocationTargetException, ClassNotFoundException {
        Cat cat = new Cat(5, "Murchik", 8);
        Class cl = cat.getClass();

        Class clScaner = Class.forName("java.util.Scanner");


        Field[] fields = cl.getFields();
        for(Field f : fields){
            System.out.println(f.getType().getName() + " " + f.getName() + " " + f.get(cat));
        }

        Field[] allFields = cl.getDeclaredFields();
        for(Field f : allFields){
            f.setAccessible(true);
            System.out.println(f.getType().getName() + " " + f.getName() + " " + f.get(cat));
        }

        Class clInt = int.class;
        Class clIntMas = int[].class;

        Cat cat1 = (Cat) cl.newInstance();
        Constructor<Cat> constructor =
                cl.getDeclaredConstructor(int.class, String.class, double.class);
        Cat cat2 = constructor.newInstance(3, "Vasia", 4.5);


        Method myuMeth = cl.getMethod("myu");
        myuMeth.invoke(cat2);


        System.out.println("********************************************************");
        String path = "temp/cat.txt";
        //save(cat, path);
        Cat loaded = load(path);
        System.out.println(loaded);
        System.out.println("********************************************************");



    }


    public static <T> void save(T o, String path){
        Class<T> cl = (Class<T>) o.getClass();

        try (PrintWriter pw = new PrintWriter(path)){
           pw.println("class=" + cl.getName());
           for(Field f : cl.getDeclaredFields()){
               f.setAccessible(true);
               if(f.isAnnotationPresent(ForSave.class)){
                   pw.println(f.getName() + "=" + f.get(o));
               }
           }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        }
    }

    public static <T> T load(String path){
        try {
            Scanner sc = new Scanner(new File(path));
            Map<String,String> map = new LinkedHashMap<>();

            String className = sc.nextLine().split("=")[1];
            Class<T> tClass = (Class<T>) Class.forName(className);
            T instance = tClass.newInstance();

            while (sc.hasNextLine()){
                String line = sc.nextLine(); // name=cat
                String[] splited = line.split("=");
                map.put(splited[0], splited[1]);
            }

            for(String key : map.keySet()){
                Field field = tClass.getDeclaredField(key);
                field.setAccessible(true);
                field.set(instance, parse(field.getType(), map.get(key)));
            }

            return instance;
        } catch (FileNotFoundException | ClassNotFoundException |
                NoSuchFieldException | InstantiationException |
                IllegalAccessException e) {
            e.printStackTrace();
        }
        return null;
    }

    public static Object parse(Class type, String value){
        if(type == int.class){
            return Integer.valueOf(value);
        } else if(type == double.class){
            return Double.parseDouble(value);
        } else {
            return value;
        }
    }




}


class Cat {

    public int age;
    @ForSave(position = 1, desc = "name")
    public String name;
    public double weight;

    private String home = "Kiev";

    Cat() {
    }

    Cat(int age, String name, double weight) {
        this.age = age;
        this.name = name;
        this.weight = weight;
    }

    public void myu(){
        System.out.println("cat MYAU");
    }

    @Override
    public String toString() {
        return "Cat{" +
                "age=" + age +
                ", name='" + name + '\'' +
                ", weight=" + weight +
                ", home='" + home + '\'' +
                '}';
    }
}
