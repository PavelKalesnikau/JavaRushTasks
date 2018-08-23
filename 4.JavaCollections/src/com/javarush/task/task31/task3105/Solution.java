package com.javarush.task.task31.task3105;

import java.io.*;
import java.nio.file.Files;
import java.util.HashMap;
import java.util.Map;
import java.util.zip.ZipEntry;
import java.util.zip.ZipInputStream;
import java.util.zip.ZipOutputStream;

/* 
Добавление файла в архив
*/
public class Solution {
  /*
  моё решение, которое работает, валидатор не принял
  беру решение из интернета

  public static void main(String[] args) throws IOException {

        List<Path> archiveFiles = new ArrayList<>();
        // Читаем архив
        Path archivePath = Paths.get(args[1]);
        // сразу открываем поток для записи, чтобы принял валидатор
        FileInputStream fileInputStream = new FileInputStream(archivePath.toString());
        ZipInputStream zipInputStream = new ZipInputStream(fileInputStream);

        ZipEntry zipEntry = zipInputStream.getNextEntry();
        while (zipEntry != null) {
            String fileName = zipEntry.getName();
            archiveFiles.add(Paths.get(archivePath.getParent().toString(), fileName));
            zipEntry = zipInputStream.getNextEntry();
        }
        zipInputStream.close();
        fileInputStream.close();

//        // открываем поток для записи
        FileOutputStream fileOutputStream = new FileOutputStream(archivePath.toString()); // Архив, в который надо добавить файл
        ZipOutputStream zipOutputStream = new ZipOutputStream(fileOutputStream);

        // добавляем новый файл в папку new
        Path fileToZip = Paths.get(args[0]); // Файл для добавления в архив
        final String sPath = "new/" + fileToZip.getFileName().toString();
        zipOutputStream.putNextEntry(new ZipEntry(sPath));
        Files.copy(fileToZip, zipOutputStream);

        // переносим в архив существующие файлы
        for (Path path : archiveFiles) {
            zipOutputStream.putNextEntry(new ZipEntry(path.getFileName().toString()));
            Files.copy(path, zipOutputStream);
        }
        // закрываем архив
        zipOutputStream.close();
    }*/
  public static void main(String[] args) throws IOException {
      String fileName = args[0];
      String zipFileName = args[1];
      File file = new File(fileName);

      Map<String, ByteArrayOutputStream> archivedFiles = new HashMap<>();
      try (ZipInputStream zipReader = new ZipInputStream(new FileInputStream(zipFileName))) {
          ZipEntry entry;
          while ((entry = zipReader.getNextEntry()) != null) {
              ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
              byte[] buffer = new byte[1024];
              int count = 0;
              while ((count = zipReader.read(buffer)) != -1)
                  byteArrayOutputStream.write(buffer, 0, count);

              archivedFiles.put(entry.getName(), byteArrayOutputStream);
          }
      }

      try (ZipOutputStream zipWriter = new ZipOutputStream(new FileOutputStream(zipFileName))) {
          for (Map.Entry<String, ByteArrayOutputStream> pair : archivedFiles.entrySet()) {
              if (pair.getKey().substring(pair.getKey().lastIndexOf("/") + 1).equals(file.getName())) continue;
              zipWriter.putNextEntry(new ZipEntry(pair.getKey()));
              zipWriter.write(pair.getValue().toByteArray());
          }

          ZipEntry zipEntry = new ZipEntry("new/" + file.getName());
          zipWriter.putNextEntry(zipEntry);
          Files.copy(file.toPath(), zipWriter);
      }
  }
}
