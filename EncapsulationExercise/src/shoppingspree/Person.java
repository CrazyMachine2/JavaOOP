package shoppingspree;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Person {
    private String name;
    private double money;
    private List<Product> products;

    public Person(String name, double money) {
        this.setName(name);
        this.setMoney(money);
        this.products = new ArrayList<>();
    }

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        if (name == null || name.trim().isEmpty()){
            throw new IllegalArgumentException("Name cannot be empty");
        }
        this.name = name;
    }

    public double getMoney() {
        return this.money;
    }

    public void setMoney(double money) {
        if (money < 0){
            throw new IllegalArgumentException("Money cannot be negative");
        }
        this.money = money;
    }

    public List<Product> getProducts() {
        return Collections.unmodifiableList(this.products);
    }

    public void buyProduct(Product product){
        if (this.getMoney() < product.getCost()){
            System.out.printf("%s can't afford %s%n",this.getName(),product.getName());
        } else {
            this.products.add(product);
            this.setMoney(this.money - product.getCost());
            System.out.printf("%s bought %s%n",this.getName(),product.getName());
        }
    }
}
