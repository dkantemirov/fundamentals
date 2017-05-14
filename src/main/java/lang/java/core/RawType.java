package lang.java.core;

import lang.java.utils.Wrapper;

/**
 * Implementation of generic types in Java is backward compatible.
 * If an existing non-generic class is rewritten to take advantage of generics,
 * the existing code that uses the non-generic version of the class should keep working.
 */
public class RawType {
  public static void main(String[] args) {
    // An unchecked warning
    // Wrapper rawType = new Wrapper("Hello");

    Wrapper<String> genericType = new Wrapper<>("Hello");

    // An unchecked warning
    // genericType = rawType;

    System.out.println(genericType.getClass());
  }
}
