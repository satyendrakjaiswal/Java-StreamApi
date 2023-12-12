import java.util.*;
import java.util.stream.Collectors;

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

    @Override
    public String toString() {
        return name + " - " + age;
    }
}

public class GroupingByAndPartitioningBy {

    public static void main(String[] args) {
        List<Person> people = Arrays.asList(
                new Person("Alice", 25),
                new Person("Bob", 30),
                new Person("Charlie", 22),
                new Person("David", 35),
                new Person("Eva", 28),
                new Person("Frank", 22)
                // ... more persons
        );

        // Example of groupingBy
        Map<Integer, List<Person>> peopleByAge = people.stream()
                .collect(Collectors.groupingBy(Person::getAge));

        System.out.println("GroupingBy result:");
        System.out.println(peopleByAge);

        // Example of partitioningBy
        Map<Boolean, List<Person>> partitionedPeople = people.stream()
                .collect(Collectors.partitioningBy(person -> person.getAge() > 25));

        System.out.println("\nPartitioningBy result:");
        System.out.println(partitionedPeople);
    }
}
