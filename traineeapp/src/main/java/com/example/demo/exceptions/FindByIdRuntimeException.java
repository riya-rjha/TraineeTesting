package com.example.demo.exceptions;

public class FindByIdRuntimeException extends RuntimeException {

    public FindByIdRuntimeException(String message) {
        System.out.println("Exception occurred as employee of the same Id does not exist");
    }
}