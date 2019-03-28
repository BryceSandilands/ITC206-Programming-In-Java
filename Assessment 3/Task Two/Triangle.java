/**
 * Triangle
 */
public class Triangle extends GeometricObject {

    /** Private properties */
    private double side1 = 1.0;
    private double side2 = 1.0;
    private double side3 = 1.0;

    /** Constructors */
    Triangle() {
        super();
    }

    Triangle(double side1, double side2, double side3) {
        super();
        this.side1 = side1;
        this.side2 = side2;
        this.side3 = side3;
    }

    /** Accessor methods */
    public double getSide1() { /** Returns side1 */
        return side1;
    }

    public double getSide2() { /** Returns side2 */
        return side2;
    }

    public double getSide3() { /** Returns side3 */
        return side3;
    }

    public String toString() { /** Displays area, perimeter, color & isFilled status */
        return ("The area is: " + getArea() + "\nThe perimeter is: " + getPerimeter() + "\nThe color is: " + getColor()
                + "\nThe triangle is filled: " + isFilled());
    }

    // Overidden abstract methods
    @Override
    public double getArea() { /** Returns area of triangle */
        double sides = (side1 + side2 + side3) / 2;
        double area = Math.sqrt((sides * (sides - side1)) * (sides * (sides - side2)) * (sides * (sides - side3)));
        return area;
    }

    @Override
    public double getPerimeter() { /** Returns perimeter of triangle */
        return (side1 + side2 + side3);
    }

}
