/*
 * ProcessMarks
 * Class containing all the methods for Task 1 in Assessment 2
 */
public class ProcessMarks {

    public static int min(int[] array) { // Find & return the minimum int value of an array
        int min = array[0];
        for (int i = 1; i < array.length; i++) {
            if (array[i] < min) {
                min = array[i];
            }
        }
        return min;
    }

    public static int max(int[] array) { // Find & return the maximum int value of an array
        int max = array[0];
        for (int i = 1; i < array.length; i++) {
            if (array[i] > max) {
                max = array[i];
            }
        }
        return max;
    }

    public static int range(int[] array) { // Find & return the range of an array
        return max(array) - min(array);
    }

    public static double mean(int[] array) { // Find & return the mean of an array
        double mean = 0;
        for (double e : array) {
            mean += e;
        }
        return mean /= array.length;
    }

    public static double median(int[] array) { // Find & return the median of an array
        int[] newArray = selectionSort(array); // Create & sort a new array to leave original array unsorted
        if (array.length % 2 == 0) {
            // If array is even return the average of middle two numbers
            return ((double) newArray[newArray.length / 2] + (double) newArray[newArray.length / 2 - 1]) / 2;
        } else {
            // If array is odd return the middle number
            return (double) newArray[newArray.length / 2];
        }
    }

    public static int mode(int[] array) { // Find and return the mode of an array
        int[] modeArray = selectionSort(array); // Create & sort a new array to leave original array unsorted
        int currentModeNum = modeArray[0];
        int lastModeNum = currentModeNum;
        int occurances = 1;
        int maxOccurances = 1;

        for (int i = 1; i < modeArray.length; i++) { // Iterate through array, if i = i - 1, add to occurances
            if (modeArray[i] == lastModeNum) {
                occurances++;
            } else {
                occurances = 1;
                lastModeNum = modeArray[i]; // If the number is different restart occurances & lastModeNum
            }
            if (occurances > maxOccurances) { // If occurances > maxOccurances restart maxOccurances & currentModeNum
                maxOccurances = occurances;
                currentModeNum = lastModeNum;
            }
        }
        return currentModeNum;
    }

    public static char[] grades(int[] marks, int[] boundaries) {
        char[] grades = new char[marks.length]; // Sort marks array into a new grades array of char's & return

        for (int i = 0; i < marks.length; i++) {
            if (marks[i] >= boundaries[0]) {
                grades[i] = 'A';
            } else if (marks[i] >= boundaries[1]) {
                grades[i] = 'B';
            } else if (marks[i] >= boundaries[2]) {
                grades[i] = 'C';
            } else if (marks[i] >= boundaries[3]) {
                grades[i] = 'D';
            } else if (marks[i] >= boundaries[4]) {
                grades[i] = 'E';
            } else {
                grades[i] = 'F';
            }
        }
        return grades;
    }

    public static int[] gradeDistn(char[] array) { // Process grades array, count number of each grade & return array
        int[] gradeCount = new int[6];
        for (int i = 0; i < array.length; i++) {
            switch (array[i]) {
            case 'A':
                gradeCount[0]++;
                break;
            case 'B':
                gradeCount[1]++;
                break;
            case 'C':
                gradeCount[2]++;
                break;
            case 'D':
                gradeCount[3]++;
                break;
            case 'E':
                gradeCount[4]++;
                break;
            default:
                gradeCount[5]++;
            }
        }
        return gradeCount;
    }

    public static int[] selectionSort(int[] array) { // Selection sort
        int[] newArray = array.clone();

        for (int i = 0; i < newArray.length - 1; i++) {
            int currentMin = i;

            for (int j = i + 1; j < newArray.length; j++) {
                if (newArray[j] < newArray[currentMin])
                    currentMin = j;
            }

            int temp = newArray[currentMin];
            newArray[currentMin] = newArray[i];
            newArray[i] = temp;
        }
        return newArray;
    }
}
