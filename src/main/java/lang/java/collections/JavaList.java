package lang.java.collections;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

/**
 * A list is an ordered collection of objects. Sometimes a list is also
 * known as a sequence. An instance of the List interface represents a list
 * in the Collections Framework. A list can have duplicate elements. You can
 * also store multiple null values in a list.
 * The following are two of many implementation classes for the List interface:
 * <ul>
 * <li>{@link java.util.ArrayList}</li>
 * <li>{@link java.util.LinkedList}</li>
 * </ul>
 * An ArrayList is backed up by an array. A LinkedList is backed up by a linked
 * list. An ArrayList performs better if you access (get and set) the elements
 * of the list frequently. Accessing elements in an ArrayList is faster because
 * the index of an element becomes the index in the backing array, and accessing
 * an element from an array is always fast. Adding or removing elements from a
 * list backed by an ArrayList performs slower, unless done from the end, because
 * an ArrayList has to perform an array copy internally to keep the elements in
 * sequence. The LinkedList performs better as compared to ArrayList for adding
 * and removing elements from the middle of the list. However, it is slower for
 * accessing elements of the list, unless at the head of the list.
 * <p>
 * Note that a List does not allow inserting an element at any arbitrary index by
 * using the add(int index, E element) method. If the List is empty, you can use
 * only 0 as the index to add the first element to the list. If you have five
 * elements in a List , you must use indexes between 0 and 5 to add a new element
 * to the List . The index from 0 to 4 will insert an element between existing
 * elements. The index of 5 will append the element to the end of the List . This
 * implies that a <b>List must grow sequentially</b>. You cannot have a sparse
 * List such as a List with first element and tenth element, leaving second to
 * ninth elements non-populated. This is the reason that a List is also known as
 * a sequence.
 */
public class JavaList {
  private static void arrayList() {
    // Create a List and add few elements
    List<String> list = new ArrayList<>();
    list.add("John");
    list.add("Richard");
    list.add("Donna");
    list.add("Ken");

    System.out.println("List: " + list);

    int count = list.size();
    System.out.println("Size of List: " + count);

    // Print each element with its index
    for (int i = 0; i < count; i++) {
      String element = list.get(i);
      System.out.println("Index=" + i + ", Element=" + element);
    }

    List<String> subList = list.subList(1, 3);

    System.out.println("Sub List 1 to 3(excluded): " + subList);
    // Remove "Donna" from the list
    list.remove("Donna"); // Same as list.remove(2);
    System.out.println("List (after removing Donna): " + list);
  }

  private static void linkedList() {
        List<String> list = new LinkedList<>();
        list.add("Eric");
        list.add("David");
        list.add("Piter");
        list.add("Mark");

        // Remove by predicate
        list.removeIf(x -> x.equals("Mark"));

        // Add collection to list
        list.addAll(new ArrayList<>(Arrays.asList("Fred", "Bart")));

        // Remove all collection elements from list
        list.removeAll(new ArrayList<>(Arrays.asList("Mark", "Kate")));

        // Sort list
        list.sort(String::compareTo);

        System.out.println("Size of List: " + list.size());
        System.out.println("List: " + list);
    }

  public static void main(String[] args) {
    arrayList();
    linkedList();
  }
}
