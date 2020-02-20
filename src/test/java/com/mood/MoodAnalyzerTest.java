package com.mood;

import com.mood.exceptions.MoodAnalysisException;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class MoodAnalyzerTest {

    // Test case to check if the function returns "HAPPY" when string contains "HAPPY"
    @Test
    public void givenInputByConstructor_WhenContainsHappy_ShouldReturnHappy() {
        String moodResult = null;
        try {
            MoodAnalyser moodAnalyserObject = new MoodAnalyser("HAPPY");
            moodResult = moodAnalyserObject.analyser();
            Assert.assertEquals("HAPPY", moodResult);
        } catch (MoodAnalysisException e) {
            e.printStackTrace();
        }
    }

    // Test case to check if the function returns "SAD" when string contains "SAD"
    @Test
    public void givenInputByConstructor_WhenContainsSad_ShouldReturnSad() {
        String moodResult = null;
        try {
            MoodAnalyser moodAnalyserObject = new MoodAnalyser("SAD");
            moodResult = moodAnalyserObject.analyser();
            Assert.assertEquals("SAD", moodResult);
        } catch (MoodAnalysisException e) {
            e.printStackTrace();
        }
    }


    // Test case to check if the function creates a custom exception when string is null
    @Test
    public void givenInputByConstructor_WhenNull_ShouldCreateCustomException() {
        String moodResult = null;
        try {
            MoodAnalyser moodAnalyserObject = new MoodAnalyser(null);
            moodResult = moodAnalyserObject.analyser();
        } catch (MoodAnalysisException e) {
            Assert.assertEquals("Enter a valid Mood", e.getMessage());
            e.printStackTrace();
        }
    }

    // Test case to check if the custom exception matches with enum type when the string is null
    @Test
    public void givenInputByConstructor_WhenNull_ShouldCreateAnException() {
        String moodResult;
        try {
            MoodAnalyser moodAnalyserObject = new MoodAnalyser(null);
            moodResult = moodAnalyserObject.analyser();
        } catch (MoodAnalysisException e) {
            Assert.assertEquals(MoodAnalysisException.ExceptionType.NULL_INPUT, e.type);
            e.printStackTrace();
        }
    }

    // Test case to check if the custom exception matches with enum type when the string is empty
    @Test
    public void givenInputByConstructor_WhenEmpty_ShouldReturnExceptions() {
        String moodResult = null;
        try {
            MoodAnalyser moodAnalyserObject = new MoodAnalyser("");
            moodResult = moodAnalyserObject.analyser();
        } catch (MoodAnalysisException e) {
            Assert.assertEquals(MoodAnalysisException.ExceptionType.EMPTY_INPUT, e.type);
            e.printStackTrace();
        }
    }

    // Test case to check if the method creates a NullPointerException when the constructor is empty
    @Test
    public void givenNoInputByDefaultConstructor_WhenEmpty_ShouldReturnExceptions() {
        String moodResult = null;
        try {
            MoodAnalyser moodAnalyserObject = new MoodAnalyser();
            moodResult = moodAnalyserObject.analyser();
            Assert.assertEquals("HAPPY", moodResult);
        } catch (MoodAnalysisException e) {
            e.printStackTrace();
        }
    }
}
