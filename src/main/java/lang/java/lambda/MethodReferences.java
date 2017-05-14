package lang.java.lambda;

import java.util.Arrays;
import java.util.List;
import java.util.function.BiFunction;
import java.util.function.Function;
import java.util.function.Supplier;
import java.util.function.ToIntFunction;

/**
 * A method reference is not a new type in Java. It is not a function pointer as used
 * in some other programming languages. It is simply shorthand for writing a lambda
 * expression using an existing method. It can only be used where a lambda expression
 * can be used.
 */
public class MethodReferences {
    static void withoutMethodRef() {
        ToIntFunction<String> lengthFunction = str -> str.length();
        String name = "Ellen";
        int len = lengthFunction.applyAsInt(name);
        System.out.println("Name = " + name + ", length = " + len);
    }

    static void withMethodRef() {
        ToIntFunction<String> lengthFunction = String::length; // method reference
        String name = "Ellen";
        int len = lengthFunction.applyAsInt(name);
        System.out.println("Name = " + name + ", length = " + len);
    }

    // A method reference to a static method of a class, an interface, or an enum
    static void withStaticMethodRef() {
        BiFunction<Integer, Integer, Integer> func2 = Integer::sum;
        System.out.println(func2.apply(17, 15));
    }

    public static void main(String[] args) {
        withoutMethodRef();
        withMethodRef();
        withStaticMethodRef();
    }
}

/**
 * An instance method is invoked on an object's reference. The object reference on which
 * an instance method is invoked is known as the receiver of the method invocation.
 * The receiver of a method invocation can be an object reference or an expression that
 * evaluates to an object's reference.
 *
 * In a method reference for an instance method, you can specify the receiver of the method
 * invocation explicitly or you can provide it implicitly when the method is invoked. The
 * former is called a bound receiver and the latter is called an unbound receiver.
 */
class InstanceMethodReferences {
    static void boundReceiver() {
        Supplier<Integer> supplier = "Ellen"::length;
        System.out.println(supplier.get());
    }

    static void unboundReceiver() {
        Function<String, Integer> strLengthFunc = String::length;
        // The receiver is supplied as the first argument to the apply() method
        System.out.println(strLengthFunc.apply("Ellen"));
    }

    public static void main(String[] args) {
        boundReceiver();
        unboundReceiver();
    }
}

class SupertypeInstanceMethodReferences {
    interface Priced {
        default double getPrice() {
            return 1.0;
        }
    }
    static class Item implements Priced {
        private String name = "Unknown";
        private double price = 0.0;

        public Item() {
            System.out.println("Constructor Item() called.");
        }

        public Item(String name) {
            this.name = name;
            System.out.println("Constructor Item(String) called.");
        }

        public Item(String name, double price) {
            this.name = name;
            this.price = price;
            System.out.println("Constructor Item(String, double) called.");
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public void setPrice(double price) {
            this.price = price;
        }

        @Override
        public double getPrice() {
            return price;
        }

        @Override
        public String toString() {
            return "name = " + getName() + ", price = " + getPrice();
        }

        public void test() {
            // Uses the Item.toString() method
            Supplier<String> s1 = this::toString;

            // Uses Object.toString() method
            Supplier<String> s2 = Item.super::toString;

            // Uses Item.getPrice() method
            Supplier<Double> s3 = this::getPrice;

            // Uses Priced.getPrice() method
            Supplier<Double> s4 = Priced.super::getPrice;
            // Uses all method references and prints the results
            System.out.println("this::toString: " + s1.get());
            System.out.println("Item.super::toString: " + s2.get());
            System.out.println("this::getPrice: " + s3.get());
            System.out.println("Priced.super::getPrice: " + s4.get());
        }
    }

    public static void main(String[] args) {
        Item apple = new Item("Apple", 0.75);
        apple.test();
    }
}

class ConstructorReferences {
    public static void main(String[] args) {
        Supplier<String> func1 = String::new;
        Function<String,String> func2 = String::new;

        System.out.println(func1.get());
        System.out.println(func2.apply("str"));
    }
}

class GenericMethodReferences {
    public static void main(String[] args) {
        Function<String[],List<String>>asList = Arrays::<String>asList;

        String[] namesArray = {"Jim", "Ken", "Li"};
        List<String> namesList = asList.apply(namesArray);
        for(String name : namesList) {
            System.out.println(name);
        }
    }
}
