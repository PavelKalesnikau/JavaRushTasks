package com.javarush.task.task15.task1525;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

/* 
Файл в статическом блоке
*/

public class Solution {
    public static List<String> lines = new ArrayList<String>();
    static{
        InputStreamReader isReader = null;
        try {
            isReader = new InputStreamReader(new FileInputStream(Statics.FILE_NAME));
            BufferedReader fileReader = new BufferedReader(isReader);
            String s = null;
            while ( (s = fileReader.readLine()) != null) {
                lines.add(s);
            }
            fileReader.close();
            isReader.close();
        } catch (FileNotFoundException e) {

        } catch (IOException e) {

        }

    }

    public static void main(String[] args) {
        System.out.println(lines);
    }
}
