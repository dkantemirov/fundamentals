package lang.java.collections;

class JavaArray {
  private static void implicitInitialization() {
    int[] arr = new int[5];
    arr[0] = 1;
    for (int anArr : arr)
      System.out.println(anArr);
  }

  private static void explicitInitialization() {
    // Initialize the array at the time of declaration
    int[] arr = {1, 2, 3, 4, 5};

    int[] arr1 = {1, 2, 3, 4, 5,}; // A comma after the last value 5 is valid.

    int[] arr2 = new int[] {1, 2, 3, 4, 5};

    int[] empty = {};

    for (int i : arr)
      System.out.println(i);
  }

  public static void main(String[] args) {
    implicitInitialization();
    explicitInitialization();
  }
}
