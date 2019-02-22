package com.student.dogs;

public class DogNotFoundException extends RuntimeException {
    public DogNotFoundException(Long id){
        super("Could not find employee " + id);
    }
}
