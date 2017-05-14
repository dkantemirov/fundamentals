package lang.java.core;

class LateBindingSuper {
  public void print() {
    System.out.println("Inside LateBindingSuper.print()");
  }
}


class LateBindingSub extends LateBindingSuper {
  public void print() {
    System.out.println("Inside LateBindingSub.print()");
  }
}


public class LateBinding {
  public static void main(String[] args) {
    LateBindingSuper lbSuper = new LateBindingSuper();
    LateBindingSub lbSub = new LateBindingSub();

    // Will access LateBindingSuper.print()
    lbSuper.print(); // #1

    // Will access LateBindingSub.print()
    lbSub.print();
    // #2

    // Will access LateBindingSub.print()
    ((LateBindingSuper) lbSub).print(); // #3

    // Assign the lbSub to lbSuper
    lbSuper = lbSub; // Upcasting

    // Will access LateBindingSub.print() because lbSuper
    // is referring to a LateBindingSub object
    lbSuper.print(); // #4
  }
}
