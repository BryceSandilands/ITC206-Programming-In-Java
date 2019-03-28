/**
 * TestTriangle
 */
public class TestTriangle {

    public static void main(String[] args) {

        Triangle triangle = new Triangle(3.0, 4.0, 5.0);
        triangle.setColor("yellow");
        triangle.setFilled(true);
        System.out.println(triangle.toString());
    }
}