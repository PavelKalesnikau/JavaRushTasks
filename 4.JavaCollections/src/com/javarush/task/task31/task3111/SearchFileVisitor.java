package com.javarush.task.task31.task3111;

import java.io.File;
import java.io.IOException;
import java.nio.file.FileVisitResult;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.SimpleFileVisitor;
import java.nio.file.attribute.BasicFileAttributes;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class SearchFileVisitor extends SimpleFileVisitor<Path> {

    private String partOfName;
    private String partOfContent;
    private int minSize;
    private int maxSize;

    private List<Path> foundFiles = new ArrayList<Path>();

    public void setPartOfName(String partOfName) {
        this.partOfName = partOfName;
    }

    public void setPartOfContent(String partOfContent) {
        this.partOfContent = partOfContent;
    }

    public void setMinSize(int minSize) {
        this.minSize = minSize;
    }

    public void setMaxSize(int maxSize) {
        this.maxSize = maxSize;
    }

    @Override
    public FileVisitResult visitFile(Path file, BasicFileAttributes attrs) throws IOException {
        byte[] content = Files.readAllBytes(file); // размер файла: content.length
        String nameFile = file.getFileName().toString();

        boolean toAdd = true;

        if (partOfName != null && !partOfName.isEmpty() && !nameFile.contains(partOfName)) toAdd = false;
        if (partOfContent != null && !partOfContent.isEmpty() && !containsInContent(file)) toAdd = false;
        if (minSize != 0 && content.length < minSize) toAdd = false;
        if (maxSize != 0 && content.length > maxSize) toAdd = false;

        if (toAdd)
            foundFiles.add(file);

        return super.visitFile(file, attrs);
    }

    private boolean containsInContent(Path file) throws IOException {
        List<String> content = Files.readAllLines(file);
        for (String str : content) {
            if (str.contains(partOfContent)) return true;
        }
        return false;
    }

    public List<Path> getFoundFiles() {
        return foundFiles;
    }
}
