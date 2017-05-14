package lang.java.core;

import java.util.ArrayList;

/**
 * Double brace initialisation creates an anonymous class derived from
 * the specified class (the outer braces), and provides an initialiser block
 * within that class (the inner braces). e.g.
 * Note that an effect of using this double brace initialisation is that you're
 * creating anonymous inner classes. The created class has an implicit this pointer
 * to the surrounding outer class. Whilst not normally a problem, it can cause grief
 * in some circumstances e.g. when serialising or garbage collecting, and it's worth being aware of this.
 */
public class DoubleBraceInitialisation {
  public static void main(String[] args) {
    new ArrayList<Integer>() {
      {
        add(1);
        add(2);
      }
    };
  }
}
