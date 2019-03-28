/*
 * TestProcessMarks
 * A Class containing all the functionalilty to test the ProcessMarks class
 */
public class TestProcessMarks {

    public static void main(String[] args) {
        int[] boundaries = { 90, 75, 60, 50, 45 }; // Create boundaries array

        int[] marks = Marks.getMarks(); // Create & display marks array
        printArray(marks, "Marks");

        printDetails(marks); // Display Min, Max, Range, Mean, Median & Mode

        char[] grades = ProcessMarks.grades(marks, boundaries); // Create & display grades array
        printArray(grades, "Grades");

        int[] gradeDist = ProcessMarks.gradeDistn(grades); // Create & display grades distribution array
        printDistributions(gradeDist);
    }

    public static void printDetails(int[] marks) { // Create a method to print min, max, range etc
        System.out.println("\n\nMinimum Mark: " + ProcessMarks.min(marks));
        System.out.println("Maximum Mark: " + ProcessMarks.max(marks));
        System.out.println("Range of Marks: " + ProcessMarks.range(marks));
        System.out.println("Mean: " + ProcessMarks.mean(marks));
        System.out.println("Median: " + ProcessMarks.median(marks));
        System.out.println("Mode: " + ProcessMarks.mode(marks));
    }

    public static void printArray(char[] array, String title) { // Create a method to print char array
        System.out.println("\n" + title + ": ");

        for (int i = 0; i < array.length; i++) { // Display 30 results per line
            if ((i + 1) % 30 == 0) {
                System.out.println(array[i]);
            } else {
                System.out.print(array[i] + " ");
            }
        }
    }

    public static void printArray(int[] array, String title) { // Overload array with int[] signature
        System.out.println("\n" + title + ": ");

        for (int i = 0; i < array.length; i++) { // Display 30 results per line
            if ((i + 1) % 30 == 0) {
                System.out.println(array[i]);
            } else {
                System.out.print(array[i] + " ");
            }
        }
    }

    public static void printDistributions(int[] gradeDist) { // Create method to display the number of each grade
        System.out.println("\n\nDistributions: \nA: " + gradeDist[0] + "\nB: " + gradeDist[1] + "\nC: " + gradeDist[2]
                + "\nD: " + gradeDist[3] + "\nE: " + gradeDist[4] + "\nF: " + gradeDist[5]);
    }
}