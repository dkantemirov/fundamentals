package lang.java.lambda;

import java.io.Serializable;

interface Sensitive {
    // It ia a marker interface. So, no methods exist.
}

public class IntersectionType {
    public static void main(String[] args) {
        // Example with custom marker interface
        Sensitive sen = (Sensitive & Adder) (x, y) -> x + y;

        Serializable ser = (Serializable & Adder) (x, y) -> x + y;
    }
}
