package com.school;

public class InvoiceNotFoundException extends RuntimeException {

    public InvoiceNotFoundException(String message) {
        super(message);
    }
}