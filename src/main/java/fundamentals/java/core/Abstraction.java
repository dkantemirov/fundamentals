package fundamentals.java.core;

abstract class Abstraction {
    int i = 1; // mutable state

    abstract int count();

    static void foo() {
        System.out.println("foo");
    }
}

class AbstractionImpl extends Abstraction {
    public int count() {
        foo(); // inherited static method
        return i; // inherited field
    }
    public static void main(String[] args) {
        new AbstractionImpl().count();
    }
}