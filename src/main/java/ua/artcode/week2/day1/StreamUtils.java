package ua.artcode.week2.day1;

import java.io.*;

public class StreamUtils {

    public static void main(String[] args) throws FileNotFoundException {
        readInputStream();
    }

    public static void readInputStream() throws FileNotFoundException {
        FileInputStream fis = new FileInputStream("temp/file.txt");

        try {
            int read = -1;
            while ((read = fis.read()) != -1){
                System.out.print((char)read);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void writeInputStream(String word, String path) {
        FileOutputStream fos = null;

        byte[] mas = word.getBytes();

        try {
            fos = new FileOutputStream(path);
            fos.write(mas);
            fos.flush();
            fos.close();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if(fos != null){
                try {
                    fos.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    public static void writeWriter(String word, String path){
        try (FileWriter fw = new FileWriter(path)) {
            fw.write(word);
            fw.flush();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    public static void testAdapter(InputStream is){
        InputStreamReader adapter = new InputStreamReader(is);
        BufferedReader reader = new BufferedReader(adapter);
    }

    public static void serialize(Object obj, String path){
        try(FileOutputStream fos = new FileOutputStream(path);
            ObjectOutputStream oos = new ObjectOutputStream(fos)){
            oos.writeObject(obj);
        } catch (IOException e) {
            e.printStackTrace();
        }

    }


}
