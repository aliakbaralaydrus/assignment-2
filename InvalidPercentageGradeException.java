package exception;

/**
 * Represents an exception thrown when an invalid percentage grade is encountered.
 * It extends the RuntimeException class.
 */
public class InvalidPercentageGradeException extends RuntimeException {
    /**
     * Constructs an InvalidPercentageGradeException with the specified detail message.
     * param : message The detail message.
     * requires : message != null
     * modifies : None.
     * effects : Initializes a new InvalidPercentageGradeException object.
     */
    public InvalidPercentageGradeException(String message) {
        super(message);
    }
}
