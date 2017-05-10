package fundamentals.java.core;

public class UnboundedWildcard {
    private static void printDetails(Wrapper<?> wrapper) { // unbounded wildcard
        // Can assign get() return value to Object
        Object value = wrapper.get();
        String className = null;

        if (value != null) {
            className = value.getClass().getName();
        }

        System.out.println("Class: " + className);
        System.out.println("Value: " + value);
    }

    public static void main(String[] args) {
        Wrapper<String> stringWrapper = new Wrapper<String>("Hello");
        stringWrapper.set("a string");

        Wrapper<Object> objectWrapper = new Wrapper<Object>(new Object());
        objectWrapper.set(new Object()); // set another object

        // Use a String object with objectWrapper
        objectWrapper.set("a string"); // ok

        // objectWrapper = stringWrapper; !error

        printDetails(stringWrapper);
        printDetails(objectWrapper);
    }
}