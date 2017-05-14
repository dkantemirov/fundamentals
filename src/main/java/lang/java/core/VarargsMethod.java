package lang.java.core;

public class VarargsMethod {
  static void varargs(int... i) {
    for (int v : i)
      System.out.println(v);
  }

  public static void main(String... arg) {
    varargs(1, 2, 3, 4, 5);
  }
}
