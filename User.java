import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class User {
    private String name;
    private int age;
    private List<String> phoneNumbers;
    private boolean active;
    private List<String> addresses;

    public User(String name, int age, boolean active, List<String> phoneNumbers, List<String> addresses) {
        this.name = name;
        this.age = age;
        this.active = active;
        this.phoneNumbers = phoneNumbers;
        this.addresses = addresses;
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    public boolean isActive() {
        return active;
    }

    public List<String> getPhoneNumbers() {
        return phoneNumbers;
    }

    public List<String> getAddresses() {
        return addresses;
    }

    public static void main(String[] args) {
        List<User> userList = Arrays.asList(
                                  new User("Alfa", 25, true, Arrays.asList("123", "456"), Arrays.asList("Address1", "Address2")),
                                  new User("Beta", 33, false, Arrays.asList("789", "101"), Arrays.asList("Address3", "Address4")),
                                  new User("Gama", 30, true, Arrays.asList("202", "303"), Arrays.asList("Address1", "Address5")),
                                  new User("Delta", 38, true, Arrays.asList("208", "232"), Arrays.asList("Address3", "Address6"))
                              );

        // Filtering with filter
        List<User> activeUsersAbove30 = userList.stream()
                                        .filter(user -> user.getAge() > 30)
                                        .filter(User::isActive)
                                        .collect(Collectors.toList());

        System.out.println("Active users above 30: " + activeUsersAbove30);

        // Transforming with map
        List<String> uppercasedNames = userList.stream()
                                       .map(user -> user.getName().toUpperCase())
                                       .collect(Collectors.toList());

        System.out.println("Uppercased names: " + uppercasedNames);

        // Flattening with flatMap
        List<String> uniqueAddresses = userList.stream()
                                       .map(User::getAddresses)
                                       .flatMap(List::stream)
                                       .distinct()
                                       .collect(Collectors.toList());

        System.out.println("Unique addresses: " + uniqueAddresses);

        // Sorting with sorted
        List<User> sortedUsers = userList.stream()
                                 .sorted(Comparator.comparingInt(User::getAge))
                                 .collect(Collectors.toList());

        System.out.println("Sorted users by age: " + sortedUsers);

        // Peeking with peek
        List<String> modifiedNames = userList.stream()
        .map(user -> {
            String modified = user.getName().toLowerCase();
            System.out.println("Processing: " + modified);
            return modified;
        })
        .collect(Collectors.toList());

        System.out.println("Modified names: " + modifiedNames);

        // Combining operations
        List<String> sortedPhoneNumbers = userList.stream()
                                          .filter(User::isActive)
                                          .filter(user -> user.getAge() > 30)
                                          .flatMap(user -> user.getPhoneNumbers().stream())
                                          .sorted()
                                          .collect(Collectors.toList());
        System.out.println("Sorted phone numbers of active users above 30:");
        sortedPhoneNumbers.forEach(System.out::println);

    }
}
