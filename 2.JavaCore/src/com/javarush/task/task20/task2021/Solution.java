package com.javarush.task.task20.task2021;

import java.io.*;

/* 
Сериализация под запретом
*/
public class Solution implements Serializable {
    public static class SubSolution extends Solution {
        public SubSolution()  throws NotSerializableException {
            throw new NotSerializableException();
        }
    }

    public static void main(String[] args) throws IOException, ClassNotFoundException {
        // Serialization
        ByteArrayOutputStream byteAOS = new ByteArrayOutputStream();
        ObjectOutputStream oos = new ObjectOutputStream(byteAOS);
        Solution storedObject = new Solution.SubSolution();
        oos.writeObject(storedObject);
        oos.close();

        // Deserialization
        ByteArrayInputStream byteAIS = new ByteArrayInputStream(byteAOS.toByteArray());
        ObjectInputStream ois = new ObjectInputStream(byteAIS);
        Solution loadedObject = (Solution) ois.readObject();
        ois.close();
    }

}
