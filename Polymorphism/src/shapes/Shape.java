package shapes;

public abstract class Shape {
    private double perimeter;
    private double area;

    public double getPerimeter() {
        return this.calculatePerimeter();
    }

    public double getArea() {
        return this.calculateArea();
    }

    abstract public double calculatePerimeter();
    abstract public double calculateArea();
}
