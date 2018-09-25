package com.javarush.task.task36.task3602;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Modifier;
import java.util.Collections;
import java.util.List;

/*
Найти класс по описанию
*/
public class Solution {
    public static void main(String[] args) {
        System.out.println(getExpectedClass());
    }

    public static Class getExpectedClass() {
        Class[] classes = Collections.class.getDeclaredClasses();
        Class clazz = null;
        for (Class cl : classes) {
            int modif = cl.getModifiers();
            if (Modifier.isPrivate(modif) && Modifier.isStatic(modif)) {
                if (List.class.isAssignableFrom(cl)) {
                    try {
                        Constructor constructor = cl.getDeclaredConstructor();
                        constructor.setAccessible(true);
                        List list = (List) constructor.newInstance();
                        list.get(0);
                    } catch (IndexOutOfBoundsException e) {
                        clazz = cl;
                    } catch (NoSuchMethodException e) {
//                        e.printStackTrace();
                    } catch (IllegalAccessException e) {
//                        e.printStackTrace();
                    } catch (InstantiationException e) {
//                        e.printStackTrace();
                    } catch (InvocationTargetException e) {
//                        e.printStackTrace();
                    }
                }
            }
        }
        return clazz;
    }
}
