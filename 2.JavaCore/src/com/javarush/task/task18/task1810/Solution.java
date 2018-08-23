package com.javarush.task.task18.task1810;

/* 
DownloadException
*/

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;

public class Solution {
    public static void main(String[] args) throws DownloadException, IOException {
        FileInputStream fis;
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        while (true) {
            fis = new FileInputStream(reader.readLine());
            if (fis.available() < 1000) {
                fis.close();
                throw new DownloadException();
            } else {
                fis.close();
            }
        }
    }

    public static class DownloadException extends Exception {

    }
}
