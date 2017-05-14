package lang.java.lambda;

import java.util.LinkedList;
import java.util.List;
import java.util.function.*;

public class FunctionPackage {
    private List<Integer> list = new LinkedList<>();

    {
        list.add(1);
        list.add(2);
    }

    // Represents a function that takes an argument of type T and returns a result of type R.
    private Function<Integer, String> toString = Object::toString;

    // Represents a function that takes two arguments of types T and U, and returns a result of type R.
    private BiFunction<Integer, Integer, String> sumToString = (x, y) -> Integer.toString(x + y);

    /* In mathematics, a predicate is a boolean-valued function
    that takes an argument and returns true or false. The
    function represents a condition that returns true or false
    for the specified argument. */
    private Predicate<List<?>> isEmpty = List::isEmpty;

    // Represents a predicate with two arguments.
    private BiPredicate<Integer, Integer> isLess = (x, y) -> x < y;

    /* Represents an operation that takes an argument, operates
    on it to produce some side effects, and returns no result. */
    private Consumer<List<Integer>> add = x -> x.add(2);

    /* Represents an operation that takes two arguments,
    operates on them to produce some side effects, and
    returns no result. */
    private BiConsumer<List<Integer>, List<Integer>> addList = (x, y) -> list.addAll(y);

    // Represents a supplier that returns a value
    private Supplier<Integer> head = () -> list.get(0);

    /* Inherits from Function<T,T>. Represents a function that
    takes an argument and returns a result of the same type. */
    private UnaryOperator<Integer> get = x -> list.get(x);

    /* Inherits from BiFunction<T,T,T>. Represents a function
    that takes two arguments of the same type and returns a
    result of the same. */
    private BinaryOperator<Integer> sum = (x, y) -> x + y;

    /**
     * Using the Function<T,R> Interface
     */
    private IntFunction<Double> toDouble = Double::new;
    private LongFunction<Double> longToDouble = Double::new;
    private DoubleFunction<Integer> toInt = x -> new Double(x).intValue();
    private ToIntFunction<Double> asInt = Double::intValue;
    private ToLongFunction<Double> asLong = Double::longValue;
    private ToDoubleFunction<Long> asDouble = Long::doubleValue;

    public static void main(String[] args) {
        FunctionPackage functional = new FunctionPackage();
        System.out.println(functional.toString.apply(1000));
        System.out.println(functional.sumToString.apply(1000, 1001));
        System.out.println(functional.isEmpty.test(functional.list));
        System.out.println(functional.isLess.test(1, 2));
        functional.add.accept(functional.list);
        functional.addList.accept(functional.list, functional.list);
        System.out.println(functional.head.get());
        System.out.println(functional.get.apply(1));
        System.out.println(functional.sum.apply(1, 2));

        System.out.println("Result list:");
        System.out.println(functional.list);

        System.out.println(functional.toDouble.apply(1));
        System.out.println(functional.longToDouble.apply(1L));
        System.out.println(functional.toInt.apply(2.0));
        System.out.println(functional.asInt.applyAsInt(2.0));
        System.out.println(functional.asLong.applyAsLong(2.0));
        System.out.println(functional.asDouble.applyAsDouble(2L));
    }
}
