package exception;

/**
 * Represents an exception thrown when an invalid number of credits is encountered.
 * It extends the RuntimeException class.
 */
public class InvalidCreditsException extends RuntimeException {
    /**
     * Constructs an InvalidCreditsException with the specified detail message.
     * param : message The detail message.
     * requires : message != null
     * modifies : None.
     * effects : Initializes a new InvalidCreditsException object.
     */
    public InvalidCreditsException(String message) {
        super(message);
    }
}
