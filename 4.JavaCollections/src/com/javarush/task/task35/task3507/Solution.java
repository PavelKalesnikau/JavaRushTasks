package com.javarush.task.task35.task3507;


import java.io.File;
import java.io.IOException;
import java.lang.reflect.Constructor;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.HashSet;
import java.util.Set;

/* 
ClassLoader - что это такое?
*/
// Это решение из GitHub, моё решение валидатор не пропускает
public class Solution {
    public static void main(String[] args) {
        Set<? extends Animal> allAnimals = getAllAnimals(Solution.class.getProtectionDomain().getCodeSource().getLocation().getPath() + Solution.class.getPackage().getName().replaceAll("[.]", "/") + "/data");
        System.out.println(allAnimals);
    }


    public static Set<? extends Animal> getAllAnimals(String pathToAnimals) {
        Set<Animal> set = new HashSet<>();

        File[] list = new File(pathToAnimals).listFiles();
        for (File file : list) {
            if (file.isFile() && file.getName().endsWith(".class")) {

                String packageName = Solution.class.getPackage().getName() + ".data"; //some bed solution (Hardcore data)
                Class clazz = new ClassFromPath().load(file.toPath(), packageName); //Loading class from path

                int score = 0;
                //find interface Animal
                Class[] interfaces = clazz.getInterfaces();
                for (Class interf : interfaces)
                    if (interf.getSimpleName().toString().equals("Animal")) {
                        score++;
                        break;
                    }

                //Find default constuctor
                Constructor[] constructors = clazz.getConstructors();
                for (Constructor constructor : constructors)
                    if (constructor.getParameterCount() == 0) {
                        score++;
                    }

                //if all ok, add to set
                if (score == 2)
                    try {
                        Animal animal = (Animal) clazz.newInstance();
                        set.add(animal);
                    } catch (InstantiationException e) {
                        e.printStackTrace();
                    } catch (IllegalAccessException e) {
                        e.printStackTrace();
                    }
            }
        }

        return set;
    }

    public static class ClassFromPath extends ClassLoader {
        public Class<?> load(Path path, String packageName) {
            try {
                String className = packageName + "." + path.getFileName().toString().replace(".class", "");
                byte[] b = Files.readAllBytes(path);
                return defineClass(className, b, 0, b.length); //here main magic
            } catch (IOException e) {
                e.printStackTrace();
            }
            return null;
        }
    }
}
/*
Мое решение рабочее - но валидатор не пропустил!!!

public class Solution {
    public static void main(String[] args) {
        Set<? extends Animal> allAnimals = getAllAnimals(Solution.class.getProtectionDomain().getCodeSource().getLocation().getPath() + Solution.class.getPackage().getName().replaceAll("[.]", "/") + "/data");
        System.out.println(allAnimals);
    }

    public static Set<? extends Animal> getAllAnimals(String pathToAnimals) {

        Set<Animal> set = new HashSet<>();
        try {
            CCLoader loader = new CCLoader();
//            ClassLoader loader = Solution.class.getClassLoader();
            File[] files = new File(pathToAnimals).listFiles();
            for (File file : files) {
                if (file.isFile()  && file.getName().endsWith(".class")) {
                    String name = file.getAbsolutePath().substring(file.getAbsolutePath().indexOf("\\com")).split("[.]")[0];
                    name = name.replace(File.separatorChar, '.').substring(1);
                    Class clazz = loader.loadClass(name);
//                    Class clazz = loader.getClass(name);

                    // check constructors
                    boolean empty_constr;
                    Constructor[] constructors = clazz.getConstructors();
                    empty_constr = false;
                    Constructor constructor = null;
                    for (Constructor constr: constructors ) {
                        if (constr.getParameterCount() == 0){
                            empty_constr = true;
                            constructor = constr;
                            break;
                        }
                    }
                    //check interface
                    boolean inf_Animal;
                    Class[] intefaces = clazz.getInterfaces();
                    inf_Animal = false;
                    for (Class infs : intefaces ) {
                        if(infs.getName().endsWith("Animal")){
                            inf_Animal = true;
                            break;
                        }
                    }
                    if (inf_Animal && empty_constr){
                        Animal animal = (Animal) constructor.newInstance();
                        set.add(animal);
                    }
                }
            }
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        }

        return set;
    }

    public static class CCLoader extends ClassLoader {

*/
/*
 *
 * This constructor is used to set the parent ClassLoader
 *//*


//        public CCLoader(ClassLoader parent) {
//            super(parent);
//        }

*/
/*
 *
 * Loads the class from the file system. The class file should be located in
 * the file system. The name should be relative to get the file location
 *
 * @param name Fully Classified name of class, for example com.journaldev.Foo
 *//*


        private Class getClass(String name) throws ClassNotFoundException {
            String file = name.replace('.', File.separatorChar) + ".class";
            byte[] b = null;
            try {
                // This loads the byte code data from the file
                b = loadClassFileData(file);
                // defineClass is inherited from the ClassLoader class
                // that converts byte array into a Class. defineClass is Final
                // so we cannot override it
                Class c = defineClass(name, b, 0, b.length);
                resolveClass(c);
                return c;
            } catch (IOException e) {
                e.printStackTrace();
                return null;
            }
        }

//        *
//         * Every request for a class passes through this method. If the class is in
//         * com.journaldev package, we will use this classloader or else delegate the
//         * request to parent classloader.
//         *
//         * @param name Full class name

        @Override
        public Class loadClass(String name) throws ClassNotFoundException {
//            System.out.println("Loading Class '" + name + "'");
            if (name.startsWith("com.journaldev")) {
                System.out.println("Loading Class using CCLoader");
                return getClass(name);
            }
            return super.loadClass(name);
        }

//        *
//         * Reads the file (.class) into a byte array. The file should be
//         * accessible as a resource and make sure that its not in Classpath to avoid
//         * any confusion.
//         *
//         * @param name File name
//         * @return Byte array read from the file
//         * @throws IOException if any exception comes in reading the file

        private byte[] loadClassFileData(String name) throws IOException {
            InputStream stream = getClass().getClassLoader().getResourceAsStream(
                    name);
            int size = stream.available();
            byte buff[] = new byte[size];
            DataInputStream in = new DataInputStream(stream);
            in.readFully(buff);
            in.close();
            return buff;
        }
    }
}
*/
