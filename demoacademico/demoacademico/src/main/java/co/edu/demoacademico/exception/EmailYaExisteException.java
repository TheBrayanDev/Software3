package co.edu.demoacademico.exception;

public class EmailYaExisteException extends RuntimeException {
    public EmailYaExisteException(String message) {
        super(message);
    }
}
