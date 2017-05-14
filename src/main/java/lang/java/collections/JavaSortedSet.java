package lang.java.collections;

import lang.java.utils.Person;

import java.util.Comparator;
import java.util.SortedSet;
import java.util.TreeSet;

/**
 * A sorted set is a set that imposes ordering on its elements. An instance of the SortedSet
 * interface represents a sorted set. The elements in a SortedSet can be sorted in a natural order
 * or using a Comparator. A SortedSet must know how to sort its elements as they are added.
 * The sorted set relies on two things to sort its elements:
 * <ul>
 * <li>If its elements implement the Comparable interface, it will use the compareTo() method of
 * elements to sort them. This is called sorting in natural order.</li>
 * <li>You can supply a Comparator object to use a custom sorting. The implementation class for
 * SortedSet is recommended to provide a constructor that will accept a Comparator object
 * to use a custom sorting. If a Comparator is specified, the Comparator is used for sorting
 * irrespective of the elements implementing the Comparable interface.</li>
 * </ul>
 */
public class JavaSortedSet {
    private static void treeSet() {
        // Create a sorted set of some names
        SortedSet<String> sortedNames = new TreeSet<>();
        sortedNames.add("John");
        sortedNames.add("Adam");
        sortedNames.add("Eve");
        sortedNames.add("Donna");

        // Print the sorted set of names
        System.out.println(sortedNames);
    }

    private static void treeSetWithCustomComparator() {
        // Create a sorted set sorted by id
        SortedSet<Person> personsById =
                new TreeSet<>(Comparator.comparing(Person::getId));

        // Add soem persons to the set
        personsById.add(new Person(1, "John"));
        personsById.add(new Person(2, "Adam"));
        personsById.add(new Person(3, "Eve"));
        personsById.add(new Person(4, "Donna"));
        personsById.add(new Person(4, "Donna")); // A duplicate Person

        // Print the set
        System.out.println("Persons by Id:");
        personsById.forEach(System.out::println);

        // Create a sorted set sorted by name
        SortedSet<Person> personsByName =
                new TreeSet<>(Comparator.comparing(Person::getName));
        personsByName.add(new Person(1, "John"));
        personsByName.add(new Person(2, "Adam"));
        personsByName.add(new Person(3, "Eve"));
        personsByName.add(new Person(4, "Donna"));
        personsByName.add(new Person(4, "Kip")); // Not a duplicate person

        System.out.println("Persons by Name: ");
        personsByName.forEach(System.out::println);
    }

    public static void main(String[] args) {
        treeSet();
        treeSetWithCustomComparator();
    }

}

/**
 * Accessing Subsets of a SortedSet
 */
class SortedSetSubset {
    public static void main(String[] args) {
        // Create a sorted set of names
        SortedSet<String> names = new TreeSet<>();
        names.add("John");
        names.add("Adam");
        names.add("Eve");
        names.add("Donna");
        // Print the sorted set
        System.out.println("Sorted Set: " + names);

        // Print the first and last elements in the sorted set
        System.out.println("First: " + names.first());
        System.out.println("Last: " + names.last());

        SortedSet ssBeforeDonna = names.headSet("Donna");
        System.out.println("Head Set Before Donna: " + ssBeforeDonna);

        SortedSet ssBetwenDonnaAndJohn = names.subSet("Donna", "John");
        System.out.println("Subset between Donna and John (exclusive): " +
                ssBetwenDonnaAndJohn);

        // Note the trick "John" + "\0" to include "John" in the subset
        SortedSet ssBetwenDonnaAndJohn2 = names.subSet("Donna", "John" + "\0");
        System.out.println("Subset between Donna and John (Inclusive): " +
                ssBetwenDonnaAndJohn2);

        SortedSet ssDonnaAndAfter = names.tailSet("Donna");
        System.out.println("Subset from Donna onwards: " + ssDonnaAndAfter);
    }
}