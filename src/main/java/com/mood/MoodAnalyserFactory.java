package com.mood;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;

public class MoodAnalyserFactory {

    public static MoodAnalyser createMoodAnalyser(String mood) {
        Object myobject = null;
        try {
            Class<?> moodAnalyserClass = Class.forName("com.mood.MoodAnalyser");
            Constructor<?> myConstructor = moodAnalyserClass.getConstructor(String.class);
            myobject = myConstructor.newInstance(mood);
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        } catch (NoSuchMethodException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        return (MoodAnalyser) myobject;
    }

    public static MoodAnalyser createMoodAnalyser() {
        Object myobject = null;
        try {
            Class<?> moodAnalyserClass = Class.forName("com.mood.MoodAnalyser");
            Constructor<?> myConstructor = moodAnalyserClass.getConstructor();
            myobject = myConstructor.newInstance();
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        } catch (NoSuchMethodException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        return (MoodAnalyser) myobject;
    }
}
