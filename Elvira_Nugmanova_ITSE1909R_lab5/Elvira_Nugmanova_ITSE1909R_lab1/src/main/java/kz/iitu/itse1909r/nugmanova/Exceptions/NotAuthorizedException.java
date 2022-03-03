package kz.iitu.itse1909r.nugmanova.Exceptions;

public class NotAuthorizedException extends Exception {
    public NotAuthorizedException(String errorMessage) {
        super(errorMessage);
    }
}
