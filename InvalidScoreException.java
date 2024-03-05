package exception;

/**
 * Represents an exception thrown when an invalid score is encountered.
 * It extends the RuntimeException class.
 */
public class InvalidScoreException extends RuntimeException {
    /**
     * Constructs an InvalidScoreException with the specified detail message.
     * param : message The detail message.
     * requires : message != null
     * modifies : None.
     * effects : Initializes a new InvalidScoreException object.
     */
    public InvalidScoreException(String message) {
        super(message);
    }
}
