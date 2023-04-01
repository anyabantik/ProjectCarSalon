package Exceptions;
public class CarParameterException extends Exception {

    public CarParameterException() {
        super();
    }

    public CarParameterException(String message) {
        super(message);
    }

    public CarParameterException(String message, Throwable cause) {
        super(message, cause);
    }

    public CarParameterException(Throwable cause) {
        super(cause);
    }

    protected CarParameterException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}