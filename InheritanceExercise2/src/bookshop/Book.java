package bookshop;

import java.text.DecimalFormat;

public class Book {
    private String author;
    private String title;
    private double price;

    public Book(String author, String title, double price) {
        this.setAuthor(author);
        this.setTitle(title);
        this.setPrice(price);
    }

    private void setTitle(String title) {
        if(title.length() < 3){
            throw new IllegalArgumentException("Title not valid!");
        }
        this.title = title;
    }

    public String getTitle() {
        return this.title;
    }

    private void setAuthor(String author) {
        if (author.contains(" ") && Character.isDigit(author.charAt(author.lastIndexOf(" ") + 1))) {
            throw new IllegalArgumentException("Author not valid!");
        }
        this.author = author;
    }

    public String getAuthor() {
        return this.author;
    }

    private void setPrice(double price) {
        if(price < 0){
            throw new IllegalArgumentException("Price not valid!");
        }
        this.price = price;
    }

    public double getPrice() {
        return this.price;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();

        sb.append("Type: ").append(this.getClass().getSimpleName()).append(System.lineSeparator());
        sb.append("Title: ").append(this.getTitle()).append(System.lineSeparator());
        sb.append("Author: ").append(this.getAuthor()).append(System.lineSeparator());
        sb.append("Price: ").append(this.getPrice()).append(System.lineSeparator());

        return sb.toString();
    }
}




















