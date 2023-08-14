package exceptions;

import enums.ExceptionsEnums;

public class LackOfFundsException extends RuntimeException{
    public LackOfFundsException() {
        super(ExceptionsEnums.LACK_OF_FUNDS_EXCEPTION.name());
    }
}
