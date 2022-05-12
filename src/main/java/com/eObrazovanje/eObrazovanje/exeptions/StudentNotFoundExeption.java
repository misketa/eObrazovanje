package com.eObrazovanje.eObrazovanje.exeptions;

public class StudentNotFoundExeption extends RuntimeException{

    public StudentNotFoundExeption(String message) {
        super(message);
    }
}
