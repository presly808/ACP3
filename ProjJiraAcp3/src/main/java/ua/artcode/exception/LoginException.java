package ua.artcode.exception;

/**
 * Created by Yaroslav on 11.01.2015.
 */
public class LoginException extends Exception {
    public LoginException() {
    }

    public LoginException(String message) {
        super(message);
    }

    public LoginException(String message, Throwable cause) {
        super(message, cause);
    }
}
