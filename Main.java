import model.Student;
import ui.UI;
import persistence.FileHandler;
import exception.InvalidPercentageGradeException;
import exception.InvalidCreditsException;
import java.io.File;
import java.util.Scanner;

public class Main {
    private static final String FILENAME = "student.ser";

    public static void main(String[] args) {
        UI ui = new UI();
        Scanner scanner = new Scanner(System.in);
    
        boolean actionTaken = false; // Flag to track if an action has been taken
    
        while (true) {
            if (!actionTaken) {
                // Display prompt only if no action has been taken yet
                System.out.println("Do you want to:");
                System.out.println("1. Edit the existing file?");
                System.out.println("2. Delete the existing file and start over?");
                System.out.println("3. Load the existing file?");
                System.out.println("4. Create a new student list and calculate GPA?");
                System.out.println("Enter your choice: ");
            }
            
            int choice = scanner.nextInt();
            switch (choice) {
                case 1:
                    editExistingFile();
                    actionTaken = true;
                    break;
                case 2:
                    deleteExistingFile();
                    actionTaken = true;
                    break;
                case 3:
                    loadExistingFile(ui);
                    actionTaken = true;
                    break;
                case 4:
                    createNewStudentList(ui);
                    actionTaken = true;
                    break;
                default:
                    System.out.println("Invalid choice.");
            }
            
            // Reset the actionTaken flag before next iteration
            actionTaken = false;
        }
    }

    /**
     * Edits the existing student data file.
     * 
     * Requires: None.
     * Modifies: None.
     * Effects: Displays a message indicating editing process.
     */
    private static void editExistingFile() {
        // Implement edit functionality here
        System.out.println("Editing the existing file...");
    }

    /**
     * Deletes the existing student data file and starts over.
     * 
     * Requires: None.
     * Modifies: Deletes the existing student data file.
     * Effects: Prompts the user to create a new student list and calculate GPA.
     */
    private static void deleteExistingFile() {
        // Implement delete functionality here
        File file = new File(FILENAME);
        if (file.exists()) { // Check if the file exists before attempting to delete
            if (file.delete()) {
                System.out.println("Existing file deleted successfully.");
            } else {
                System.out.println("Failed to delete the existing file.");
            }
        } else {
            System.out.println("File does not exist.");
        }
    }
    
    /**
     * Loads the existing student data file.
     * 
     * Requires: A valid UI object.
     * Modifies: None.
     * Effects: Displays loaded courses and GPA or an error message if loading fails.
     * 
     * @param ui The UI object for displaying data.
     */
    private static void loadExistingFile(UI ui) {
        // Implement load functionality here
        Student student = FileHandler.loadStudent();
        if (student != null) {
            System.out.println("Student data loaded successfully.");
            // Display loaded courses and GPA
            ui.displayCourses(student);
            double gpa = student.calculateGPA();
            ui.displayGPA(gpa);
        } else {
            System.out.println("Failed to load student data.");
        }
    }

    /**
     * Creates a new student list and calculates GPA.
     * 
     * Requires: A valid UI object.
     * Modifies: Creates a new student data file.
     * Effects: Prompts the user to enter student data and saves it to a file.
     * 
     * @param ui The UI object for interaction.
     */
    private static void createNewStudentList(UI ui) {
        // Prompt the user to create a new student list
        System.out.println("Creating a new student list...");
        // Call the method to create a new student list and calculate GPA
        createNewStudent(ui);
    }

    /**
     * Prompts the user to enter student data and saves it to a file.
     * 
     * Requires: A valid UI object.
     * Modifies: Creates a new student data file.
     * Effects: Prompts the user to enter student data and saves it to a file.
     * 
     * @param ui The UI object for interaction.
     */
    private static void createNewStudent(UI ui) {
        Scanner scanner = new Scanner(System.in);
    
        System.out.print("Enter student name: ");
        String name = scanner.nextLine();
    
        System.out.print("Enter student ID: ");
        String id = scanner.nextLine();
    
        Student student = new Student(name, id);
    
        System.out.print("Enter the number of courses: ");
        int numCourses = Integer.parseInt(scanner.nextLine());
    
        for (int i = 1; i <= numCourses; i++) {
            System.out.println("Enter details for course " + i + ":");
            System.out.print("Name: ");
            String courseName = scanner.nextLine();
    
            System.out.print("Score: ");
            double score = Double.parseDouble(scanner.nextLine());
    
            System.out.print("Credits: ");
            int credits = Integer.parseInt(scanner.nextLine());
    
            try {
                student.addCourse(courseName, score, credits);
            } catch (InvalidPercentageGradeException | InvalidCreditsException e) {
                System.out.println(e.getMessage());
            }
        }
    
        // Calculate GPA
        double gpa = student.calculateGPA();
    
        // Save the new student data
        FileHandler.saveStudent(student);
    
        // Display GPA
        System.out.println("GPA: " + gpa);
        
        // Prompt the user
        System.out.println("Student data saved successfully.");
    }    
}
