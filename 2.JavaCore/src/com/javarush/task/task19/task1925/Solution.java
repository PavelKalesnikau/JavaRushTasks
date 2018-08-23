package com.javarush.task.task19.task1925;

/* 
Длинные слова
*/

import java.io.*;

public class Solution {
    public static void main(String[] args) throws IOException {
        if (args.length == 0) return;

        BufferedReader bufferedReader = new BufferedReader(new FileReader(args[0])); // c:\temp\words.txt
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(args[1])); // c:\temp\words3.txt
        boolean firstWordIsWritten = false;
        while (bufferedReader.ready()) {
            // Look for words with numbers and put them into file
            String line = bufferedReader.readLine();
            String[] words = line.split(" ");
            for (String word : words) {
                if (word.length()>6) {  // if there is (are) number(s) in the word
                    if (firstWordIsWritten == true) bufferedWriter.write(",");
                    bufferedWriter.write(word); // write this word into file
                    if (firstWordIsWritten == false) firstWordIsWritten = true;
                }
            }
        }

        bufferedReader.close();
        bufferedWriter.close();

    }
}
