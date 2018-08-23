package com.javarush.task.task19.task1916;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/* 
Отслеживаем изменения
*/

public class Solution {
    public static List<LineItem> lines = new ArrayList<LineItem>();

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String fileName1 = reader.readLine();
        String fileName2 = reader.readLine();
        reader.close();

        BufferedReader reader1 = new BufferedReader(new FileReader(fileName1)); // c:\temp\file1.txt
        LinkedList<String> file1 = readEntireFileIntoList1(reader1);
        reader1.close();

        BufferedReader reader2 = new BufferedReader(new FileReader(fileName2)); // c:\temp\file1.txt
        LinkedList<String> file2 = readEntireFileIntoList1(reader2);
        reader2.close();

 /*       for (int i = 0; i < file1.size(); i++) {
            String checkLine = file1.get(i);

            String s_before, s_same, s_after;
            if (i > 0) s_before = file2.get(i - 1);
            else s_before = null;

            if (i < file2.size()) s_same = file2.get(i);
            else s_same = null;

            if (i+1 < file2.size()) s_after = file2.get(i+1);
            else s_after = null;

            if (!checkLine.equals(s_before)&&!checkLine.equals(s_same)&&!checkLine.equals(s_after)) {
                lines.add(new LineItem(Type.REMOVED, checkLine));
                file2.add(i, checkLine);
            }

        }
*/
        for (int if1 = 0, if2 = 0; if1 < file1.size() || if2 < file2.size(); ) {

            String line1 = "";
            String line2 = "";
            if (if1 < file1.size())  line1 = file1.get(if1);
            if (if2 < file2.size())  line2 = file2.get(if2);

            if (line1.isEmpty() && !line2.isEmpty()){
                lines.add(new LineItem(Type.ADDED, line2));
                break;
            }
            if (line2.isEmpty() && !line1.isEmpty()){
                lines.add(new LineItem(Type.REMOVED, line1));
                break;
            }


            if (line1.equals(line2)) {
                lines.add(new LineItem(Type.SAME, line1));
                if1++;
                if2++;
            } else {
                String line1_next = "";
                String line2_next = "";
                int jf1 = if1 + 1; // next line file1
                if (jf1 < file1.size()) line1_next = file1.get(jf1);
                int jf2 = if2 + 1; // next line file2
                if (jf2 < file2.size()) line2_next = file2.get(jf2);

                if (line1_next.equals(line2)) {
                    if (line2_next.equals(line1)) {
                        lines.add(new LineItem(Type.ADDED, line2));
                        if2++;
                        continue;
                    } else {
                        lines.add(new LineItem(Type.REMOVED, line1));
                        if1++;
                        continue;
                    }
                }

                if (line2_next.equals(line1)) {
                    lines.add(new LineItem(Type.ADDED, line2));
                    if2++;
                    continue;
                }
             }
        }
        for (LineItem line : lines) {
            System.out.println(line.type + " " + line.line);
        }
    }

    private static LinkedList<String> readEntireFileIntoList(FileReader fileReader) throws IOException {
        BufferedReader reader = new BufferedReader(fileReader);
        LinkedList<String> file = new LinkedList<String>();
        while (reader.ready()) file.add(reader.readLine());
        reader.close();
        return file;
    }

    private static LinkedList<String> readEntireFileIntoList1(BufferedReader reader) throws IOException {
        LinkedList<String> file = new LinkedList<String>();
        while (reader.ready()) file.add(reader.readLine());
        return file;
    }


    public static enum Type {
        ADDED,        //добавлена новая строка
        REMOVED,      //удалена строка
        SAME          //без изменений
    }

    public static class LineItem {
        public Type type;
        public String line;

        public LineItem(Type type, String line) {
            this.type = type;
            this.line = line;
        }
    }
}
