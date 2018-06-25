package by.ryazantseva.handling.exception;

public class DataFileReaderException extends Exception {

    public DataFileReaderException(String message) {
        super(message);
    }

    public DataFileReaderException() {

    }

    public DataFileReaderException(Throwable cause) {
        super(cause);
    }

    public DataFileReaderException(String message, Throwable cause) {
        super(message, cause);
    }

}
