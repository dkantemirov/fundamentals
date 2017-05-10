package fundamentals.java.core;

class Wrapper<T> {
    private T ref;

    Wrapper(T ref) {
        this.ref = ref;
    }

    T get() {
        return ref;
    }

    void set(T a) {
        this.ref = ref;
    }
}

/**
 * Implementation of generic types in Java is backward compatible.
 * If an existing non-generic class is rewritten to take advantage of generics,
 * the existing code that uses the non-generic version of the class should keep working.
 */
public class RawType {
    public static void main(String[] args) {
        Wrapper rawType = new Wrapper("Hello"); // An unchecked warning
        Wrapper<String> genericType = new Wrapper<String>("Hello");
        genericType = rawType; // An unchecked warning
        rawType = genericType;
    }
}
