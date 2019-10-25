public class TransactionImpl implements Comparable<TransactionImpl>, Transaction{

    private int id;
    private TransactionStatus status;
    private String from;
    private String to;
    private double amount;

    public TransactionImpl(int id, TransactionStatus status, String from, String to, double amount) {
        this.id = id;
        this.status = status;
        this.from = from;
        this.to = to;
        this.amount = amount;
    }

    public int compareTo(TransactionImpl o) {
        return Double.compare(this.amount,o.amount);
    }

    public int getId() {
        return this.id;
    }

    public TransactionStatus getStatus() {
        return this.status;
    }

    public String getFrom() {
        return this.from;
    }

    public String getTo() {
        return this.to;
    }

    public double getAmount() {
        return this.amount;
    }

    @Override
    public void setStatus(TransactionStatus status) {
        this.status = status;
    }
}
