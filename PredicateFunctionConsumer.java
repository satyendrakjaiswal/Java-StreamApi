import java.util.Arrays;
import java.util.List;
import java.util.function.*;

class Person {
    private String name;
    private int age;

    public Person(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }
}

public class PredicateFunctionConsumer {
    public static void main(String[] args) {
        List<Person> people = Arrays.asList(
                                  new Person("Alice", 25),
                                  new Person("Bob", 30),
                                  new Person("Charlie", 38),
                                  new Person("Amy", 32),
                                  new Person("Bill", 72)
                              );

        // Predicate: Check if a person is older than a specified age
        Predicate<Person> isOlderThan30 = person -> person.getAge() > 30;

        // Function: Transform a person to a description string
        Function<Person, String> describePerson = person ->
                person.getName() + " is " + person.getAge() + " years old";

        // Consumer: Print the description of a person
        Consumer<String> printDescription = System.out::println;

        // BiFunction: Concatenate the names of two persons
        BiFunction<Person, Person, String> concatenateNames = (person1, person2) ->
                person1.getName() + " and " + person2.getName();

        // BiConsumer: Print the concatenated names of two persons
        BiConsumer<Person, Person> printConcatenatedNames = (person1, person2) ->
                System.out.println("Concatenated names: " + concatenateNames.apply(person1, person2));

        // BiPredicate: Check if the sum of ages of two persons is greater than 50
        BiPredicate<Person, Person> isSumOfAgesGreaterThan50 = (person1, person2) ->
                (person1.getAge() + person2.getAge()) > 50;

        // Using forEach with functional interfaces
        people.forEach(person -> {
            if (isOlderThan30.test(person)) {
                String description = describePerson.apply(person);
                printDescription.accept(description);
            }
        });

        // Using BiFunction and BiConsumer
        Person person1 = people.get(0);
        Person person2 = people.get(1);
        String concatenatedNames = concatenateNames.apply(person1, person2);
        printConcatenatedNames.accept(person1, person2);

        // Using BiPredicate
        if (isSumOfAgesGreaterThan50.test(person1, person2)) {
            System.out.println("Sum of ages is greater than 50!");
        }
    }
}
