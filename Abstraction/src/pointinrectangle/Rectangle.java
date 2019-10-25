package pointinrectangle;

public class Rectangle {
    private Point bottomLeft;
    private Point topRight;

    public Rectangle(Point topLeft, Point bottomRight) {
        this.bottomLeft = topLeft;
        this.topRight = bottomRight;
    }

    public Point getBottomLeft() {
        return bottomLeft;
    }

    public void setBottomLeft(Point bottomLeft) {
        this.bottomLeft = bottomLeft;
    }

    public Point getTopRight() {
        return topRight;
    }

    public void setTopRight(Point topRight) {
        this.topRight = topRight;
    }

    public boolean contains(Point point) {
       boolean containsOnX = point.getX() >= this.bottomLeft.getX() &&
               point.getX() <= this.topRight.getX();

       boolean containsOnY = point.getY() >= this.bottomLeft.getY() &&
               point.getY() <= this.topRight.getY();

       return containsOnX && containsOnY;
    }
}
