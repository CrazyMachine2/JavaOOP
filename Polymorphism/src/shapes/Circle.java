package shapes;

public class Circle extends Shape{
    private double radius;

    public Circle(double radius) {
        this.radius = radius;
    }

    public final double  getRadius() {
        return this.radius;
    }

    @Override
    public double calculatePerimeter() {
        return 2 *  Math.PI * this.radius;
    }

    @Override
    public double calculateArea() {
        return Math.PI * this.radius * this.radius;
    }
}
