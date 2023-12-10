import java.util.Arrays;
import java.util.List;
import java.util.Optional;

public class FindOperationsExample {

    public static void main(String[] args) {
        List<String> fruits = Arrays.asList("apple", "banana", "orange", "grape", "kiwi");

        // Using findAny to find any fruit starting with 'b'
        Optional<String> anyFruit = fruits.stream()
                .filter(s -> s.startsWith("b"))
                .findAny();

        anyFruit.ifPresent(fruit -> System.out.println("Any fruit starting with 'b': " + fruit));

        // Using findFirst to find the first fruit starting with 'b' or provide a default value
        String firstBfruit = fruits.stream()
                .filter(s -> s.startsWith("b"))
                .findFirst()
                .orElse("No fruit starting with 'b' found");

        System.out.println(firstBfruit);
    }
}
