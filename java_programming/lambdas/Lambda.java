import java.util.function.Consumer;
import java.util.function.Predicate;
import java.util.function.Supplier;
import java.util.stream.Collectors;
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

        // Examples

        // Function -> take in integer, return sqrt
        Function<Integer, Double> sqrt = (i) -> Math.sqrt(i);
        System.out.println(sqrt.apply(4));

        // Function -> taking string and return uppercase
        Function<String, String> upperCase = (s) -> s.toUpperCase();
        System.out.println(upperCase.apply("hello world"));

        // Function -> taking string and returning a string with removed white spaces from front and end
        Function<String, String> trim = (s) -> s.trim();
        System.out.println(trim.apply("  hello world  "));

        // Function -> Supplier, Consumer. Supplier should gen a RandomUUID and Consumer should log it 10 times in a interval of 2 seconds
        Function<Supplier<String>, Consumer<String>> function = (supplier) -> {
            Consumer<String> cons = (s) -> {
                for (int i = 0; i < 10; i++) {
                    String id = supplier.get();
                    System.out.println(id);
                }
            };
            return cons;
        };

        function.apply(
            () -> UUID.randomUUID().toString()
        ).accept("Hello");


        // Streams

        List<Integer> list = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8);

        List<Integer> oddList = list.stream().filter((i) -> i % 2 != 0)
                                             .map((i) -> i * i)
                                             .collect(Collectors.toList());
        System.out.println(oddList);

    }
}
