package fundamentals.java.core;

import java.util.ArrayList;
import java.util.List;

public class TypeInference {
    public static void main(String[] args) {
        // Java 7. Diamond operator
        List<String> list = new ArrayList<>();

        // Using ArrayList as a raw type, not a generic type
        List<String> list1 = new ArrayList(); // Generates an unchecked warning
    }
}
