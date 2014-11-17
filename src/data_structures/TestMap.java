package data_structures;

import java.util.Collection;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;

/**
 * Created by admin on 16.11.2014.
 */
public class TestMap {

    public static void main(String[] args) {
        Map<String,Integer> map = new TreeMap<String,Integer>();
        map.put("some", 45);
        map.put("some", 12);
        map.get("some");

        Set<String> kSet = map.keySet();
        Collection<Integer> values = map.values();

    }

}
