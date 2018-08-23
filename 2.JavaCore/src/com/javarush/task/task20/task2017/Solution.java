package com.javarush.task.task20.task2017;

import java.io.*;

/* 
Десериализация
*/
public class Solution implements Serializable{
    public static void main(String[] args) throws IOException, ClassNotFoundException {
        // Serialization
        ByteArrayOutputStream byteAOS = new ByteArrayOutputStream();
        ObjectOutputStream oos = new ObjectOutputStream(byteAOS);
        Solution.A storedObject = new Solution().new B();
        oos.writeObject(storedObject);
        oos.close();

        // Deserialization
        ByteArrayInputStream byteAIS = new ByteArrayInputStream(byteAOS.toByteArray());
        ObjectInputStream ois = new ObjectInputStream(byteAIS);
       Solution.A loadedObject = new Solution().getOriginalObject(ois);
        ois.close();

        System.out.println(storedObject);
        System.out.println(loadedObject);

    }

    public A getOriginalObject(ObjectInputStream objectStream) {
        try {
            A a = (A) objectStream.readObject();
//            if (!a.getClass().getSimpleName().equals("A")) return null;
            return a;
        }catch (Exception e) {
            System.out.println("Exception occured");
            return null;
        }
/*
        } catch (IOException e) {
//            e.printStackTrace();
//            System.out.println("IOException occured");
            return null;
        } catch (ClassNotFoundException e) {
//            e.printStackTrace();
//            System.out.println("ClassNotFoundException occured");
            return null;
        }
*/
    }

    public class A implements Serializable {
    }

    public class B extends A {
        public B() {
            System.out.println("inside B");
        }
    }
}
