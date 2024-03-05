// Course.java
package model;
import exception.InvalidScoreException;
import java.io.Serializable;

/**
 * This class represents a course.
 */
public class Course implements Serializable {
    private static final long serialVersionUID = 1L;

    private String name;
    private double percentageGrade;
    private int credits;

    /**
     * Constructs a Course object with the given name, percentage grade, and credits.
     * @param name The name of the course.
     * @param percentageGrade The percentage grade of the course.
     * @param credits The number of credits for the course.
     * requires : name != null && percentageGrade >= 0 && percentageGrade <= 100 && credits >= 1 && credits <= 5
     * modifies : this
     * effects : Initializes a new Course object with the given details.
     */
    public Course(String name, double percentageGrade, int credits) {
        this.name = name;
        this.percentageGrade = percentageGrade;
        this.credits = credits;
        if (percentageGrade < 0 || percentageGrade > 100) {
            throw new InvalidScoreException("Percentage grade must be between 0 and 100.");
        }
        if (percentageGrade < 50) {
            throw new InvalidScoreException("Percentage grade less than 50. Credits will not count.");
        }
    }

    /**
     * Gets the grade points for the course.
     * return : The grade points.
     * requires : None
     * modifies : None
     * effects : Calculates and returns the grade points for the course.
     */
    public double getGradePoints() {
        return percentageGrade / 20.0 * credits;
    }

    /**
     * Gets the credits of the course.
     * return : The credits.
     * requires : None
     * modifies : None
     * effects : Returns the number of credits for the course.
     */
    public int getCredits() {
        return credits;
    }

    /**
     * Gets the name of the course.
     * return : The name of the course.
     * requires : None
     * modifies : None
     * effects : Returns the name of the course.
     */
    public String getName() {
        return name;
    }

    /**
     * Gets the percentage grade of the course.
     * return : The percentage grade.
     * requires : None
     * modifies : None
     * effects : Returns the percentage grade of the course.
     */
    public double getPercentageGrade() {
        return percentageGrade;
    }
}