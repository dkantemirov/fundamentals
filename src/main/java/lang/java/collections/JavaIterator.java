package lang.java.collections;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

/**
 * The Iterator is the fundamental (and a little cumbersome) way of iterating
 * over elements of a collection. It has existed since the beginning.
 * All other ways, such as the for-each loop, the forEach() method, and the
 * forEachRemaining() method, are syntactic sugar for the Iterator .
 * Internally, they all use an Iterator .
 */
public class JavaIterator {
    private static void iterator() {
        List<Integer> list = new ArrayList<>(Arrays.asList(1, 2, 3, 4, 5));
        Iterator<Integer> iterator = list.iterator();
        while (iterator.hasNext()) System.out.println(iterator.next());
    }
    // Java 8
    private static void forEachRemaining() {
        List<String> names = new ArrayList<>(Arrays.asList("a1", "a2"));
        Iterator<String> nameIterator = names.iterator();
        nameIterator.forEachRemaining(System.out::println);
    }
    private static void forEachLoop() {
        List<String> names = new ArrayList<>(Arrays.asList("b1", "b2", "b3"));
        for (String name : names) System.out.println(name);
    }
    // Java 8
    private static void forEach() {
        List<String> names = new ArrayList<>(Arrays.asList("c1", "c2", "c3"));
        names.forEach(System.out::println);
    }
    public static void main(String[] args) {
       iterator();
       forEachRemaining();
       forEachLoop();
       forEach();
    }
}
