package home;

import java.io.*;
import java.util.Scanner;

public class ExecUtils {


    public static void runCommand(String command, String path){

        try {
            Process process = Runtime.getRuntime().exec(command);
            System.out.println(format(process.getErrorStream()));
            System.out.println(format(process.getInputStream()));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static String format(InputStream is){
        StringBuilder sb = new StringBuilder();
        BufferedReader br = new BufferedReader(new InputStreamReader(is));
        try {
            String line = null;
            while((line = br.readLine()) != null){
                sb.append(line).append("\n");
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        return sb.toString();


    }

    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);

        String choose = null;

        choose = sc.nextLine();
        String com = choose.trim();

        Process process = Runtime.getRuntime().exec(com);
        format(process.getErrorStream());
        format(process.getInputStream());

        /*while(!"exit".equals(choose)){
            choose = sc.nextLine() + "\n";
            String command = choose.trim();
            runCommand(choose, "C:\\");
        }*/

    }

}
