package com.javarush.task.task20.task2015;

import java.io.*;
import java.util.concurrent.TimeUnit;

/* 
Переопределение сериализации
*/
public class Solution implements Serializable, Runnable {
    private transient Thread runner;
    private int speed;
    private transient boolean interrupted = false;

    public Solution(int speed) {
        this.speed = speed;
        runner = new Thread(this);
        runner.start();
    }

    public void run() {
        // do something here, does not matter
        while (speed > 0) {
        try {
//            if (runner.isInterrupted() || speed < 0) break;
//  1st Workaround: runner.isInterrupted doesn't work, if we even call runner.interrupt();
//             then i use the workaround with additional variable
//            if (interrupted || speed < 0) break;
            System.out.println("Run speed " + speed--);
                TimeUnit.MILLISECONDS.sleep(500);
            } catch (InterruptedException e) {
//  2nd Workaround: runner.isInterrupted doesn't work, if we even call runner.interrupt();
//           it works however for try ... catch (InterruptedException)
            break;
            }
        }
    }

    /**
     Переопределяем сериализацию.
     Для этого необходимо объявить методы:
     private void writeObject(ObjectOutputStream out) throws IOException
     private void readObject(ObjectInputStream in) throws IOException, ClassNotFoundException
     Теперь сериализация/десериализация пойдет по нашему сценарию :)
     */
    private void writeObject(ObjectOutputStream out) throws IOException {
        out.defaultWriteObject();
    }

    private void readObject(ObjectInputStream in) throws IOException, ClassNotFoundException {
        in.defaultReadObject();
        runner = new Thread(this);
        runner.start();
    }
    public void interrupt(){
        runner.interrupt();
        interrupted = true;
    }

    public static void main(String[] args) throws IOException, ClassNotFoundException {
        // 1. Crete file for storing of object
        File file = File.createTempFile("storedSolution", ".dat");

        // Serialization
        ByteArrayOutputStream byteAOS = new ByteArrayOutputStream();
        ObjectOutputStream oos = new ObjectOutputStream(byteAOS);
        Solution storedObject = new Solution(16);
        oos.writeObject(storedObject);
        storedObject.interrupt();
        oos.close();

        // Deserialization
        ByteArrayInputStream byteAIS = new ByteArrayInputStream(byteAOS.toByteArray());
        ObjectInputStream ois = new ObjectInputStream(byteAIS);
        Solution loadedObject = (Solution) ois.readObject();
        ois.close();
    }
}
