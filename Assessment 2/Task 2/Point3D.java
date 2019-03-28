/**
 * Point3D Class containing all the methods for Task 2 in Assessment 2
 */
public class Point3D {

    // Private properties
    private double x;
    private double y;
    private double z;
    private String color;

    Point3D() { // Default constructor
        x = 0;
        y = 0;
        z = 0;
        color = "Red";
    }

    Point3D(double x, double y, double z, String color) { // Specified value constructor
        this.x = x;
        this.y = y;
        this.z = z;
        this.color = color;
    }

    // Return private properties
    public double getX() {
        return x;
    }

    public double getY() {
        return y;
    }

    public double getZ() {
        return z;
    }

    public String getColor() {
        return color;
    }

    public double distance(Point3D point) { // Return distance from specified point from default point
        double pointX = Math.pow((point.x - this.x), 2);
        double pointY = Math.pow((point.y - this.y), 2);
        double pointZ = Math.pow((point.z - this.z), 2);
        return Math.sqrt(pointX + pointY + pointZ);
    }

    public double distance(double x, double y, double z) { // Return distance from specified values from default values
        double pointX = Math.pow((x - this.x), 2);
        double pointY = Math.pow((y - this.y), 2);
        double pointZ = Math.pow((z - this.z), 2);
        return Math.sqrt(pointX + pointY + pointZ);
    }
}