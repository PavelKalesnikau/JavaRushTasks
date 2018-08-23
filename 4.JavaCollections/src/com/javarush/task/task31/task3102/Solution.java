package com.javarush.task.task31.task3102;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Queue;

/* 
Находим все файлы
*/
public class Solution {
    public static List<String> getFileTree(String root) throws IOException {
        File startDir = new File(root);

        List<String> files = new ArrayList<String>();

        Queue<File> dirs = new PriorityQueue<>();
        dirs.add(startDir);
        while (!dirs.isEmpty()) {
            File dir = dirs.poll();
            for (File file : dir.listFiles()) {
                if (file.isDirectory()) {
                    dirs.offer(file);
                } else {
                    files.add(file.getAbsolutePath());
                }
            }
        }
        return files;
    }

    public static void main(String[] args) {
        try {
            List<String> files = getFileTree("C:\\temp\\Tests");
            System.out.println(files);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
