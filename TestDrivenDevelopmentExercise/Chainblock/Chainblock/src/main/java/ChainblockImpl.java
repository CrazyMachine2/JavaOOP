import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class ChainblockImpl implements Chainblock {

    private Map<Integer, Transaction> transactions;

    public ChainblockImpl() {
        this.transactions = new LinkedHashMap<>();
    }

    public int getCount() {
        return this.transactions.size();
    }

    public void add(Transaction transaction) {
        if (!this.contains(transaction)) {
            this.transactions.put(transaction.getId(), transaction);
        }
    }

    public boolean contains(Transaction transaction) {
        if (this.contains(transaction.getId())) {
            return true;
        }
        return false;
    }

    public boolean contains(int id) {
        if (this.transactions.containsKey(id)) {
            return true;
        }
        return false;
    }

    public void changeTransactionStatus(int id, TransactionStatus newStatus) {
        if (!this.contains(id)) {
            throw new IllegalArgumentException();
        }
        this.getById(id).setStatus(newStatus);
    }

    public void removeTransactionById(int id) {
        if (!this.contains(id)) {
            throw new IllegalArgumentException();
        }
        this.transactions.remove(id);
    }

    public Transaction getById(int id) {
        if (!this.contains(id)) {
            throw new IllegalArgumentException();
        }
        return this.transactions.get(id);
    }

    public Iterable<Transaction> getByTransactionStatus(TransactionStatus status) {
        List<Transaction> foundTransactions = new ArrayList<>();

        filteredTransactionStatusStream(status)
                .sorted(Comparator.comparingDouble(f -> f.getValue().getAmount()))
                .forEach(entry -> foundTransactions.add(entry.getValue()));

        if (foundTransactions.isEmpty()) {
            throw new IllegalArgumentException();
        }

        return foundTransactions;
    }

    public Iterable<String> getAllSendersWithTransactionStatus(TransactionStatus status) {
        List<String> foundSenders = new ArrayList<>();

        filteredTransactionStatusStream(status)
                .forEach(entry -> foundSenders.add(entry.getValue().getFrom()));

        if (foundSenders.isEmpty()) {
            throw new IllegalArgumentException();
        }

        return foundSenders;
    }

    public Iterable<String> getAllReceiversWithTransactionStatus(TransactionStatus status) {
        List<String> foundReceivers = new ArrayList<>();

        filteredTransactionStatusStream(status)
                .forEach(entry -> foundReceivers.add(entry.getValue().getTo()));

        if (foundReceivers.isEmpty()) {
            throw new IllegalArgumentException();
        }

        return foundReceivers;
    }

    public Iterable<Transaction> getAllOrderedByAmountDescendingThenById() {
        List<Transaction> sortedTransactions = new ArrayList<>();

        this.transactions.entrySet().stream()
                .sorted(Comparator.comparingDouble((Map.Entry<Integer, Transaction> f) -> f.getValue().getAmount())
                        .thenComparingInt(Map.Entry::getKey))
                .forEach(e -> sortedTransactions.add(e.getValue()));

        return sortedTransactions;
    }

    public Iterable<Transaction> getBySenderOrderedByAmountDescending(String sender) {
        List<Transaction> foundTransactions = new ArrayList<>();

        this.transactions.entrySet().stream()
                .filter(e -> e.getValue().getFrom().equals(sender))
                .sorted(Comparator.comparingDouble(f -> f.getValue().getAmount()))
                .forEach(e -> foundTransactions.add(e.getValue()));

        if (foundTransactions.isEmpty()) {
            throw new IllegalArgumentException();
        }
        return foundTransactions;
    }

    public Iterable<Transaction> getByReceiverOrderedByAmountThenById(String receiver) {
        List<Transaction> foundTransactions = new ArrayList<>();

        this.transactions.entrySet().stream()
                .filter(e -> e.getValue().getTo().equals(receiver))
                .sorted(Comparator.comparingDouble((Map.Entry<Integer, Transaction> f) -> f.getValue().getAmount())
                        .thenComparingInt(Map.Entry::getKey))
                .forEach(e -> foundTransactions.add(e.getValue()));

        if (foundTransactions.isEmpty()) {
            throw new IllegalArgumentException();
        }
        return foundTransactions;
    }

    public Iterable<Transaction> getByTransactionStatusAndMaximumAmount(TransactionStatus status, double amount) {
        List<Transaction> foundTransactions = new ArrayList<>();

        this.filteredTransactionStatusStream(status)
                .filter(e -> e.getValue().getAmount() <= amount)
                .sorted(Comparator.comparingDouble(f -> f.getValue().getAmount()))
                .forEach(e -> foundTransactions.add(e.getValue()));

        return foundTransactions;
    }

    public Iterable<Transaction> getBySenderAndMinimumAmountDescending(String sender, double amount) {
        List<Transaction> foundTransactions = new ArrayList<>();

        this.transactions.entrySet().stream()
                .filter(e -> e.getValue().getFrom().equals(sender) && e.getValue().getAmount() > amount)
                .sorted(Comparator.comparingDouble(f -> f.getValue().getAmount()))
                .forEach(e -> foundTransactions.add(e.getValue()));

        if (foundTransactions.isEmpty()) {
            throw new IllegalArgumentException();
        }

        return foundTransactions;
    }

    public Iterable<Transaction> getByReceiverAndAmountRange(String receiver, double lo, double hi) {
        List<Transaction> foundTransactions = new ArrayList<>();

        this.transactions.entrySet().stream()
                .filter(e -> e.getValue().getTo().equals(receiver) && (e.getValue().getAmount() >= lo && e.getValue().getAmount() <= hi))
                .forEach(e -> foundTransactions.add(e.getValue()));

        if(foundTransactions.isEmpty()){
            throw new IllegalArgumentException();
        }

        return foundTransactions;
    }

    public Iterable<Transaction> getAllInAmountRange(double lo, double hi) {
        List<Transaction> foundTransactions = new ArrayList<>();

        this.transactions.entrySet().stream()
                .filter(e -> e.getValue().getAmount() >= lo && e.getValue().getAmount() <= hi)
                .forEach(e -> foundTransactions.add(e.getValue()));

        return foundTransactions;
    }

    public Iterator<Transaction> iterator() {
        return null;
    }

    private Stream<Map.Entry<Integer, Transaction>> filteredTransactionStatusStream(TransactionStatus status) {
        return this.transactions.entrySet()
                .stream()
                .filter(entry -> entry.getValue().getStatus().equals(status));
    }
}
