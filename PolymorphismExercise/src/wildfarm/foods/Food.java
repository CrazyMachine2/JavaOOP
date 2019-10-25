package wildfarm.foods;

public abstract class Food {
    private Integer quantity;

    public Food(int quantity) {
        this.quantity = quantity;
    }

    public Integer getQuantity() {
        return this.quantity;
    }
}
