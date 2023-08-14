package exceptions;

import enums.ExceptionsEnums;

public class DatabaseNullException extends RuntimeException {
    public DatabaseNullException() {
        super(ExceptionsEnums.DATABASE_NULL_EXCEPTION.name());
    }

}
