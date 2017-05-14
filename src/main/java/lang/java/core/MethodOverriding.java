package lang.java.core;

public class MethodOverriding {
  public static void main(String[] args) {
    class A {
      public void print() {
        System.out.println("A");
      }
    }
    class B extends A {
      public void print() {
        super.print();
        System.out.println("B");
      }
    }
    new B().print();
  }
}
