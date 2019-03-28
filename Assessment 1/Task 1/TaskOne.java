import java.util.Scanner;

public class TaskOne {
    // Main method
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        // Get filing status & income from user.
        System.out.print("Enter the filing status: ");
        int filingStatus = input.nextInt();
        System.out.print("Enter the taxable income: ");
        double taxableIncome = input.nextDouble();

        // Initialize totalTaxAmount to hold the tax value
        double totalTaxAmount = 0;

        // Switch on filingStatus to determine which marginal tax rate is needed.
        switch (filingStatus) {
        case 0:
            totalTaxAmount = determineTax(taxableIncome, 8350, 33950, 82250, 171550, 372950);
            break;
        case 1:
            totalTaxAmount = determineTax(taxableIncome, 16700, 67900, 137050, 208850, 372950);
            break;
        case 2:
            totalTaxAmount = determineTax(taxableIncome, 8350, 33950, 68525, 104425, 186475);
            break;
        case 3:
            totalTaxAmount = determineTax(taxableIncome, 11950, 45500, 117450, 190200, 372950);
            break;
        default:
            System.out.println("Please enter a number between 0 - 3");
            break;
        }
        // Display the totalTaxAmount & close the Scanner object
        System.out.println("Tax is: " + totalTaxAmount);
        input.close();
    }

    /*
     * determineTax method calculates & returns the total tax amount using the <=
     * upperBoundary of each tax bracket in ascending order.
     */
    public static double determineTax(double income, int upperBoundaryOne, int upperBoundaryTwo, int upperBoundaryThree,
            int upperBoundaryFour, int upperBoundaryFive) {

        double tax = 0;
        if (income <= upperBoundaryOne) {
            tax = income * 0.10;
        } else if (income <= upperBoundaryTwo) {
            tax = upperBoundaryOne * 0.10 + (income - upperBoundaryOne) * 0.15;
        } else if (income <= upperBoundaryThree) {
            tax = upperBoundaryOne * 0.10 + (upperBoundaryTwo - upperBoundaryOne) * 0.15
                    + (income - upperBoundaryTwo) * 0.25;
        } else if (income <= upperBoundaryFour) {
            tax = upperBoundaryOne * 0.10 + (upperBoundaryTwo - upperBoundaryOne) * 0.15
                    + (upperBoundaryThree - upperBoundaryTwo) * 0.25 + (income - upperBoundaryThree) * 0.28;
        } else if (income <= upperBoundaryFive) {
            tax = upperBoundaryOne * 0.10 + (upperBoundaryTwo - upperBoundaryOne) * 0.15
                    + (upperBoundaryThree - upperBoundaryTwo) * 0.25 + (upperBoundaryFour - upperBoundaryThree) * 0.28
                    + (income - upperBoundaryFour) * 0.33;
        } else {
            tax = upperBoundaryOne * 0.10 + (upperBoundaryTwo - upperBoundaryOne) * 0.15
                    + (upperBoundaryThree - upperBoundaryTwo) * 0.25 + (upperBoundaryFour - upperBoundaryThree) * 0.28
                    + (upperBoundaryFive - upperBoundaryFour) * 0.33 + (income - upperBoundaryFive) * 0.35;
        }
        return tax;
    }
}