package lang.java.lambda;

import java.util.function.Function;

public class FunctionComposition {
    public static void main(String[] args) {
        // Create two functions
        Function<Long, Long> square = x -> x * x;
        Function<Long, Long> addOne = x -> x + 1;

        // Compose functions from the two functions
        Function<Long, Long> squareAddOne = square.andThen(addOne);
        Function<Long, Long> addOneSquare = square.compose(addOne);

        // Get an identity function
        Function<Long, Long> identity = Function.<Long>identity();

        // Test the functions
        long num = 5L;
        System.out.println("Number : " + num);
        System.out.println("Square and then add one: " + squareAddOne.apply(num));
        System.out.println("Add one and then square: " + addOneSquare.apply(num));
        System.out.println("Identity: " + identity.apply(num));

        // Square the input, add one to the result, and square the result
        Function<Long, Long> chainedFunction = ((Function<Long, Long>)(x -> x * x)) // Cast help
                .andThen(x -> x + 1)
                .andThen(x -> x * x);
        System.out.println(chainedFunction.apply(3L));
    }
}
