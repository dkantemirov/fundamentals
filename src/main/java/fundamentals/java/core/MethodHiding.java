package fundamentals.java.core;

class MHidingSuper {
    static void print() {
        System.out.println("Inside MHidingSuper.print()");
    }
}

class MHidingSub extends MHidingSuper {
    static void print() {
        System.out.println("Inside MHidingSub.print()");
    }
}

public class MethodHiding {
    public static void main(String[] args) {
        MHidingSuper mhSuper = new MHidingSub();
        MHidingSub mhSub = new MHidingSub();

        System.out.println("#1");

        // #1
        MHidingSuper.print();
        mhSuper.print();

        System.out.println("#2");

        // #2
        MHidingSub.print();
        mhSub.print();
        ((MHidingSuper) mhSub).print();

        System.out.println("#3");

        // #3
        mhSuper = mhSub;
        mhSuper.print();
        ((MHidingSub) mhSuper).print();
    }
}
