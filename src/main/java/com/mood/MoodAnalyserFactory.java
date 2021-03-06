package com.mood;

import com.mood.exceptions.MoodAnalysisException;
import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;

public class MoodAnalyserFactory {

    public static String invokeMethod(MoodAnalyser moodObj, String method) throws MoodAnalysisException {
        try {
            return (String) moodObj.getClass().getDeclaredMethod(method).invoke(moodObj);
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        } catch (NoSuchMethodException e) {
            throw new MoodAnalysisException(MoodAnalysisException.ExceptionType.NO_SUCH_METHOD, e.getMessage());
        }
        return null;
    }

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

    public static Constructor getConstructor(String param, Class constructor) throws MoodAnalysisException {
        try {
            Class<?> aClass = Class.forName(param);
            return aClass.getConstructor(constructor);
        } catch (ClassNotFoundException e) {
            throw new MoodAnalysisException(MoodAnalysisException.ExceptionType.NO_SUCH_CLASS, e.getMessage());
        } catch (NoSuchMethodException e) {
            throw new MoodAnalysisException(MoodAnalysisException.ExceptionType.NO_SUCH_METHOD, e.getMessage());
        }
    }

    public static String invokeField(MoodAnalyser moodObj, String fieldValue, String happy) throws MoodAnalysisException {

        try {
            Field declaredField = moodObj.getClass().getDeclaredField(fieldValue);
            declaredField.setAccessible(true);
            declaredField.set(moodObj, happy);
            return (String) moodObj.getClass().getDeclaredMethod("analyser").invoke(moodObj);
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (NoSuchMethodException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            throw new MoodAnalysisException(MoodAnalysisException.ExceptionType.INVOCATION_TARGET_EXCEPTION, e.getMessage());
        } catch (NoSuchFieldException e) {
            throw new MoodAnalysisException(MoodAnalysisException.ExceptionType.NO_SUCH_FIELD, e.getMessage());
        }
        return null;
    }
}
