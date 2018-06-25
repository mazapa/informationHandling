package by.ryazantseva.handling.exception;

public class InvalidInputDataException extends Exception {
    public InvalidInputDataException(String message) {
        super(message);
    }

    public InvalidInputDataException() {

    }

    public InvalidInputDataException(Throwable cause) {
        super(cause);
    }

    public InvalidInputDataException(String message, Throwable cause) {
        super(message, cause);
    }
}
