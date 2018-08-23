package com.javarush.task.task20.task2022;

import java.io.*;

/* 
Переопределение сериализации в потоке
*/
public class Solution implements Serializable, AutoCloseable {
    private transient FileOutputStream stream;
    String fileName;

    public Solution(String fileName) throws FileNotFoundException {
        this.stream = new FileOutputStream(fileName);
        this.fileName = fileName;
    }

    public void writeObject(String string) throws IOException {
        stream.write(string.getBytes());
        stream.write("\n".getBytes());
        stream.flush();
    }

    private void writeObject(ObjectOutputStream out) throws IOException {
        out.defaultWriteObject();
//        out.close();
    }

    private void readObject(ObjectInputStream in) throws IOException, ClassNotFoundException {
        in.defaultReadObject();
        this.stream = new FileOutputStream(fileName, true);
        //        in.close();
    }

    @Override
    public void close() throws Exception {
        System.out.println("Closing everything!");
        stream.close();
    }

    public static void main(String[] args) throws IOException, ClassNotFoundException {

        Solution solution = new Solution("c:\\temp\\data.txt");
        // Serialization
        ByteArrayOutputStream byteAOS = new ByteArrayOutputStream();
        ObjectOutputStream oos = new ObjectOutputStream(byteAOS);
        oos.writeObject(solution);
        oos.close();

        // Deserialization
        ByteArrayInputStream byteAIS = new ByteArrayInputStream(byteAOS.toByteArray());
        ObjectInputStream ois = new ObjectInputStream(byteAIS);
        Solution loadedObject = (Solution) ois.readObject();
        ois.close();

    }
}
