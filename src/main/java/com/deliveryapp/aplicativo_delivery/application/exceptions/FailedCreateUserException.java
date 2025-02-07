package com.deliveryapp.aplicativo_delivery.application.exceptions;

public class FailedCreateUserException extends Exception {
    public FailedCreateUserException() {
        super("Failed to create user");
    }
}
