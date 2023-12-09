import java.util.*;
import java.util.stream.Collectors;

class Transaction {
    private String id;
    private double amount;
    private Date date;

    public Transaction(String id, double amount, Date date) {
        this.id = id;
        this.amount = amount;
        this.date = date;
    }

    public double getAmount() {
        return amount;
    }

    public Date getDate() {
        return date;
    }

    @Override
    public String toString() {
        return "Transaction{" +
               "id='" + id + '\'' +
               ", amount=" + amount +
               ", date=" + date +
               '}';
    }
}

public class TerminalOperationsExample {

    public static void main(String[] args) {
        // Generate dummy data
        List<Transaction> transactions = generateDummyTransactions();

        // forEach: Print details of each transaction
        System.out.println("Details of each transaction:");
        transactions.stream()
        .forEach(transaction -> System.out.println(transaction));

        // count: Total number of transactions
        long transactionCount = transactions.stream()
                                .count();
        System.out.println("\nTotal number of transactions: " + transactionCount);

        // collect: List of transaction amounts
        List<Double> transactionAmounts = transactions.stream()
                                          .map(Transaction::getAmount)
                                          .collect(Collectors.toList());
        System.out.println("\nList of transaction amounts: " + transactionAmounts);

        // min: Earliest transaction date
        Optional<Date> earliestDate = transactions.stream()
                                      .map(Transaction::getDate)
                                      .min(Date::compareTo);
        System.out.println("\nEarliest transaction date: " + earliestDate.orElse(null));

        // max: Latest transaction date
        Optional<Date> latestDate = transactions.stream()
                                    .map(Transaction::getDate)
                                    .max(Date::compareTo);
        System.out.println("Latest transaction date: " + latestDate.orElse(null));

        // reduce: Total transaction amount
        double totalAmount = transactions.stream()
                             .map(Transaction::getAmount)
                             .reduce(0.0, Double::sum);
        System.out.println("\nTotal transaction amount: " + totalAmount);
    }

    // Helper method to generate dummy data
    private static List<Transaction> generateDummyTransactions() {
        List<Transaction> transactions = new ArrayList<>();
        transactions.add(new Transaction("T1", 120.50, new Date()));
        transactions.add(new Transaction("T2", 75.20, new Date()));
        transactions.add(new Transaction("T3", 150.0, new Date()));
        transactions.add(new Transaction("T4", 200.75, new Date()));
        return transactions;
    }
}
