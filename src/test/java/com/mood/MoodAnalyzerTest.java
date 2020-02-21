package com.mood;

import com.mood.exceptions.MoodAnalysisException;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;

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
            Assert.assertEquals("SAD", moodResult);
        } catch (MoodAnalysisException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void givenmoodAnalyzerObject_WhenProper_ShouldReturnProper() {
        try {
            String moodResult;
            Constructor<?> constructor = Class.forName("com.mood.MoodAnalyzer").getConstructor(String.class);
            Object myObject = null;
            try {
                myObject = constructor.newInstance("I am in HAPPY mood");
                MoodAnalyser moodAnalyser = (MoodAnalyser) myObject;
                try {
                    moodResult = moodAnalyser.analyser();
                    Assert.assertEquals("HAPPY", moodResult);
                } catch (MoodAnalysisException e) {
                    e.printStackTrace();
                }
            } catch (InstantiationException e) {
                e.printStackTrace();
            } catch (IllegalAccessException e) {
                e.printStackTrace();
            } catch (InvocationTargetException e) {
                e.printStackTrace();
            }
        } catch (NoSuchMethodException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void givenMoodAnalyzerClass_WhenProper_ShouldReturnObject() {
        MoodAnalyser myVariable = MoodAnalyserFactory.createMoodAnalyser("I am in HAPPY mood");
        try {
            String mood = myVariable.analyser();
            Assert.assertEquals("HAPPY", mood);
        } catch (MoodAnalysisException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void givenTwoObjectsOfSameClassWithoutParameters_WhenCheckedForEquality_ShouldReturnTrue() {
        MoodAnalyser moodAnalyser = MoodAnalyserFactory.createMoodAnalyser();
        Assert.assertEquals(new MoodAnalyser(), moodAnalyser);
    }

    @Test
    public void givenTwoObjectsOfSameClassWithParameters_WhenCheckedForEquality_ShouldReturnTrue() {
        MoodAnalyser moodAnalyser1 = MoodAnalyserFactory.createMoodAnalyser("message");
        Assert.assertEquals(new MoodAnalyser("message"), moodAnalyser1);
    }

    @Test
    public void givenClassName_WhenImproper_ShouldReturnAnException() {
        try {
            MoodAnalyserFactory.getConstructor("com.mood.MoodAnalyser1", String.class);
        } catch (MoodAnalysisException e) {
            e.printStackTrace();
            Assert.assertEquals(MoodAnalysisException.ExceptionType.NO_SUCH_CLASS, e.type);
        }
    }

    @Test
    public void givenConstructorName_WhenProper_ShouldReturnAnException() {
        try {
            MoodAnalyserFactory.getConstructor("com.mood.MoodAnalyser", Integer.class);
        } catch (MoodAnalysisException e) {
            e.printStackTrace();
            Assert.assertEquals(MoodAnalysisException.ExceptionType.NO_SUCH_METHOD, e.type);
        }
    }
}


