package com.deadlock.fastjk.exceptions;

public class UnauthorizedException extends RuntimeException{
    public UnauthorizedException(){
        super("user not authorized");
    }

    public UnauthorizedException(String message){
        super(message);
    }
}
