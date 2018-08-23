package com.javarush.task.task19.task1918;

/* 
Знакомство с тегами
*/

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Solution {
    public static void main(String[] args) throws IOException {

        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String fileName = reader.readLine();
        reader.close();

        FileReader fileReader = new FileReader(fileName); // c:\temp\test.html

        StringBuilder contentBuilder = new StringBuilder();
        while (fileReader.ready()) {
            contentBuilder.append((char) fileReader.read());
        }
        fileReader.close();

        parseHTML(contentBuilder.toString(), args[0]);
    }

    private static void parseHTML(String string, String tag) {
        string = string.replaceAll("\\r\\n|\\r|\\n", ""); // delete symbols \n and \r

        Pattern pCloseTag = Pattern.compile("</" + tag + ">");
        Matcher mCloseTag = pCloseTag.matcher(string);

        Pattern pTag = Pattern.compile("</?" + tag + ".*?>");
        Matcher mTag = pTag.matcher(string);

        ArrayList<Integer> closeTagIndexes = new ArrayList<Integer>();

        while (mCloseTag.find()) closeTagIndexes.add(mCloseTag.start());

        int count = 0, start = 0, end = 0;
        int openTag = 0;
        int openTagLength = 0;

        while (mTag.find()) {
            start = mTag.start();
            end = mTag.end();
            int length = end - start;
            if (closeTagIndexes.contains(start)) {
                count--;
                if (count == 0) {
                    String line = string.substring(openTag, end);
                    System.out.println(line);
                    parseHTML(line.substring(openTagLength, line.length() - length), tag);
                    openTag = 0;
                    openTagLength = 0;
                }
            } else {
                count++;
                if (openTag == 0) {
                    openTag = start;
                    openTagLength = length;
                }
            }
        }
    }
}
