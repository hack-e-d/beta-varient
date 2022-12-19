package vijay.projects.betavarient.Exceptions;

public class NoUserFoundException extends RuntimeException {
    public NoUserFoundException() {
        super("No User with given Id found");
    }
}
