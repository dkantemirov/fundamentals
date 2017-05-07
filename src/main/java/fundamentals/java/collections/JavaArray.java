package fundamentals.java.collections;

public class JavaArray {
    public static void main(String[] args) {
        int[] arr = new int[5];
        for (int anArr : arr) System.out.println(anArr);
    }
}

class ExplicitArrayInitialization {
    public static void main(String[] args) {
        // Initialize the array at the time of declaration
        int[] arr = {1, 2, 3, 4, 5};

        int[] arr1 = {1, 2, 3, 4, 5, }; // A comma after the last value 5 is valid.

        int[] arr2 = new int[]{1, 2, 3, 4, 5};

        int[] empty = { };

        for (int i : arr) System.out.println(arr[i]);
    }
}
