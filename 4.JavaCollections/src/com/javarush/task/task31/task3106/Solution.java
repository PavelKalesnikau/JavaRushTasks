package com.javarush.task.task31.task3106;

import java.io.*;
import java.nio.file.CopyOption;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.*;
import java.util.zip.ZipEntry;
import java.util.zip.ZipInputStream;

import static java.nio.file.StandardCopyOption.REPLACE_EXISTING;

/*
Разархивируем файл
*/
public class Solution {
    public static void main(String[] args) {

        try (FileOutputStream fos = new FileOutputStream(args[0])) {
            List<String> zipLParts = new ArrayList<>(args.length - 1);
            for (int i = 1; i < args.length; i++) {
                zipLParts.add(args[i]);
            }
            Collections.sort(zipLParts);
            Vector<FileInputStream> zipVParts = new Vector<FileInputStream>(args.length - 1);
            for (String filePart : zipLParts) {
                zipVParts.add(new FileInputStream(filePart));
            }

            ZipInputStream zis = new ZipInputStream(new SequenceInputStream(zipVParts.elements()));

            ZipEntry zipEntry = zis.getNextEntry();
            while (zipEntry != null) {
                byte[] buffer = new byte[1024];
                int count = 0;
                while (true) {
                     count = zis.read(buffer);
                     if (count == -1) break;
                    fos.write(buffer, 0, count);
                }
                zipEntry = zis.getNextEntry();
            }
            zis.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
