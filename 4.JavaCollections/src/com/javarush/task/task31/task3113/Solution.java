package com.javarush.task.task31.task3113;

import java.io.*;
import java.nio.file.*;
import java.nio.file.attribute.BasicFileAttributes;

/* 
Что внутри папки?
*/
public class Solution {

    static long countDirs = -1;
    static long countFiles = 0;
    static long size = 0;

    public static void main(String[] args) throws IOException {

        System.out.println("Введите папку для анализа...");
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in)); // C:\temp\SAP
        String filePath = reader.readLine();

        Path dir = Paths.get(filePath);
        if (!Files.isDirectory(dir)) {
            System.out.println(dir.toAbsolutePath().toString() + " - не папка");
            return;
        }

        Files.walkFileTree(dir, new SimpleFileVisitor<Path>() {
            @Override
            public FileVisitResult preVisitDirectory(Path dir, BasicFileAttributes attrs) throws IOException {
                countDirs++;
                return FileVisitResult.CONTINUE;
            }

            @Override
            public FileVisitResult visitFile(Path file, BasicFileAttributes attrs) throws IOException {
                countFiles++;
                size += Files.size(file);
                return FileVisitResult.CONTINUE;
            }

            @Override
            public FileVisitResult visitFileFailed(Path file, IOException exc) throws IOException {
                return FileVisitResult.CONTINUE;
            }

            @Override
            public FileVisitResult postVisitDirectory(Path dir, IOException exc) throws IOException {
                return FileVisitResult.CONTINUE;
            }
        });

        System.out.println("Всего папок - " + countDirs);
        System.out.println("Всего файлов - " + countFiles);
        System.out.println("Общий размер - " + size);

        /*
        List<Path> dirs = getFileTree(dir, true, false);
        List<Path> files = getFileTree(dir, false, true);
        long countDirs2 = dirs.size();
        long countFiles2 = files.size();
        long size2 = calculateSizeOfFolder(files);
        System.out.println("Всего папок - " + countDirs2);
        System.out.println("Всего файлов - " + countFiles2);
        System.out.println("Общий размер - " + size2);
        */
    }

   /* public static List<Path> getFileTree(Path startDir, boolean getDirs, boolean getFiles) throws IOException {
        List<Path> files = new ArrayList<Path>();

        Queue<Path> dirs = new PriorityQueue<>();
        dirs.add(startDir);
        while (!dirs.isEmpty()) {
            Path dir = dirs.poll();
            for (File file : dir.toFile().listFiles()) {
                if (getDirs && file.isDirectory())
                    files.add(Paths.get(file.getAbsolutePath()));

                if (getFiles && file.isFile())
                    files.add(Paths.get(file.getAbsolutePath()));

                if (file.isDirectory()) {
                    dirs.offer(file.toPath());
                }
            }
        }
        return files;
    }

    private static long calculateSizeOfFolder(List<Path> files) throws IOException {
        long totalSize = 0;
        for (Path path : files) {
            totalSize += Files.size(path);
        }
        return totalSize;
    }*/

}
