package fundamentals.java.collections;

import java.util.Comparator;
import java.util.SortedMap;
import java.util.TreeMap;

public class JavaSortedMap {
    public static void main(String[] args) {
        // Sort entries on key's length and then on keys ignoring case
        Comparator<String> keyComparator =
                Comparator.comparing(String::length)
                        .thenComparing(String::compareToIgnoreCase);

        SortedMap<String, String> sMap = new TreeMap<>(keyComparator);
        sMap.put("John", "(342)113-9878");
        sMap.put("Richard", "(245)890-9045");
        sMap.put("Donna", "(205)678-9823");
        sMap.put("Ken", "(205)678-9823");
        sMap.put("Zee", "(205)679-9823");

        System.out.println("Sorted Map: " + sMap);

        // Get the first and last keys
        String firstKey = sMap.firstKey();
        String lastKey = sMap.lastKey();
        System.out.println("First Key: " + firstKey);
        System.out.println("Last key: " + lastKey);
    }
}
