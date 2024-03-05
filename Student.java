// Student.java
package model;
import exception.InvalidScoreException;
import java.util.ArrayList;
import java.util.List;
import java.io.Serializable;

/**
 * This class represents a student and their enrolled courses.
 */
public class Student implements Serializable {
    private static final long serialVersionUID = 1L;

    private String name;
    private String id;
    private List<Course> courses;
    private List<String> lowGradesCourses;

    /**
     * Constructs a Student object with the given name and ID.
     * param : name The name of the student.
     * param : id The ID of the student.
     * requires : name != null && id != null
     * modifies : this
     * effects : Initializes a new Student object with the given name and ID.
     */
    public Student(String name, String id) {
        this.name = name;
        this.id = id;
        this.courses = new ArrayList<>();
        this.lowGradesCourses = new ArrayList<>();
    }

    /**
     * Adds a new course to the student's list of courses.
     * param : name The name of the course.
     * param : percentageGrade The percentage grade of the course.
     * param : credits The number of credits for the course.
     * requires : name != null && percentageGrade >= 0 && percentageGrade <= 100 && credits >= 1 && credits <= 5
     * modifies : this
     * effects : Creates a new Course object with the given details and adds it to the student's list of courses.
     */
    public void addCourse(String name, double percentageGrade, int credits) {
        try {
            Course course = new Course(name, percentageGrade, credits);
            courses.add(course);
        } catch (InvalidScoreException e) {
            lowGradesCourses.add(name);
        }
    }

    /**
     * Gets the list of courses taken by the student.
     * return : The list of courses.
     * requires : None
     * modifies : None
     * effects : Returns the list of courses taken by the student.
     */
    public List<Course> getCourses() {
        return courses;
    }

    /**
     * Calculates the GPA of the student.
     * return : The GPA of the student.
     * requires : None
     * modifies : None
     * effects : Calculates and returns the GPA of the student based on their enrolled courses.
     */
    public double calculateGPA() {
        double totalGradePoints = 0;
        int totalCredits = 0;

        for (Course course : courses) {
            totalGradePoints += course.getGradePoints();
            totalCredits += course.getCredits();
        }

        return totalCredits == 0 ? 0 : totalGradePoints / totalCredits;
    }

    /**
     * Gets the list of courses with low grades.
     * return : The list of courses with low grades.
     * requires : None
     * modifies : None
     * effects : Returns the list of courses with grades less than 50.
     */
    public List<String> getLowGradesCourses() {
        return lowGradesCourses;
    }
}
