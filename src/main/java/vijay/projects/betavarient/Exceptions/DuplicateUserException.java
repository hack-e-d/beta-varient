package vijay.projects.betavarient.Exceptions;

public class DuplicateUserException extends RuntimeException {
    public DuplicateUserException() {
        super("Duplicate Users cannot be added");
    }
}
