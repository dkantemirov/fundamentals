package lang.java.collections;

import java.util.NavigableSet;
import java.util.TreeSet;

/**
 * A navigable set is a specialized type sorted set that lets you work with its subsets
 * in a variety of ways. An instance of the NavigableSet represents a navigable set.
 * The NavigableSet interface inherits from the SortedSet interface and defines some
 * additional methods to extend the functionality provided by the SortedSet.
 * It extends SortedSet in four ways:
 * <ul>
 *     <li>It lets you navigate the set in reverse order. The reverse order is the opposite order in
 *     which your SortedSet would be sorted normally. Its descendingSet() method returns a
 *     NavigableSet object, which is another view of the same NavigableSet in the reverse order.
 *     If you modify the original NavigableSet or the one returned from the descendingSet()
 *     method, the modifications will be reflected in both sets.</li>
 *     <li>It adds another version of the three methods headSet(), tailSet(), and subSet() in
 *     SortedSet, which accept a boolean flag to include the element at the beginning or the end of
 *     the subset boundary.</li>
 * </ul>
 */
public class JavaNavigableSet {
  public static void main(String[] args) {
    // Create a navigable set and add some integers
    NavigableSet<Integer> ns = new TreeSet<>();
    ns.add(1);
    ns.add(2);
    ns.add(3);
    ns.add(4);
    ns.add(5);

    // Get a reverse view of the navigable set
    NavigableSet reverseNs = ns.descendingSet();

    // Print the normal and reverse views
    System.out.println("Normal View of the Set: " + ns);
    System.out.println("Reverse view of the set: " + reverseNs);

    // Get and print a subset of the navigable set
    System.out.println("\nGetting subset of the set");

    NavigableSet threeOrMore = ns.tailSet(3, true);
    System.out.println("3 or more: " + threeOrMore);

    // Search the navigable set
    System.out.println();
    System.out.println("Searching through the set");

    System.out.println("lower(3): " + ns.lower(3));
    System.out.println("floor(3): " + ns.floor(3));
    System.out.println("higher(3): " + ns.higher(3));
    System.out.println("ceiling(3): " + ns.ceiling(3));

    // Poll the navigable set
    System.out.println();
    System.out.println("Polling elements from the set");

    // Poll elements one by one and look at the set
    System.out.println("pollFirst(): " + ns.pollFirst());
    System.out.println("Navigable Set: " + ns);

    System.out.println("pollLast(): " + ns.pollLast());
    System.out.println("Navigable Set: " + ns);

    System.out.println("pollFirst(): " + ns.pollFirst());
    System.out.println("Navigable Set: " + ns);

    System.out.println("pollFirst(): " + ns.pollFirst());
    System.out.println("Navigable Set: " + ns);

    System.out.println("pollFirst(): " + ns.pollFirst());
    System.out.println("Navigable Set: " + ns);

    // Since the set is empty, polling will return null
    System.out.println("pollFirst(): " + ns.pollFirst());
    System.out.println("pollLast(): " + ns.pollLast());
  }
}
