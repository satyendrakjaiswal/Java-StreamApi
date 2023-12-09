import java.util.Arrays;
import java.util.List;

public class ShortCircuitOperationsExample {
    public static void main(String[] args) {
        // Example 1: anyMatch
        List<String> names = Arrays.asList("Alice", "Bob", "Charlie", "David");

        boolean anyMatchResult = names.stream()
                                 .anyMatch(name -> name.startsWith("C"));

        System.out.println("Any name starts with 'C': " + anyMatchResult);

        // Example 2: allMatch
        List<Integer> numbers = Arrays.asList(2, 4, 6, 8, 10);

        boolean allMatchResult = numbers.stream()
                                 .allMatch(num -> num % 2 == 0);

        System.out.println("All numbers are even: " + allMatchResult);

        // Example 3: noneMatch
        List<String> fruits = Arrays.asList("Apple", "Banana", "Cherry", "Date");

        boolean noneMatchResult = fruits.stream()
                                  .noneMatch(fruit -> fruit.length() > 10);

        System.out.println("No fruit has a name longer than 10 characters: " + noneMatchResult);
    }
}
