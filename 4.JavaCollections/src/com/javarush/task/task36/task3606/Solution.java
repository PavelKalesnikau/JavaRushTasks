package com.javarush.task.task36.task3606;

import java.io.File;
import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;

/* 
Осваиваем ClassLoader и Reflection
*/
public class Solution {
    private List<Class> hiddenClasses = new ArrayList<>();
    private String packageName;

    public Solution(String packageName) {
        this.packageName = packageName;
    }

    public static void main(String[] args) throws ClassNotFoundException {
        Solution solution = new Solution(Solution.class.getProtectionDomain().getCodeSource().getLocation().getPath() + "com/javarush/task/task36/task3606/data/second");
        solution.scanFileSystem();
        System.out.println(solution.getHiddenClassObjectByKey("hiddenclassimplse"));
        System.out.println(solution.getHiddenClassObjectByKey("hiddenclassimplf"));
        System.out.println(solution.getHiddenClassObjectByKey("packa"));
    }

    public void scanFileSystem() throws ClassNotFoundException {

        ClassLoader loader = Solution.class.getClassLoader();
        File[] files = new File(packageName).listFiles();
        for (File file : files) {
            if (file.isFile() && file.getName().endsWith(".class")) {

                String binNameClass = getBinaryNameOfClass(file.toPath());
                Class clazz = loader.loadClass(binNameClass);

                // check constructors
                boolean empty_constr;
                Constructor[] constructors = clazz.getDeclaredConstructors();
                empty_constr = false;
                for (Constructor constr : constructors) {
                    if (constr.getParameterCount() == 0) {
                        empty_constr = true;
                        break;
                    }
                }
                //check interface
                boolean inf_hiddenClass;
                Class[] intefaces = clazz.getInterfaces();
                inf_hiddenClass = false;
                for (Class infs : intefaces) {
                    if (infs.getName().endsWith("HiddenClass")) {
                        inf_hiddenClass = true;
                        break;
                    }
                }
                if (inf_hiddenClass && empty_constr) {
                    hiddenClasses.add(clazz);
                }
            }
        }
    }

    private String getBinaryNameOfClass(Path filePath) {
        String strFilePath = filePath.toString().replaceAll("[\\\\/]+", ".");
        String pckNm = Solution.class.getPackage().getName();
        int startIndex = strFilePath.indexOf(pckNm);
        int endIndex = strFilePath.indexOf(".class");
        return strFilePath.substring(startIndex, endIndex);
    }

    public HiddenClass getHiddenClassObjectByKey(String key) {
        key = key.toLowerCase();
        for (Class clazz : hiddenClasses) {
            String name = clazz.getName().toLowerCase();
            if (name.contains(key)) {
                try {
                    Constructor constructor = clazz.getDeclaredConstructor();
                    constructor.setAccessible(true);
                    return (HiddenClass) constructor.newInstance();
                } catch (InstantiationException e) {
                    e.printStackTrace();
                } catch (IllegalAccessException e) {
                    e.printStackTrace();
                } catch (InvocationTargetException e) {
                    e.printStackTrace();
                } catch (NoSuchMethodException e) {
                    e.printStackTrace();
                }
            }
        }
        return null;
    }
}

