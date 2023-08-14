package exceptions;

import enums.ExceptionsEnums;

public class EmailAlReadyException extends RuntimeException{
    public EmailAlReadyException() {
        super(ExceptionsEnums.EMAIL_ALREADY_EXIST_EXCEPTION.name());
    }
}
