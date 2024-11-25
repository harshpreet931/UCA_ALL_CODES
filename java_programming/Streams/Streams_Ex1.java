import java.util.*;
import java.util.stream.Collectors;

public class Streams_Ex1 {
    public static void main(String[] args) {
        List<String> names = Arrays.asList("Alice", "Bob", "Charlie", null, "David", null);

        // Filter names starting with 'A'
        List<String> res = names.stream()
                                .filter((name) -> name != null)
                                .filter((name) -> name.charAt(0) == 'A')
                                .collect(Collectors.toList());

        System.out.println(res);
        // Make the names uppercase
        res = names.stream()
                   .filter(Objects::nonNull)
                   .map(String::toUpperCase) // or String::toUpperCase as a method reference
                   .collect(Collectors.toList());

        System.out.println(res);

        // combine all the names
        String ans = names.stream().filter(Objects::nonNull).reduce("", (a, b) -> a + b);
        System.out.println(ans);

        // Optional Class wrapper -> it is used when we dont know if the value is present or not
        Optional<String> ans2 = names.stream().filter(Objects::nonNull).reduce((a, b) -> a + b);
        System.out.println(ans2.isPresent() + " " + ans2.get());

        List<Integer> nums = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9, 10);
        Integer sum = nums.stream().reduce(0, (a, b) -> a + b); // or Integer::sum as a method reference
        System.out.println(sum);

        // Find the max element
        Optional<Integer> max = nums.stream().reduce(Integer::max);

        // Grouping -> List<String>
        names = Arrays.asList("Alice", "Bob", "Charlie", "David", "Ash", "Aaliyah");

        System.out.println(names.stream().collect(Collectors.groupingBy(name -> name.charAt(0))));

        // Frequency of each string
        names = Arrays.asList("Alice", "Bob", "Charlie", "Alice", "Bob");

        Map<String, Long> freq = names.stream().collect(Collectors.groupingBy( name -> name, Collectors.counting()));
        System.out.println(freq);

        // Group the names by length of the string
        Map<Integer, List<String>> freq2 = names.stream()
                .map(String::toUpperCase)
                .collect(Collectors.groupingBy( (name) -> name.length()));
        System.out.println(freq2);

        // Parallel Streams

        System.out.println(nums.parallelStream()
                .peek(e -> System.out.println(Thread.currentThread().getName() + " processing " + e))
                .reduce(0, Integer::sum)
        );
    }
}
