import java.util.*;
import java.util.stream.Collectors;

class Transaction {
    private int id;
    private double amount;
    private String category;

    public Transaction(int id, double amount, String category) {
        this.id = id;
        this.amount = amount;
        this.category = category;
    }

    public int getId() {
        return id;
    }

    public double getAmount() {
        return amount;
    }

    public String getCategory() {
        return category;
    }

    @Override
    public String toString() {
        return "Transaction{" +
               "id=" + id +
               ", amount=" + amount +
               ", category='" + category + '\'' +
               '}';
    }
}

public class CollectorExample {
    public static void main(String[] args) {
        List<Transaction> transactions = Arrays.asList(
                                             new Transaction(1, 100.0, "Grocery"),
                                             new Transaction(2, 150.0, "Electronics"),
                                             new Transaction(3, 50.0, "Grocery"),
                                             new Transaction(4, 200.0, "Clothing"),
                                             new Transaction(5, 75.0, "Electronics")
                                         );

        // Example 1: toList
        List<Transaction> groceryTransactions = transactions.stream()
                                                .filter(transaction -> transaction.getCategory().equals("Grocery"))
                                                .collect(Collectors.toList());

        System.out.println("Grocery Transactions: " + groceryTransactions);

        // Example 2: toSet
        Set<String> uniqueCategories = transactions.stream()
                                       .map(Transaction::getCategory)
                                       .collect(Collectors.toSet());

        System.out.println("Unique Categories: " + uniqueCategories);

        // Example 3: toMap
        Map<Integer, Double> idToAmountMap = transactions.stream()
                                             .collect(Collectors.toMap(Transaction::getId, Transaction::getAmount));

        System.out.println("ID to Amount Map: " + idToAmountMap);

        // Example 4: joining
        String allCategories = transactions.stream()
                               .map(Transaction::getCategory)
                               .collect(Collectors.joining(", "));

        System.out.println("All Categories: " + allCategories);
    }
}
