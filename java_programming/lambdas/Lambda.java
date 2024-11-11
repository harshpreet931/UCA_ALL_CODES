import java.util.function.Consumer;
import java.util.function.Predicate;
import java.util.function.Supplier;
import java.util.function.Function;
import java.util.*;
import java.io.*;

public class Lambda {
    public static void main(String[] args) {
        // Consumer -> is used to accept a single argument and return no result
        Consumer<String> consumer = (String s) -> System.out.println(s);
        consumer.accept("Hello World");

        // Predicate -> is used to accept a single argument and return a boolean result
        // valid paranthesis or not
        Predicate<String> predicate = (String s) -> {
            Stack<Character> stack = new Stack<>();
            for (char c : s.toCharArray()) {
                if (c == '(') {
                    stack.push(c);
                } else if (c == ')') {
                    if (stack.isEmpty()) {
                        return false;
                    }
                    stack.pop();
                }
            }
            return stack.isEmpty();
        };
        
        System.out.println(predicate.test("()")); // true

        // Supplier -> is used to return a single value
        Supplier<Double> randomNumberGen = () -> {
            return Math.random();
        };
        System.out.println(randomNumberGen.get());

        // Function -> is used to accept a single argument and return a result
        Function<String, Integer> getStringLen = (String s) -> {
            return s.length();
        };

        System.out.println(getStringLen.apply("Hello World")); // 11
    }
}
