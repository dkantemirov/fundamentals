package lang.java.core;

import java.util.ArrayList;
import java.util.List;

/**
 * Ad hoc polymorphism:
 * 1. Overloading Polymorphism.
 * 2. Coercion Polymorphism.
 */
class OverloadingPolymorphism {
  static int get(int v) {
    return v;
  }

  static String get(String v) {
    return v;
  }

  public static void main(String[] args) {
    System.out.println(String.format("get1=%s;get2=%s;", get(5), get("5")));
  }
}


class CoercionPolymorphism {
  public static void main(String[] args) {
    int v = 1;
    double d1 = (double) v;
    double d2 = v; // coersion

    System.out.println(d2);
  }
}


/**
 * Universal polymorphism:
 * 1. Inclusion Polymorphism (Subtype (or subclass) polymorphism).
 * 2. Parametric Polymorphism.
 */
class InclusionPolymorphism {
  public static void main(String[] args) {
    class T {
    }
    class S1 extends T {
    }
    class S2 extends T {
    }

    T t;
    S1 s1 = new S1();
    S2 s2 = new S2();

    t = s1; // A value of type s1 can be assigned to variable of type T
    t = s2; // A value of type s2 can be assigned to variable of type T

    System.out.println(t);
  }
}


class ParametricPolymorphism {
  public static void main(String[] args) {
    // Use List for String type
    List<String> sList = new ArrayList<String>();
    sList.add("string 1");
    sList.add("string 2");
    String s2 = sList.get(1);

    // Use List for Integer type
    List<Integer> iList = new ArrayList<Integer>();
    iList.add(10);
    iList.add(20);
    int i2 = iList.get(1);

    System.out.println(String.format("s2=%s;i2=%s;", s2, i2));
  }
}
