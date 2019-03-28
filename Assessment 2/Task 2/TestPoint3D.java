/*
 * TestPoint3D
 * A Class containing all the functionalilty to test the Point3D class
 */
public class TestPoint3D {
    public static void main(String[] args) {
        /** Create new array of 10 Point3D's */
        Point3D[] pointArray = getPointArray(10);

        /** Display results */
        display(pointArray);
        max(pointArray);
        min(pointArray);

    }

    /** Static method to return an array of Point3D with random values */
    public static Point3D[] getPointArray(int numOfPoints) {
        Point3D[] points = new Point3D[numOfPoints];
        points[0] = new Point3D(0, 0, 0, "Red"); // First value in array is default Point3D object

        for (int i = 1; i < numOfPoints; i++) {
            Point3D point = new Point3D(getRandomNumber(10), getRandomNumber(10), getRandomNumber(10), getColor(i - 1));
            points[i] = point;
        }
        return points;
    }

    /**
     * Static method to calculate and display the maximum distance between the
     * points in the array, and the pair of points for which the maximum occurs.
     */
    public static void max(Point3D[] array) {
        Point3D pointOne = array[0];
        Point3D pointTwo = array[1];
        double maximumDistance = array[0].distance(array[1]);

        for (int i = 0; i < array.length; i++) {
            for (int j = 1; j < array.length; j++) {
                double distance = array[i].distance(array[j]);
                if (i == j) {
                    continue;
                } else if (distance > maximumDistance) {
                    maximumDistance = distance;
                    pointOne = array[i];
                    pointTwo = array[j];
                }
            }
        }
        System.out.println("\nMaximum distance occurs between the " + pointOne.getColor() + " point and the "
                + pointTwo.getColor() + " point");
        System.out.println("The distance between the points " + pointOne.getColor() + " & " + pointTwo.getColor()
                + " is: " + pointOne.distance(pointTwo));
    }

    /**
     * Static method to calculate and display the minimum distance between the
     * points in the array, and the pair of points for which the minimum occurs.
     */
    public static void min(Point3D[] array) {
        Point3D pointOne = array[0];
        Point3D pointTw0 = array[1];
        double minimumDistance = array[0].distance(array[1]);

        for (int i = 0; i < array.length; i++) {
            for (int j = 1; j < array.length; j++) {
                double distance = array[i].distance(array[j]);
                if (i == j) {
                    continue;
                } else if (distance < minimumDistance) {
                    minimumDistance = distance;
                    pointOne = array[i];
                    pointTw0 = array[j];
                }
            }
        }
        System.out.println("\nMinimum distance occurs between the " + pointOne.getColor() + " point and the "
                + pointTw0.getColor() + " point");
        System.out.println("The distance between the points " + pointOne.getColor() + " & " + pointTw0.getColor()
                + " is: " + minimumDistance);

    }

    /** Static method to display contents of array */
    public static void display(Point3D[] array) {
        // Display contents of array
        for (int i = 0; i < array.length; i++) {
            System.out.println(array[i].getColor() + " Point: (" + array[i].getX() + ", " + array[i].getY() + ", "
                    + array[i].getZ() + ")");
        }
    }

    /** Static method to get a random number of specified integers (inclusive) */
    public static double getRandomNumber(int limit) {
        return (Math.random() * limit) + 1;
    }

    /** Static method to return a given color in an array */
    public static String getColor(int number) {
        String[] colors = { "Aqua", "Cyan", "Emerald", "Magenta", "Turquoise", "Orange", "Olive", "Yellow", "Onyx" };

        return colors[number];
    }
}
