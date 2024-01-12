package com.deadlock.fastjk.exceptions;

public class UserNotFound extends NotFoundException{
    public UserNotFound() {
        super("User not found!");
    }
}
