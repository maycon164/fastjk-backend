package com.deadlock.fastjk.exceptions;

public class GoogleLoginException extends RuntimeException{

    public GoogleLoginException () {
        super("error while login with Google!");
    }

    public GoogleLoginException(String msg) {
        super(msg);
    }
}
