package com.mood.exceptions;

//Creating enum to differentiate the moods
public class MoodAnalysisException extends Exception {
    public enum ExceptionType {
        NULL_INPUT, EMPTY_INPUT;
    }

    //Creating an enum object
    public ExceptionType type;

    public MoodAnalysisException(ExceptionType type, String message) {
        super(message);
        this.type = type;
    }
}
