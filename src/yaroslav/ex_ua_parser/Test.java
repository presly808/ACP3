package yaroslav.ex_ua_parser;

import java.io.IOException;

/**
 * Created by Администратор on 09.12.2014.
 */
public class Test {
    public static void main(String[] args) throws IOException {
        MyParserJSOUP myParserJSOUP = new MyParserJSOUP();
        myParserJSOUP.parse("http://www.ex.ua/82222505?r=28727,23777");

    }
}
