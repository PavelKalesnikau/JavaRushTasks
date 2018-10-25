package com.javarush.task.task38.task3804;

/* 
Фабрика исключений
*/

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class Solution {
    public static Class getFactoryClass() {
        return ExceptionFactory.class;
    }

    public static void main(String[] args) {
        // Testing of the implementation

        Class clazz = getFactoryClass();
        try {
            Method method = clazz.getMethod("getException", Object.class);

            Object o = method.invoke(null, ExceptionApplicationMessage.SOCKET_IS_CLOSED );
            Throwable throwable = (Throwable) o;
            throwable.printStackTrace();

            o = method.invoke(null, ExceptionUserMessage.USER_DOES_NOT_HAVE_PERMISSIONS );
            throwable = (Throwable) o;
            throwable.printStackTrace();

            o = method.invoke(null, ExceptionDBMessage.RESULT_HAS_NOT_GOTTEN_BECAUSE_OF_TIMEOUT);
            throwable = (Throwable) o;
            throwable.printStackTrace();

            o = method.invoke(null, new String());
            throwable = (Throwable) o;
            throwable.printStackTrace();

        } catch (NoSuchMethodException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        }
    }
}