package exceptions;

import enums.ExceptionsEnums;

public class EntryLimitException extends RuntimeException {
    public EntryLimitException() {
        super(ExceptionsEnums.ENTRY_LIMIT_EXCEPTION.name());
    }
}
