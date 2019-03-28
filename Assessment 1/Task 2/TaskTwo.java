import java.util.Scanner;

public class TaskTwo {
    // Main function
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        // Initialize local variables
        int numberOfChildren = 0;
        int numberOfAdults = 0;
        int numberOfSeniors = 0;
        int totalCost = 0;

        // Get user input to determine if another group needs to be added
        System.out.print("Enter a group? (Yes = 1 / No = 0): ");
        int enterNewGroup = input.nextInt();

        // While loop to continue asking user if more groups are needed
        while (enterNewGroup != 0) {
            // Get user input for the number of children, adults & seniors per group
            System.out.print("Enter the number of children (age 6–15): ");
            numberOfChildren = input.nextInt();
            System.out.print("Enter the number of adults (age 16–59): ");
            numberOfAdults = input.nextInt();
            System.out.print("Enter the number of seniors (age 60+): ");
            numberOfSeniors = input.nextInt();

            // Calculate & display the costOfGroup, and add it to the totalCost variable
            int costOfGroup = calculateTotalCost(numberOfChildren, numberOfAdults, numberOfSeniors);
            System.out.println("Total Entry Charge is $" + costOfGroup);
            System.out.println();

            totalCost += costOfGroup;

            // Check if the user wants to add another group
            System.out.print("Enter a group? (Yes = 1 / No = 0): ");
            enterNewGroup = input.nextInt();
        }

        // Display the total cost for all groups
        System.out.print("Total takings: $" + totalCost);
        input.close();

    }

    /*
     * calculateTotalCost takes the number of accompanied-children,
     * unaccompanied-children, adults & seniors and calculates the total cost.
     */
    public static int calculateTotalCost(int children, int adults, int seniors) {
        int accompanyingAdults = adults + seniors;
        int accompaniedChildren = (children > accompanyingAdults) ? accompanyingAdults : children;
        int unaccompaniedChildren = (children <= accompanyingAdults) ? 0 : (children - accompanyingAdults);

        accompaniedChildren *= 2;
        unaccompaniedChildren *= 5;
        adults *= 10;
        seniors *= 8;

        int total = accompaniedChildren + unaccompaniedChildren + adults + seniors;
        return total;
    }
}
