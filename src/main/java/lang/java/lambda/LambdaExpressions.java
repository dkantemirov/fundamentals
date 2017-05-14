package lang.java.lambda;

import java.util.function.IntBinaryOperator;
import java.util.function.IntFunction;

/**
 * A lambda expression is not a method, although its declaration looks
 * similar to a method. As the name suggests, a lambda expression is an
 * expression that represents an instance of a functional interface.
 */
public class LambdaExpressions {
    public static void main(String[] args) {
        // Takes an int parameter and returns the parameter value incremented by 1
        IntFunction inc = (int x) -> x + 1;
        IntFunction conciseInc = x -> x + 1;
        System.out.println(conciseInc.apply(5)); // 6

        // Takes two int parameters and returns their sum
        IntBinaryOperator sum = (int x, int y) -> x + y;
        IntBinaryOperator conciseSum = (x, y) -> x + y;
        System.out.println(conciseSum.applyAsInt(1, 2)); // 3

        // Takes two int parameters and returns the maximum of the two
        IntBinaryOperator max = (int x, int y) -> {
            int m = x > y ? x : y;
            return m;
        };
        IntBinaryOperator conciseMax = (x, y) -> x > y ? x : y;
        System.out.println(conciseMax.applyAsInt(1, 2)); // 2

        // Takes no parameters and returns void
        Runnable run = () -> {
        };
    }
}