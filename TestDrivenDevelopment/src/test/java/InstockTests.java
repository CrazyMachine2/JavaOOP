import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.Iterator;

public class InstockTests {
    private final String DEFAULT_PRODUCT_LABEL = "Label";
    private final int DEFAULT_PRODUCT_QUANTITY = 200;
    private final double DEFAULT_PRODUCT_PRICE = 2.5;
    private Product second;
    private Product third ;
    private Product product;
    private Instock stock;

    @Before
    public void setUp() {
        this.product = new Product(DEFAULT_PRODUCT_LABEL, DEFAULT_PRODUCT_PRICE, DEFAULT_PRODUCT_QUANTITY);
        this.second= new Product(DEFAULT_PRODUCT_LABEL + "2", 20, 10);
       this.third= new Product(DEFAULT_PRODUCT_LABEL + "3", 10, 10);
        this.stock = new Instock();
    }

    @Test
    public void shouldAddProduct() {
        this.stock.add(product);
        Assert.assertTrue(this.stock.contains(product));
    }

    @Test
    public void shouldHaveNonZeroCountAfterProductAdd() {
        this.stock.add(product);
        Assert.assertEquals(1, this.stock.getCount());
    }

    @Test
    public void shouldHaveCountEqualsToProductsAdded() {
        this.stock.add(product);
        this.stock.add(product);
        Assert.assertEquals(2, this.stock.getCount());
    }


    @Test
    public void shouldReturnFalseIfProductNotContained() {
        Assert.assertFalse(this.stock.contains(product));
    }

    @Test
    public void containsShouldReturnTrueIfProductLabelsMatch() {
        Product second = new Product(DEFAULT_PRODUCT_LABEL, 10, 10);
        this.stock.add(second);
        Assert.assertTrue(this.stock.contains(product));
    }

    @Test
    public void shouldReturnCorrectProductByInsertionOrderWhenSingleProduct() {
        this.stock.add(product);
        Product actual = this.stock.find(1);
        Assert.assertEquals(product, actual);
    }

    @Test
    public void shouldReturnCorrectProductByInsertionOrderWithMultipleProducts() {
        seedStock();

        Product actual = this.stock.find(3);
        Assert.assertEquals(third, actual);

    }

    @Test(expected = IndexOutOfBoundsException.class)
    public void shouldThrowExceptionWhenFindCalledWithInvalidIndex() {
        this.stock.find(1);
    }


    @Test
    public void shouldAddQuantityToExistingProduct() {
        this.stock.add(product);

        this.stock.changeQuantity(product.getLabel(), DEFAULT_PRODUCT_QUANTITY);
        Product actual = this.stock.find(1);
        Assert.assertEquals(2 * DEFAULT_PRODUCT_QUANTITY, actual.getQuantity());
    }

    @Test
    public void shouldAddQuantityToExistingProductMultipleTimes() {
        this.stock.add(product);

        this.stock.changeQuantity(product.getLabel(), DEFAULT_PRODUCT_QUANTITY);
        this.stock.changeQuantity(product.getLabel(), DEFAULT_PRODUCT_QUANTITY);
        this.stock.changeQuantity(product.getLabel(), DEFAULT_PRODUCT_QUANTITY);

        Product actual = this.stock.find(1);
        Assert.assertEquals(4 * DEFAULT_PRODUCT_QUANTITY, actual.getQuantity());
    }


    @Test(expected = IllegalArgumentException.class)
    public void quantityShouldThrowExceptionIfProductDoesntExist() {
        this.stock.changeQuantity(product.getLabel(), DEFAULT_PRODUCT_QUANTITY);
    }

    @Test(expected = IllegalArgumentException.class)
    public void findByLabesShouldThrowExceptionIfLabelDoesntExist() {
        this.stock.findByLabel(product.getLabel());
    }

    @Test
    public void findByLabelShouldReturnProduct() {
        this.stock.add(product);
        Product actual = this.stock.findByLabel(product.getLabel());
        Assert.assertEquals(actual, product);
    }

    @Test
    public void findByLabelShouldReturnCorrectResultForMultipleProducts() {

        seedStock();

        Product actual = this.stock.findByLabel(DEFAULT_PRODUCT_LABEL + "2");
        Assert.assertEquals(second, actual);
    }

    @Test
    public void shouldReturnFirstNProductsSortedByLabel() {

        this.stock.add(second);
        this.stock.add(third);
        this.stock.add(product);

        Iterable<Product> actual = this.stock.findFirstByAlphabeticalOrder(0);
        Assert.assertFalse(actual.iterator().hasNext());
    }

    @Test
    public void shouldReturnValidResultForZeroProductsInFindFirstByAlphabeticalOrder() {
        Iterable<Product> actual = this.stock.findFirstByAlphabeticalOrder(0);
        Assert.assertFalse(actual.iterator().hasNext());
    }

    @Test
    public void shouldReturnValidResultForNegativeCountFirstByAlphabeticalOrder() {
        Iterable<Product> actual = this.stock.findFirstByAlphabeticalOrder(-1);
        Assert.assertFalse(actual.iterator().hasNext());
    }

    @Test
    public void shouldReturnValidResultForGreaterCountFirstByAlphabeticalOrder() {

        this.stock.add(second);
        this.stock.add(third);
        this.stock.add(product);

        Iterable<Product> actual = this.stock.findFirstByAlphabeticalOrder(5);
        Assert.assertFalse(actual.iterator().hasNext());
    }

    @Test
    public void shouldReturnValidResultForFirstByAlphabeticalOrder() {

        this.stock.add(second);
        this.stock.add(third);
        this.stock.add(this.product);

        Product[] sorted = {this.product, second, third};

        Iterable<Product> actual = this.stock.findFirstByAlphabeticalOrder(3);
        Iterator<Product> iterator = actual.iterator();

        assertArrayAndIterable(sorted, actual);
    }

    @Test
    public void findAllInPriceRangeShouldReturnEmptyIterableForEmptyStock() {
        Iterable<Product> actual = this.stock.findAllInRange(5, 15);
        Assert.assertFalse(actual.iterator().hasNext());
    }

    @Test
    public void findAllInPriceRangeShouldReturnEmptyIterableIfNoneMatchesThePrice() {
        this.stock.add(this.product);
        Iterable<Product> actual = this.stock.findAllInRange(5, 15);
        Assert.assertFalse(actual.iterator().hasNext());
    }


    @Test
    public void findAllInPriceRangeShouldReturnEmptyIterableForNegativePrices() {
        this.stock.add(this.product);
        Iterable<Product> actual = this.stock.findAllInRange(-5, -15);
        Assert.assertFalse(actual.iterator().hasNext());
    }


    @Test
    public void findAllInPriceRangeShouldReturnECorrectResult() {
        seedStock();

        Iterable<Product> actual = this.stock
                .findAllInRange(DEFAULT_PRODUCT_PRICE -1 , DEFAULT_PRODUCT_PRICE + 1);
        Iterator<Product> iterator = actual.iterator();

        Assert.assertTrue(iterator.hasNext());
        Assert.assertEquals(product, iterator.next());
        Assert.assertFalse(iterator.hasNext());
    }

    @Test
    public void findAllInPriceRangeShouldReturnECorrectResultForHigherBound() {
        seedStock();

        Iterable<Product> actual = this.stock
                .findAllInRange(DEFAULT_PRODUCT_PRICE -1 , DEFAULT_PRODUCT_PRICE);
        Iterator<Product> iterator = actual.iterator();

        Assert.assertTrue(iterator.hasNext());
        Assert.assertEquals(product, iterator.next());
        Assert.assertFalse(iterator.hasNext());
    }

    @Test
    public void findAllInPriceRangeShouldSortCorrectly() {
        seedStock();

        Iterable<Product> actual = this.stock
                .findAllInRange(0 , 30);

        Product[] sorted = {second, third, this.product};

        assertArrayAndIterable(sorted, actual);

    }

    private void assertArrayAndIterable(Product[] sorted, Iterable<Product> actual) {
        Iterator<Product> iterator = actual.iterator();
        Assert.assertTrue(actual.iterator().hasNext());
        int i = 0;
        while (iterator.hasNext()) {
            Assert.assertEquals(sorted[i++], iterator.next());
        }
    }

    private void seedStock() {
        this.stock.add(this.product);
        this.stock.add(this.second);
        this.stock.add(this.third);
    }

    @Test
    public void findAllByPriceRangeShouldReturnECorrectResultForHigherBound() {
        seedStock();

        Iterable<Product> actual = this.stock
                .findAllByPrice(DEFAULT_PRODUCT_PRICE);
        Iterator<Product> iterator = actual.iterator();

        Assert.assertTrue(iterator.hasNext());
        Assert.assertEquals(product, iterator.next());
        Assert.assertFalse(iterator.hasNext());
    }

    @Test
    public void findAllByPriceRangeShouldReturnEmptyForInvalidPrice() {
        seedStock();
        Iterable<Product> actual = this.stock.findAllByPrice(0);

        Assert.assertFalse(actual.iterator().hasNext());

    }
}