package ua.artcode.exception;

/**
 * Created by Yaroslav on 11.01.2015.
 */
public class PasswordException extends Exception {
    public PasswordException() {
    }

    public PasswordException(String message) {
        super(message);
    }

    public PasswordException(String message, Throwable cause) {
        super(message, cause);
    }
}
