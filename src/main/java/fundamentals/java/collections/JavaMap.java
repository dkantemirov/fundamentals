package fundamentals.java.collections;

import java.util.HashMap;
import java.util.Map;
import java.util.WeakHashMap;

/**
 *  Scala Map {@link fundamentals.scala.collections.ScalaMap}
 */
public class JavaMap {
    static void hashMap() {
        Map<String, String> map = new HashMap<>();
        map.put("John", "(342)113-9878");
        map.put("Richard", "(245)890-9045");
        map.put("Donna", "(205)678-9823");
        map.put("Ken", "(205)678-9823");

        // Get the value for the "Donna" key
        String donnaPhone = map.get("Donna");

        // Print details
        System.out.println("Map: " + map);
        System.out.println("Map size: " + map.size());
        System.out.println("Map is empty: " + map.isEmpty());
        System.out.println("Map contains Donna key: " + map.containsKey("Donna"));
        System.out.println("Donna phone: " + donnaPhone);
        System.out.println("Donna key is removed: " + map.remove("Donna"));

        // Java 8. Use the forEach() method of the Map interface
        map.forEach((k, v) -> System.out.println("key=" + k + ", value=" + v));
    }

    /**
     * The WeakHashMap class is another implementation for the Map interface.
     * As the name of the class implies, it contains weak keys. When there is
     * no reference to the key except in the map, keys are candidates for garbage
     * collection. If a key is garbage collected, its associated entry is removed
     * from the Map. You use a WeakHashMap as implementation class for a Map when
     * you want to maintain a cache of key-value pairs and you do not mind if your
     * key-value pairs are removed from the Map by the garbage collector.
     */
    static void weakHashMap() {
        Map<String, String> map = new WeakHashMap<>();
        map.put("John", "(342)113-9878");
        map.put("Eric", "(245)890-9045");
        map.put("Duke", "(205)678-9823");
        map.put("Ken", "(205)678-9823");

        // Get optional value
        String katePhone = map.getOrDefault("Kate", "(205)677-7711");
        System.out.println("Kate phone: " + katePhone);

        map.put("Kate", katePhone);

        // Java 8.
        map.replaceAll((k, v) -> {
            if (k.charAt(0) == 'K') return "hidden";
            else return v;
        });

        map.forEach((k, v) -> System.out.println("key=" + k + ", value=" + v));
    }

    /**
     * The LinkedHashMap is another implementation class for the Map interface.
     * It stores entries in the Map using a doubly linked list. It defines the
     * iteration ordering as the insertion order of the entries. If you want to
     * iterate over entries in a Map in its insertion order, you need to use
     * LinkedHashMap instead of HashMap as the implementation class.
     */
    static void linkedHashMap() {

    }

    public static void main(String[] args) {
        hashMap();
        weakHashMap();
    }
}
