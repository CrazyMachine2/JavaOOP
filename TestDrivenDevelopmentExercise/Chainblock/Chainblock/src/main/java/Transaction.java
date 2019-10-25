public interface Transaction extends Comparable<TransactionImpl>{
    int getId();
    TransactionStatus getStatus();
    String getFrom();
    String getTo();
    double getAmount();
    int compareTo(TransactionImpl o);
    void setStatus(TransactionStatus status);
}
