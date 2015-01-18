package ua.artcode.week3.day2.logging;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Scanner;
import java.util.logging.*;

public class Test {

    private static final Logger logger = Logger.getLogger("ua.artcode");

    public static void main(String[] args)  {

        ConsoleHandler consoleHandler = new ConsoleHandler();
        FileHandler fileHandler = null;
        try {
            fileHandler = new FileHandler("java%g.log");
        } catch (IOException e) {
            logger.log(Level.SEVERE, e.getMessage(), e);
        }
        fileHandler.setFormatter(new Formatter() {
            @Override
            public String format(LogRecord record) {
                return String.format("date = %tc", record.getMillis()) + "/" +
                        record.getLevel().getName() +" " + record.getMessage();
            }
        });
        logger.addHandler(fileHandler);
        logger.addHandler(consoleHandler);

        try {
            Scanner sc = new Scanner(new File("temp/file"));
        } catch (FileNotFoundException e) {
            logger.log(Level.SEVERE, e.getMessage(), e);
        }



    }


}
