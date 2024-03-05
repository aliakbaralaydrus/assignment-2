package model;

import java.util.Scanner;

/**
 * This class converts percentage grades to GPA.
 */
public class GPAConverter {
    private double conversionFactor;

    /**
     * Constructs a GPAConverter object with the default conversion factor.
     * 
     * Requires: None.
     * Modifies: None.
     * Effects: Initializes the conversion factor to 4.0 (maximum GPA scale).
     */
    public GPAConverter() {
        this.conversionFactor = 4.0;
    }

    /**
     * Converts a percentage grade to GPA using the current conversion factor.
     * 
     * Requires: A valid percentage grade (percentageGrade >= 0).
     * Modifies: None.
     * Effects: Calculates and returns the equivalent GPA, capped at 4.0.
     * 
     * @param percentageGrade The percentage grade to be converted.
     * @return The equivalent GPA, capped at 4.0.
     */
    public double convertToGPA(double percentageGrade) {
        double gpa = (percentageGrade / 100.0) * conversionFactor;
        return Math.min(Math.round(gpa * 100.0) / 100.0, 4.0); // Cap GPA at 4.0 and round to two decimal places
    }

    /**
     * Allows the user to update the conversion factor.
     * 
     * Requires: None.
     * Modifies: Updates the conversion factor if the new factor is valid.
     * Effects: Prints a message indicating whether the update was successful or not.
     */
    public void updateConversionFactor() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter the new conversion factor: ");
        double newFactor = scanner.nextDouble();
        if (newFactor > 0) {
            this.conversionFactor = newFactor;
            System.out.println("Conversion factor updated successfully.");
        } else {
            System.out.println("Invalid conversion factor. Please enter a positive number.");
        }
    }
}
