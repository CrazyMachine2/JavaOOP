import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.Iterator;

public class ChainblockTests {
    private Transaction transaction;
    private Transaction secondTransaction;
    private Chainblock chainblock;
    private final int DEFAULT_ID = 1;
    private final TransactionStatus DEFAULT_STATUS = TransactionStatus.ABORTED;
    private final String DEFAULT_FROM = "Me";
    private final String DEFAULT_TO = "You";
    private final double DEFAULT_AMOUNT = 15.5;
    private final int NOT_PRESENT_ID = 15;
    private final int SECOND_TRANSACTION_ID = 2;
    private final TransactionStatus SECOND_TRANSACTION_STATUS = TransactionStatus.SUCCESSFUL;
    private final String SECOND_TRANSACTION_FROM = "Ivan";
    private final String SECOND_TRANSACTION_TO = "Pesho";
    private final double SECOND_TRANSACTION_AMOUNT = 20.5;


    @Before
    public void setUp() {
        this.transaction =
                new TransactionImpl(DEFAULT_ID, DEFAULT_STATUS, DEFAULT_FROM, DEFAULT_TO, DEFAULT_AMOUNT);

        this.secondTransaction =
                new TransactionImpl(SECOND_TRANSACTION_ID, SECOND_TRANSACTION_STATUS,
                        SECOND_TRANSACTION_FROM, SECOND_TRANSACTION_TO, SECOND_TRANSACTION_AMOUNT);

        this.chainblock = new ChainblockImpl();
    }

    @Test
    public void containsIdShouldReturnFalseIfThereIsNoTransactionWithTheGivenId() {
        Assert.assertFalse(this.chainblock.contains(NOT_PRESENT_ID));
    }

    @Test
    public void containsIdShouldReturnTrueIfThereIsTransactionWithTheGivenId() {
        this.chainblock.add(this.transaction);
        Assert.assertTrue(this.chainblock.contains(DEFAULT_ID));
    }

    @Test
    public void addShouldAddProduct() {
        this.chainblock.add(this.transaction);
        this.chainblock.contains(this.transaction);
    }

    @Test
    public void shouldHaveNonZeroTransactionsAfterProductIsAdded() {
        this.chainblock.add(this.transaction);
        Assert.assertEquals(1, this.chainblock.getCount());
    }

    @Test
    public void shouldHaveEqualToTransactionsAdded() {
        this.chainblock.add(this.transaction);
        this.chainblock.add(this.secondTransaction);
        Assert.assertEquals(2, this.chainblock.getCount());
    }

    @Test
    public void addShouldNotAddTransactionIfItsAlreadyPresent() {
        this.chainblock.add(this.transaction);
        this.chainblock.add(this.transaction);

        Assert.assertEquals(1, this.chainblock.getCount());
    }

    @Test(expected = IllegalArgumentException.class)
    public void changeTransactionStatusShouldThrowExceptionIfNoSuchTransactionExists() {
        this.chainblock.changeTransactionStatus(NOT_PRESENT_ID, DEFAULT_STATUS);
    }

    @Test
    public void changeTransactionStatusShouldChangeTheStatus() {
        this.chainblock.add(this.transaction);
        this.chainblock.changeTransactionStatus(DEFAULT_ID, SECOND_TRANSACTION_STATUS);
        Assert.assertEquals(SECOND_TRANSACTION_STATUS, this.transaction.getStatus());
    }

    @Test(expected = IllegalArgumentException.class)
    public void removeShouldThrowExceptionIfNoSuchTransactionExists() {
        this.chainblock.removeTransactionById(NOT_PRESENT_ID);
    }

    @Test
    public void removeShouldRemoveTheCorrectTransaction() {
        this.chainblock.add(this.transaction);
        this.chainblock.removeTransactionById(DEFAULT_ID);
        Assert.assertFalse(this.chainblock.contains(DEFAULT_ID));
    }

    @Test(expected = IllegalArgumentException.class)
    public void getByIdShouldThrowExceptionIfNoSuchTransactionExists() {
        this.chainblock.getById(NOT_PRESENT_ID);
    }

    @Test
    public void getByIdShouldReturnTheCorrectTransaction() {
        this.chainblock.add(this.transaction);
        this.chainblock.add(this.secondTransaction);

        Assert.assertEquals(this.secondTransaction, this.chainblock.getById(SECOND_TRANSACTION_ID));
    }

    @Test(expected = IllegalArgumentException.class)
    public void getByTransactionStatusShouldThrowExceptionIfThereAreNoTransactionsWithTheGivenStatus() {
        this.chainblock.getByTransactionStatus(DEFAULT_STATUS);
    }

    @Test
    public void getByTransactionStatusShouldReturnTheTransactionsInTheRightOrder() {
        seedTheChainblockWithTheRightTransactionStatus();

        Transaction[] sorted = {this.transaction, this.secondTransaction};

        Iterable<Transaction> actual = this.chainblock.getByTransactionStatus(DEFAULT_STATUS);
        assertArrayAndIterableWithTransaction(sorted, actual);
    }

    @Test
    public void getByTransactionStatusShouldFilterTheRightTransaction() {
        seedTheChainblockWithTheRightTransactionStatus();
        Transaction third = new TransactionImpl(5, TransactionStatus.UNAUTHORIZED, DEFAULT_FROM, DEFAULT_TO, DEFAULT_AMOUNT);
        this.chainblock.add(third);

        Transaction[] sorted = {this.transaction, this.secondTransaction};

        Iterable<Transaction> actual = this.chainblock.getByTransactionStatus(DEFAULT_STATUS);
        assertArrayAndIterableWithTransaction(sorted, actual);
    }

    @Test(expected = IllegalArgumentException.class)
    public void getAllSendersWithTransactionStatusShouldThrowExceptionIfNoSuchTransactionExists() {
        this.chainblock.getAllSendersWithTransactionStatus(DEFAULT_STATUS);
    }

    @Test
    public void getAllSendersWithTransactionStatusShouldReturnTheSendersInRightOrder() {
        seedTheChainblockWithTheRightTransactionStatus();
        String[] sorted = {SECOND_TRANSACTION_FROM, DEFAULT_FROM};
        Iterable<String> actual = this.chainblock.getAllSendersWithTransactionStatus(DEFAULT_STATUS);
        assertArrayAndIterableWithString(sorted, actual);
    }

    @Test
    public void getAllSendersWithTransactionStatusShouldReturnTheSendersInRightOrderIfThereAreMultipleSendersWithTheSameName() {
        seedTheChainblockWithTheRightTransactionStatus();

        TransactionImpl sameSenderTransaction =
                new TransactionImpl(3, DEFAULT_STATUS, DEFAULT_FROM, DEFAULT_TO, DEFAULT_AMOUNT);

        this.chainblock.add(sameSenderTransaction);

        String[] sorted = {SECOND_TRANSACTION_FROM, DEFAULT_FROM, DEFAULT_FROM};
        Iterable<String> actual = this.chainblock.getAllSendersWithTransactionStatus(DEFAULT_STATUS);
        assertArrayAndIterableWithString(sorted, actual);
    }

    @Test(expected = IllegalArgumentException.class)
    public void getAllReceiversWithTransactionStatusShouldThrowExceptionIfNoSuchTransactionExists() {
        this.chainblock.getAllReceiversWithTransactionStatus(DEFAULT_STATUS);
    }

    @Test
    public void getAllReceiversWithTransactionStatusShouldReturnTheSendersInRightOrder() {
        seedTheChainblockWithTheRightTransactionStatus();
        String[] sorted = {SECOND_TRANSACTION_TO, DEFAULT_TO};
        Iterable<String> actual = this.chainblock.getAllReceiversWithTransactionStatus(DEFAULT_STATUS);
        assertArrayAndIterableWithString(sorted, actual);
    }

    @Test
    public void getAllReceiversWithTransactionStatusShouldReturnTheSendersInRightOrderIfThereAreMultipleSendersWithTheSameName() {
        seedTheChainblockWithTheRightTransactionStatus();

        TransactionImpl sameSenderTransaction =
                new TransactionImpl(3, DEFAULT_STATUS, DEFAULT_FROM, DEFAULT_TO, DEFAULT_AMOUNT);

        this.chainblock.add(sameSenderTransaction);

        String[] sorted = {SECOND_TRANSACTION_TO, DEFAULT_TO, DEFAULT_TO};
        Iterable<String> actual = this.chainblock.getAllReceiversWithTransactionStatus(DEFAULT_STATUS);
        assertArrayAndIterableWithString(sorted, actual);
    }

    @Test
    public void getAllOrderedByAmountDescendingThenByIdShouldReturnZeroIfChainblockIsEmpty() {
        Iterable<Transaction> actual = this.chainblock.getAllOrderedByAmountDescendingThenById();

        Assert.assertFalse(actual.iterator().hasNext());
    }

    @Test
    public void getAllOrderedByAmountDescendingThenByIdShouldReturnTransactionsCorrectly() {
        this.chainblock.add(this.secondTransaction);
        this.chainblock.add(this.transaction);

        Transaction[] sorted = {this.transaction, this.secondTransaction};
        Iterable<Transaction> actual = this.chainblock.getAllOrderedByAmountDescendingThenById();

        assertArrayAndIterableWithTransaction(sorted, actual);
    }

    @Test
    public void getAllOrderedByAmountDescendingThenByIdShouldReturnTransactionsCorrectlyIfThereAreMultipleWithTheSameAmmount() {
        Transaction third = new TransactionImpl(3, DEFAULT_STATUS, DEFAULT_FROM, DEFAULT_TO, DEFAULT_AMOUNT);

        this.chainblock.add(third);
        this.chainblock.add(this.secondTransaction);
        this.chainblock.add(this.transaction);


        Transaction[] sorted = {this.transaction, third, this.secondTransaction};
        Iterable<Transaction> actual = this.chainblock.getAllOrderedByAmountDescendingThenById();

        assertArrayAndIterableWithTransaction(sorted, actual);
    }

    @Test(expected = IllegalArgumentException.class)
    public void getBySenderOrderedByAmountDescendingShouldThrowExceptionIfThereIsNoSuchTransaction(){
        this.chainblock.getBySenderOrderedByAmountDescending(DEFAULT_FROM);
    }

    @Test
    public void getBySenderOrderedByAmountDescendingShouldReturnTheCorrectSingleResult(){
        this.chainblock.add(this.transaction);
        Iterable<Transaction> actual = this.chainblock.getBySenderOrderedByAmountDescending(DEFAULT_FROM);

        Assert.assertEquals(this.transaction,actual.iterator().next());
    }

    @Test
    public void getBySenderOrderedByAmountDescendingShouldReturnTheCorrectResultWithMultipleTransactionWithTheSameSender(){
        Transaction currentSecond = new TransactionImpl(SECOND_TRANSACTION_ID,DEFAULT_STATUS,
                DEFAULT_FROM,DEFAULT_TO, DEFAULT_AMOUNT - 1);
        Transaction currentThird = new TransactionImpl(3,DEFAULT_STATUS,
                DEFAULT_FROM,DEFAULT_TO, DEFAULT_AMOUNT - 2);

        this.chainblock.add(this.transaction);
        this.chainblock.add(currentSecond);
        this.chainblock.add(currentThird);

        Transaction[] sorted = {currentThird,currentSecond,this.transaction};
        Iterable<Transaction> actual = this.chainblock.getBySenderOrderedByAmountDescending(DEFAULT_FROM);

       assertArrayAndIterableWithTransaction(sorted,actual);
    }

    @Test(expected = IllegalArgumentException.class)
    public void getByReceiverOrderedByAmountThenByIdShouldThrowExceptionIfThereIsNoSuchTransaction(){
        this.chainblock.getByReceiverOrderedByAmountThenById(DEFAULT_TO);
    }

    @Test
    public void getByReceiverOrderedByAmountThenByIdShouldReturnTheCorrectSingleResult(){
        this.chainblock.add(this.transaction);
        Iterable<Transaction> actual = this.chainblock.getByReceiverOrderedByAmountThenById(DEFAULT_TO);

        Assert.assertEquals(this.transaction,actual.iterator().next());
    }

    @Test
    public void getByReceiverOrderedByAmountThenByIdShouldReturnTheCorrectMultipleResult(){
        Transaction currentSecond = new TransactionImpl(SECOND_TRANSACTION_ID,DEFAULT_STATUS,
                DEFAULT_FROM,DEFAULT_TO, DEFAULT_AMOUNT - 1);
        Transaction currentThird = new TransactionImpl(3,DEFAULT_STATUS,
                DEFAULT_FROM,DEFAULT_TO, DEFAULT_AMOUNT);

        this.chainblock.add(currentThird);
        this.chainblock.add(this.transaction);
        this.chainblock.add(currentSecond);

        Transaction[] sorted = {currentSecond,this.transaction,currentThird};
        Iterable<Transaction> actual = this.chainblock.getByReceiverOrderedByAmountThenById(DEFAULT_TO);

        assertArrayAndIterableWithTransaction(sorted,actual);
    }

    @Test
    public void getByTransactionStatusAndMaximumAmountShouldReturnEmptyCollectionIfStatusIsDifferent(){
        this.chainblock.add(this.transaction);
        Iterable<Transaction> actual = this.chainblock.getByTransactionStatusAndMaximumAmount(SECOND_TRANSACTION_STATUS, DEFAULT_AMOUNT);
        Assert.assertFalse(actual.iterator().hasNext());
    }

    @Test
    public void getByTransactionStatusAndMaximumAmountShouldReturnEmptyCollectionIfAmountIsOutOfBound(){
        this.chainblock.add(this.transaction);
        Iterable<Transaction> actual = this.chainblock.getByTransactionStatusAndMaximumAmount(DEFAULT_STATUS, DEFAULT_AMOUNT -1);
        Assert.assertFalse(actual.iterator().hasNext());
    }

    @Test
    public void getByTransactionStatusAndMaximumAmountShouldReturnCorrectSingleResult(){
        this.chainblock.add(this.transaction);
        Iterable<Transaction> actual = this.chainblock.getByTransactionStatusAndMaximumAmount(DEFAULT_STATUS, DEFAULT_AMOUNT);
        Assert.assertEquals(this.transaction,actual.iterator().next());
    }

    @Test
    public void getByTransactionStatusAndMaximumAmountShouldReturnCorrectMultipleResults(){
        seedTheChainblockWithTheRightTransactionStatus();
        Iterable<Transaction> actual = this.chainblock.getByTransactionStatusAndMaximumAmount(DEFAULT_STATUS, SECOND_TRANSACTION_AMOUNT);
        Transaction[] sorted = {this.transaction,this.secondTransaction};

        assertArrayAndIterableWithTransaction(sorted,actual);
    }


    @Test(expected = IllegalArgumentException.class)
    public void getBySenderAndMinimumAmountDescendingShouldThrowExceptionIfThereIsNoSuchSender(){
        this.chainblock.add(this.transaction);
        this.chainblock.getBySenderAndMinimumAmountDescending(SECOND_TRANSACTION_FROM,DEFAULT_AMOUNT);
    }

    @Test(expected = IllegalArgumentException.class)
    public void getBySenderAndMinimumAmountDescendingShouldThrowExceptionIfThereIsNoTransactionInTheGivenAmountRange(){
        this.chainblock.add(this.transaction);
        this.chainblock.getBySenderAndMinimumAmountDescending(DEFAULT_FROM,DEFAULT_AMOUNT + 1);
    }

    @Test
    public void getBySenderAndMinimumAmountDescendingShouldReturnCorrectSingleResult(){
        this.chainblock.add(this.transaction);
        Iterable<Transaction> actual = this.chainblock.getBySenderAndMinimumAmountDescending(DEFAULT_FROM, DEFAULT_AMOUNT - 1);
        Assert.assertEquals(this.transaction,actual.iterator().next());
    }

    @Test
    public void getBySenderAndMinimumAmountDescendingShouldReturnCorrectMultipleResults(){
        Transaction currentSecond = new TransactionImpl(2,DEFAULT_STATUS,DEFAULT_FROM,DEFAULT_TO,DEFAULT_AMOUNT + 1);
        Transaction currentThird = new TransactionImpl(3,DEFAULT_STATUS,DEFAULT_FROM,DEFAULT_TO,DEFAULT_AMOUNT + 2);

        this.chainblock.add(currentThird);
        this.chainblock.add(currentSecond);
        this.chainblock.add(this.transaction);

        Iterable<Transaction> actual = this.chainblock.getBySenderAndMinimumAmountDescending(DEFAULT_FROM, DEFAULT_AMOUNT - 1);
        Transaction[] sorted = {this.transaction,currentSecond,currentThird};


        assertArrayAndIterableWithTransaction(sorted,actual);
    }

    //TODO IMPLEMENT THE TESTS FOR THE LAST TWO METHODS

    private void assertArrayAndIterableWithTransaction(Transaction[] sorted, Iterable<Transaction> actual) {
        Iterator<Transaction> iterator = actual.iterator();
        Assert.assertTrue(actual.iterator().hasNext());
        int i = 0;
        while (iterator.hasNext()) {
            Assert.assertEquals(sorted[i++], iterator.next());
        }
    }

    private void assertArrayAndIterableWithString(String[] sorted, Iterable<String> actual) {
        Iterator<String> iterator = actual.iterator();
        Assert.assertTrue(actual.iterator().hasNext());
        int i = 0;
        while (iterator.hasNext()) {
            Assert.assertEquals(sorted[i++], iterator.next());
        }
    }

    private void seedTheChainblockWithTheRightTransactionStatus() {
        this.chainblock.add(this.secondTransaction);
        this.chainblock.add(this.transaction);
        this.chainblock.changeTransactionStatus(SECOND_TRANSACTION_ID, DEFAULT_STATUS);
    }

}
