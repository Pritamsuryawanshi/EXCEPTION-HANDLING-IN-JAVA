//                                  WELCOME TO JAVA EXCEPTION HANDLING EXERCISES

package com.mood;

import com.mood.exceptions.MoodAnalysisException;

public class MoodAnalyser {
    private String mood;

    //Default Constructor
    public MoodAnalyser() {
        this.mood = "mood";
    }

    //Parameterized Constructor
    public MoodAnalyser(String mood) {

        this.mood = mood;
    }

    public static void main(String[] args) {
        System.out.println("Welcome");
    }

    //Method to perform the exception exercises
    public String analyser() throws MoodAnalysisException {
        try {
            if (mood.isEmpty()) {
                throw new MoodAnalysisException(MoodAnalysisException.ExceptionType.EMPTY_INPUT, "Field's cant be empty");
            }
            if (mood.contains("HAPPY")) {
                return "HAPPY";
            } else {
                return "SAD";
            }
        } catch (NullPointerException e) {
            throw new MoodAnalysisException(MoodAnalysisException.ExceptionType.NULL_INPUT, "Enter a valid Mood");
        }
    }

    public boolean equals(Object another) {
        if (this.mood.equals(((MoodAnalyser) another).mood)) {
            return true;
        }
        return false;
    }
}
