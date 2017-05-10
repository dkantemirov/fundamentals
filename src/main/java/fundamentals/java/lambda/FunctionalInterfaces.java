package fundamentals.java.lambda;

/**
 * A functional interface is simply an interface that has exactly one abstract method.
 * Note that an interface may have more than one abstract method, and can still be a
 * functional interface if all but one of them is a redeclaration of the methods in
 * the Object class.
 */
public class FunctionalInterfaces {

    // Example
    @FunctionalInterface
    public interface Comparator<T> {
        // An abstract method declared in the interface
        int compare(T o1, T o2);

        // Re-declaration of the equals() method in the Object class
        boolean equals(Object obj);

        /* Many static and default methods that are not shown here. */
    }

    @FunctionalInterface
    public interface Mapper<T> {
        // An abstract method
        int map(T source);

        // A generic static method
        public static <U> int[] mapToInt(U[] list, Mapper<? super U> mapper) {
            int[] mappedValues = new int[list.length];

            for (int i = 0; i < list.length; i++) {
                // Map the object to an int
                mappedValues[i] = mapper.map(list[i]);
            }

            return mappedValues;
        }
    }

    public static void main(String[] args) {
        // Map names using their length
        System.out.println("Mapping names to their lengths:");
        String[] names = {"David", "Li", "Doug"};
        int[] lengthMapping = Mapper.mapToInt(names, (String name) -> name.length());
        printMapping(names, lengthMapping);

        System.out.println("\nMapping integers to their squares:");
        Integer[] numbers = {7, 3, 67};
        int[] countMapping = Mapper.mapToInt(numbers, (Integer n) -> n * n);
        printMapping(numbers, countMapping);
    }

    private static void printMapping(Object[] from, int[] to) {
        for(int i = 0; i < from.length; i++) {
            System.out.println(from[i] + " mapped to " + to[i]);
        }
    }
}

