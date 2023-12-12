import java.util.*;
import java.util.stream.Collectors;

class User {
    private String name;

    public User(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }
}

class Order {
    private Customer customer;
    private double price;

    public Order(Customer customer, double price) {
        this.customer = customer;
        this.price = price;
    }

    public Customer getCustomer() {
        return customer;
    }

    public double getPrice() {
        return price;
    }
}

class Customer {
    private boolean vip;

    public Customer(boolean vip) {
        this.vip = vip;
    }

    public boolean isVip() {
        return vip;
    }
}

public class OptionalStreamExample {

    public static void main(String[] args) {
        // Example 1: Filtering with Optional
        List<User> userList = Arrays.asList(new User("John"),
                                            new User(null),
                                            new User("Alice"));

        List<User> filteredUsers = userList.stream()
                                   .filter(user -> Optional.ofNullable(user.getName()).isPresent())
                                   .collect(Collectors.toList());

        System.out.println("Filtered Users: " + filteredUsers);

        // Example 2: Mapping with Optional
        List<String> userNames = userList.stream()
                                 .map(user -> Optional.ofNullable(user.getName()).orElse("Unknown"))
                                 .collect(Collectors.toList());

        System.out.println("User Names: " + userNames);

        // Example 3: Combining Filtering and Mapping
        List<Order> orderList = Arrays.asList(
                                    new Order(new Customer(true), 100.0),
                                    new Order(new Customer(false), 50.0),
                                    new Order(null, 75.0)
                                );

        double totalVIPOrderPrice = orderList.stream()
                                    .filter(order -> Optional.ofNullable(order.getCustomer())
                                            .map(Customer::isVip)
                                            .orElse(false))
                                    .mapToDouble(Order::getPrice)
                                    .sum();

        System.out.println("Total VIP Order Price: " + totalVIPOrderPrice);

        // Example 4: Comparing Null Handling Strategies
        List<User> filteredUsersWithNullCheck = new ArrayList<>();
        for (User user : userList) {
            if (user.getName() != null) {
                filteredUsersWithNullCheck.add(user);
            }
        }

        List<User> filteredUsersWithOptional = userList.stream()
                                               .filter(user -> Optional.ofNullable(user.getName()).isPresent())
                                               .collect(Collectors.toList());

        System.out.println("Filtered Users with Null Check: " + filteredUsersWithNullCheck);
        System.out.println("Filtered Users with Optional: " + filteredUsersWithOptional);
    }
}
