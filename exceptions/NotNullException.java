package exceptions;

import enums.ExceptionsEnums;

public class NotNullException extends RuntimeException {
    public NotNullException() {
        super(ExceptionsEnums.NOT_NULL_EXCEPTIONS.name());
    }
}
