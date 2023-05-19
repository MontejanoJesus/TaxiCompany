package com.solvd.project.reflection;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class Reflection {
    private final static Logger logger = LogManager.getLogger(Reflection.class);
    public static void main(String[] args) throws ClassNotFoundException, InvocationTargetException, InstantiationException, IllegalAccessException, NoSuchMethodException {
        Class reviewClass = Class.forName("com.solvd.project.taxicompany.Review");
        Method[] methods = reviewClass.getDeclaredMethods();
        Constructor[] constructors = reviewClass.getDeclaredConstructors();
        for(Method m : methods) {
            logger.info(m.toString() + "\n");
        }
        // Create new object using reflection
        Object parameters = "Everything is good";
        Object newObject = constructors[1].newInstance(parameters);
        logger.info(newObject.toString() + "\n");
        // Invoke method using reflection
        Method setReview = reviewClass.getMethod("setReview", String.class);
        Object review = setReview.invoke(newObject, "Review has changed now");
        logger.info(newObject.toString());

    }
}
