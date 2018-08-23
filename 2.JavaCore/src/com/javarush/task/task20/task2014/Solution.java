package com.javarush.task.task20.task2014;

import java.io.*;
import java.text.SimpleDateFormat;
import java.util.Date;

/* 
Serializable Solution
*/
public class Solution  implements Serializable{
    public static void main(String[] args) throws IOException, ClassNotFoundException {
        // 1. Create file
        File file = File.createTempFile("solution", ".dat");

        // 2. Serialization of object
        ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(file));
        Solution savedObject = new Solution(5);
        oos.writeObject(savedObject);
        oos.close();

        // 3. De-serialization of object
        ObjectInputStream ois = new ObjectInputStream(new FileInputStream(file));
        Solution loadedObject = new Solution(7);
        loadedObject = (Solution) ois.readObject();
        ois.close();

        // 4. Comparing objects (their strings)
        System.out.println(savedObject.toString().equals(loadedObject.toString()));
    }

    private transient final String pattern = "dd MMMM yyyy, EEEE";
    private transient Date currentDate;
    private transient int temperature;
    String string;

    public Solution(int temperature) {
        this.currentDate = new Date();
        this.temperature = temperature;

        string = "Today is %s, and current temperature is %s C";
        SimpleDateFormat format = new SimpleDateFormat(pattern);
        this.string = String.format(string, format.format(currentDate), temperature);
    }

    @Override
    public String toString() {
        return this.string;
    }
}
