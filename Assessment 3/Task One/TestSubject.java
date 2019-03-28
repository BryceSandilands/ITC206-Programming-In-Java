
/**
 * TestSubject
 */
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public class TestSubject {
    public static void main(String[] args) throws IOException {

        /** File properties */
        File file = new java.io.File("Subjects.txt");
        /** File exists is used so it is not overwritten when opened */
        FileWriter finalWrite = new FileWriter(file, file.exists());
        Scanner fileIn = new Scanner(file);
        Scanner userInput = new Scanner(System.in);

        /** New list to hold all the subjects before writing to a file. */
        ArrayList<Subject> subjects = new ArrayList<Subject>();

        /** Creates and adds new subject to subjects list from each line in the file. */
        readFromFileToList(fileIn, subjects);

        /** Get user input */
        System.out.print("Would you like to add subjects to your list? (y/n): ");
        String addSubject = userInput.next();

        /** While loop continues untill user input is "n" */
        while (!"n".equals(addSubject)) {
            // If user input is "y" the program gets run, and ask user for another subject
            if ("y".equals(addSubject)) {
                /** Run method contains all of the program logic */
                run(subjects, userInput, file, finalWrite, addSubject);
                System.out.println();
                System.out.print("Would you like to add another subject? (y/n): ");
                addSubject = userInput.next();
            } else {
                /** User input is invalid, loop continues untill valid input is received */
                System.out.print("Please enter a valid input (y/n): ");
                addSubject = userInput.next();
            }
        }
        /** Sorts the list and displays list to user */
        endProgramAndDisplayList(subjects);

        /** Close all IO variables */
        fileIn.close();
        userInput.close();
    }

    /**
     * All of the main logic methods of the program are incorporated into one method
     * to keep main method clean when starting the program over
     */
    public static void run(ArrayList<Subject> subjects, Scanner userInput, File file, FileWriter finalWrite,
            String addSubject) {
        displayDisciplines(subjects);
        String discipline = getDisciplineFromUser(userInput);
        displayCodesForDiscipline(subjects, discipline);
        String disciplineCode = getDisciplineCodeFromUser(userInput, subjects, discipline);
        String subjectName = getNameOfSubjectFromUser(userInput);
        addSubject(discipline, disciplineCode, subjectName, subjects, file);
        writeToFile(subjects, file, finalWrite);
    }

    /**
     * endProgramAndDisplayList creates, sorts & displays a new version of the list
     */
    public static void endProgramAndDisplayList(ArrayList<Subject> subjects) {
        if (subjects.size() > 0) {
            ArrayList<Subject> subjectList = Subject.sortDisciplines(subjects);
            System.out.println();
            System.out.println("Thank you!, your list is as follows:");
            for (Subject subject : subjectList) {
                System.out.println(subject.toString());
            }
        } else {
            System.out.println("Thank you!, your list is empty");
        }
    }

    /**
     * readFromFileToList reads each line from file. Creates a new Subject and adds
     * to the list
     */
    public static void readFromFileToList(Scanner fileIn, ArrayList<Subject> subjects) {
        while (fileIn.hasNext()) {
            String line = fileIn.nextLine();
            String subjectCode = line.substring(0, 6);
            String subjectName = line.substring(7, line.length());
            Subject subject = new Subject(subjectName, subjectCode);
            subjects.add(subject);
        }
    }

    /** displayDisciplines displays a new list of sorted, unique disciplines */
    public static void displayDisciplines(ArrayList<Subject> subjects) {
        if (!(subjects.size() > 0)) {
            System.out.println();
            System.out.println("There are no subjects in your list");
        } else {
            System.out.println();
            System.out.println("Your current disciplines are as follows: ");
        }
        /** Sort & return alphabetical unique disciplines */
        ArrayList<String> disciplines = Subject.allDisciplines(subjects);
        for (String discipline : disciplines) {
            System.out.println(discipline);
        }
    }

    /**
     * getDisciplineFromUser gets input from user, validates input and returns in
     * uppercase form
     */
    public static String getDisciplineFromUser(Scanner userInput) {
        System.out.print("Please enter the three alphabetical characters for the discipline you wish to add: ");
        String discipline = userInput.next().toUpperCase();
        while (!disciplineIsValid(discipline)) {
            System.out.print("Please re-enter discipline as three alphabetical characters: ");
            discipline = userInput.next().toUpperCase();
        }
        return discipline;
    }

    /**
     * displayCodesForDiscipline checks a list for a disciplieCode, adds to new list
     * containing only unique codes & displays the new unique list
     */
    public static void displayCodesForDiscipline(ArrayList<Subject> subjects, String disciplineCode) {
        ArrayList<String> codes = Subject.codesPerDiscipline(subjects, disciplineCode);
        if (codes.size() == 0) {
            System.out.println();
            System.out.println("There are no existing subject codes in your list for that discipline: ");
        } else {
            System.out.println();
            System.out.println("The existing subject codes for your chosen discipline are as follows: ");
            for (String code : codes) {
                System.out.println(code);
            }
        }
    }

    /**
     * getDisciplineCodeFromUser gets user input for subject code, checks its valid,
     * checks subject & discipline codes dont exist in a list & returns value if not
     */
    public static String getDisciplineCodeFromUser(Scanner userInput, ArrayList<Subject> subjects, String discipline) {
        System.out.print("Please enter the three numerical characters for the subject code: ");
        String disciplineCode = userInput.next().toUpperCase();
        boolean codeExists = Subject.codeExists(subjects, discipline + disciplineCode);
        while (!subjectIsValid(disciplineCode) || codeExists) {
            if (codeExists) {
                System.out.print("Code already exists, please re-enter the subject code: ");
                disciplineCode = userInput.next().toUpperCase();
                codeExists = Subject.codeExists(subjects, discipline + disciplineCode);
            } else {
                System.out.print("Please re-enter a valid three numerical subject code: ");
                disciplineCode = userInput.next().toUpperCase();
            }
        }
        return disciplineCode;
    }

    /** getNameOfSubjectFromUser gets and returns subject name from user */
    public static String getNameOfSubjectFromUser(Scanner userInput) {
        System.out.println();
        System.out.print("Please enter the the name of the subject: ");
        userInput.nextLine();
        String subjectName = userInput.nextLine();
        return subjectName;
    }

    /** addSubject creaes and adds a new subject to the main list */
    public static void addSubject(String discipline, String disciplineCode, String subjectName,
            ArrayList<Subject> subjects, File file) {
        String subjectCode = discipline + disciplineCode;
        Subject newSubject = new Subject(subjectName, subjectCode);
        subjects.add(newSubject);
    }

    /**
     * writeToFile checks to see if file exists in array before writing to external
     * file, catches IOException and displays error message to user
     */
    public static void writeToFile(ArrayList<Subject> subjects, File file, FileWriter finalWrite) {
        try {
            /** false is passed in to force the file to be overwritten */
            finalWrite = new FileWriter(file, false);
            if (subjects.size() > 0) {
                for (int i = 0; i < subjects.size(); i++) {
                    if (!subjects.get(i).codeMatches(subjects.get(i).toString())) {
                        finalWrite.write(subjects.get(i).toString() + "\n");
                    }
                }
            }
            finalWrite.close();
        } catch (IOException e) {
            System.out.println();
            System.out.println("There was an error  while trying to write to file: ");
        }
    }

    /** disciplineIsValid checks discipline is valid and returns true if so */
    public static boolean disciplineIsValid(String discipline) {
        if (discipline.length() != 3) {
            return false;
        }
        for (int i = 0; i < discipline.length(); i++) {
            if (!(Character.isLetter(discipline.charAt(i)))) {
                return false;
            }
        }
        return true;
    }

    /** subjectIsValid checks subject is valid and returns true if so */
    public static boolean subjectIsValid(String subject) {
        if (subject.length() != 3) {
            return false;
        }
        for (int i = 0; i < subject.length(); i++) {
            if (!(Character.isDigit(subject.charAt(i)))) {
                return false;
            }
        }
        return true;
    }
}