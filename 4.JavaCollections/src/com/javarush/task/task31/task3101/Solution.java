package com.javarush.task.task31.task3101;

import java.io.*;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

/*
Проход по дереву файлов
*/
public class Solution {
    public static void main(String[] args) {

        File dir = new File(args[0]);
        File fileFrom = new File(args[1]);
        File fileTo = new File(fileFrom.getParent()+ "\\allFilesContent.txt");

        // rename of file
        FileUtils.renameFile(fileFrom, fileTo);
        if(!FileUtils.isExist(fileTo)) return;

        // write content of selected files into fileTo

        try(FileOutputStream fileOutputStream = new FileOutputStream(fileTo))
        {
            List<File> sortedFiles = getFiles(dir);

            for (File file : sortedFiles) {
                FileInputStream fileInputStream = new FileInputStream(file);
                int bt = 0;
                while ((bt = fileInputStream.read()) != -1){
                    fileOutputStream.write(bt);
                }
                fileOutputStream.write('\n');
                fileInputStream.close();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static List getFiles(File dir) {
        List<File> selectedFiles = new ArrayList<File>();
        File[] files = dir.listFiles();
// select files
        for (File file : files) {
            if (file.isDirectory()) {
                List<File> subFiles = new ArrayList<File>();
                subFiles = getFiles(file);
                selectedFiles.addAll(subFiles);
            } else if (file.isFile()) {
                if (file.length() <= 50)
                    selectedFiles.add(file);
            } else {
                continue;
            }
        }
// sort selected files
/*
        Collections.sort(selectedFiles, new Comparator<File>() {
            @Override
            public int compare(File o1, File o2) {
                return o1.getName().compareTo(o2.getName());
            }
        });
*/

        Collections.sort(selectedFiles, (a, b) -> a.compareTo(b));
        return selectedFiles;
    }
}
