package com.doozy.user.error;

public class BookNotLikedException extends Exception {
    public BookNotLikedException() {
        super();
    }

    public BookNotLikedException(String message) {
        super(message);
    }

    public BookNotLikedException(String message, Throwable cause) {
        super(message, cause);
    }

    public BookNotLikedException(Throwable cause) {
        super(cause);
    }

    public BookNotLikedException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
