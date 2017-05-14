package lang.java.core;

interface Interface1 {
    default void foo() { System.out.println("Interface1's foo"); }
}
interface Interface2 {
    default void foo() { System.out.println("Interface2's foo"); }
}

/**
 * In this case, resolve the conflict manually by using the super keyword within
 * the Diamond class to explicitly mention which method definition to use:
 */
public class DiamondProblem implements Interface1, Interface2 {
    public void foo() {
        Interface1.super.foo();
    }

    public static void main(String []args) {
        new DiamondProblem().foo();
    }
}

/**
 * If a base class and a base interface define methods with the same signature,
 * the method definition in the class is used and the interface definition is ignored.
 */
class BaseClass {
    public void foo() { System.out.println("BaseClass's foo"); }
}
interface BaseInterface {
    default public void foo() { System.out.println("BaseInterface's foo"); }
}
class DiamondProblem2 extends BaseClass implements BaseInterface {
    public static void main(String []args) {
        new DiamondProblem2().foo();
    }
}
