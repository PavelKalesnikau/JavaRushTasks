package com.javarush.task.task31.task3101;

import java.io.File;

public class FileUtils {

    public static void deleteFile(File file) {
        if (!file.delete()) System.out.println("Can not delete file with name " + file.getName());
    }

    public static void renameFile(File source, File destination) {
        try {
            if (!source.renameTo(destination))
                System.out.println("Can not rename file with name " + source.getName());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static boolean isExist(File file) {
        return file.exists();
    }
}
