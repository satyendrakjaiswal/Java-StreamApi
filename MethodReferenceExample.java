import java.util.Arrays;
import java.util.List;
import java.util.function.Consumer;

public class MethodReferenceExample {

    public static void main(String[] args) {
        // Example 1: Static Method Reference
        List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5);

        // Lambda expression
        numbers.forEach(n -> System.out.println(n));

        // Static method reference
        numbers.forEach(System.out::println);

        // Example 2: Instance Method Reference on a Particular Instance
        StringManipulator stringManipulator = new StringManipulator();
        List<String> names = Arrays.asList("Alice", "Bob", "Charlie");

        // Lambda expression
        names.forEach(name -> stringManipulator.printWithPrefix(name));

        // Instance method reference
        names.forEach(stringManipulator::printWithPrefix);

        // Example 3: Instance Method Reference on an Arbitrary Instance
        // Lambda expression
        names.forEach(name -> System.out.println(name));

        // Instance method reference
        names.forEach(System.out::println);
    }
}

class StringManipulator {
    public void printWithPrefix(String s) {
        System.out.println("Hello! " + s);
    }
}
