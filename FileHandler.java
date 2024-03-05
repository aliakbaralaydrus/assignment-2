package persistence;

import model.Student;
import java.io.*;

/**
 * Handles the saving and loading of student data to/from a file.
 */
public class FileHandler {
    private static final String FILENAME = "student.ser";

    /**
     * Saves the student data to a file.
     * 
     * Requires: A valid Student object.
     * Modifies: Creates or modifies the student data file.
     * Effects: Writes the student data to a file named "student.ser".
     * 
     * param : student The student object to save.
     */
    public static void saveStudent(Student student) {
        try {
            FileOutputStream fileOut = new FileOutputStream(FILENAME);
            ObjectOutputStream objectOut = new ObjectOutputStream(fileOut);
            objectOut.writeObject(student);
            objectOut.close();
            System.out.println("Student data saved successfully.");
        } catch (IOException e) {
            System.out.println("Error saving student data: " + e.getMessage());
        }
    }

    /**
     * Loads student data from a file.
     * 
     * Requires: The student data file "student.ser" exists in the directory.
     * Modifies: None.
     * Effects: Reads the student data from the file and returns a Student object.
     * 
     * @return : The loaded Student object.
     */
    public static Student loadStudent() {
        Student student = null;
        try {
            FileInputStream fileIn = new FileInputStream(FILENAME);
            ObjectInputStream objectIn = new ObjectInputStream(fileIn);
            student = (Student) objectIn.readObject();
            objectIn.close();
            System.out.println("Student data loaded successfully.");
        } catch (FileNotFoundException e) {
            System.out.println("Student data file not found.");
        } catch (IOException | ClassNotFoundException e) {
            System.out.println("Error loading student data: " + e.getMessage());
        }
        return student;
    }
}
