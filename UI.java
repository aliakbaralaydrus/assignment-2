// UI.java
package ui;
import model.Student;
import model.Course;

/**
 * This class manages the user interface of the GPA calculator application.
 * It provides methods for displaying GPA and courses.
 */
public class UI {
    /**
     * Displays the GPA of a student.
     * param : gpa The GPA to be displayed.
     * requires : None
     * modifies : None
     * effects : Prints the GPA to the console.
     */
    public void displayGPA(double gpa) {
        System.out.println("GPA: " + gpa);
    }

    /**
     * Displays the list of courses taken by a student.
     * param : student The student whose courses are to be displayed.
     * requires : None
     * modifies : None
     * effects : Prints the list of courses to the console.
     */
    public void displayCourses(Student student) {
        System.out.println("Courses:");
        for (Course course : student.getCourses()) {
            System.out.println(course.getName() + " - Grade: " + course.getPercentageGrade() + ", Credits: " + course.getCredits());
        }
    }
}
