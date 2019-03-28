
/**
 * Subject Class
 */
import java.util.ArrayList;
import java.util.Collections;

public class Subject {
    /** Properties */
    private String subjectName;
    private String subjectCode;

    Subject(String subjectName, String subjectCode) {
        this.subjectName = subjectName;
        this.subjectCode = subjectCode;
        isValidCode(subjectCode);
    }

    /** Static Methods */
    /**
     * Validates input when creating object, if input is not valid the object will
     * not be created and will throw & catch an IllegalArgumentException, and
     * display a message to the user
     */
    private static void isValidCode(String subjectCode) {
        try {
            if (subjectCode.length() != 6) {
                throw new IllegalArgumentException();
            }
            for (int i = 0; i < subjectCode.length(); i++) {
                if (!(Character.isLetter(subjectCode.charAt(i))) && i < 3) {
                    throw new IllegalArgumentException();2
                } else if (!(Character.isDigit(subjectCode.charAt(i))) && i >= 3) {
                    throw new IllegalArgumentException();
                }
            }
        } catch (IllegalArgumentException e) {
            System.out.println("Subject code must contain 6 characters, 3 alphabetic, followed by 3 numeric");
        }
    }

    /**
     * allDisciplines takes a list and returns a new list containing only unique
     * strings from arugment list
     */
    public static ArrayList<String> allDisciplines(ArrayList<Subject> subjects) {
        ArrayList<String> sortedList = new ArrayList<String>();
        for (int i = 0; i < subjects.size(); i++) {
            String discipline = subjects.get(i).getDiscipline();
            if (!sortedList.contains(discipline)) {
                sortedList.add(discipline);
            }
        }
        Collections.sort(sortedList);
        return sortedList;
    }

    /**
     * codesPerDiscipline takes a list and a code, adds the code to a new list
     * providing it matches the code passed in and isnt already in the list
     */
    public static ArrayList<String> codesPerDiscipline(ArrayList<Subject> subjects, String disciplineCode) {
        ArrayList<String> codesList = new ArrayList<String>();
        for (int i = 0; i < subjects.size(); i++) {
            String discipline = subjects.get(i).getDiscipline();
            if (discipline.equals(disciplineCode) && !codesList.contains(discipline)) {
                codesList.add(subjects.get(i).getSubjectCode());
            }
        }
        return codesList;
    }

    /**
     * codeExists takes a list and a code, returns true if the code passed in
     * matches a code in the list, else returns false
     */
    public static boolean codeExists(ArrayList<Subject> subjects, String subjectCode) {
        for (int i = 0; i < subjects.size(); i++) {
            if (subjects.get(i).codeMatches(subjectCode)) {
                return true;
            }
        }
        return false;
    }

    /**
     * sortDisciplines takes an array, creates a new list of subjects & a new list
     * of strings representing disciplineCodes. the new string list is sorted and
     * iterated over, checking if current string matches string in subjects array
     * passed in and adds that subject to new string array in order.
     */
    public static ArrayList<Subject> sortDisciplines(ArrayList<Subject> subjects) {
        ArrayList<Subject> sortedSubjects = new ArrayList<>(subjects);
        ArrayList<String> sortedSubjectCodes = new ArrayList<>();
        for (int i = 0; i < subjects.size(); i++) {
            sortedSubjectCodes.add(i, subjects.get(i).getSubjectCode());
        }
        Collections.sort(sortedSubjectCodes);

        for (int i = 0; i < sortedSubjectCodes.size(); i++) {
            for (int j = 1; j < i; j++) {
                if (sortedSubjectCodes.get(i).equals(subjects.get(j).getSubjectCode())) {
                    sortedSubjects.add(i, subjects.get(j));
                }
            }
        }
        return sortedSubjects;
    }

    /** Accessor Methods */
    public String getSubjectName() {
        return subjectName;
    }

    public String getSubjectCode() {
        return subjectCode;
    }

    public String getDiscipline() {
        return subjectCode.substring(0, 3);
    }

    public String getDisciplineCode() {
        return subjectCode.substring(3);
    }

    public boolean codeMatches(String code) {
        return subjectCode.equals(code);
    }

    public String toString() {
        return (subjectCode + " " + subjectName);
    }
}