package com.javarush.task.task19.task1923;

/* 
Слова с цифрами
*/

import java.io.*;

public class Solution {
    public static void main(String[] args) throws IOException {

        if (args.length == 0) return;

        BufferedReader bufferedReader = new BufferedReader(new FileReader(args[0])); // c:\temp\words.txt
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(args[1])); // c:\temp\words3.txt
        while (bufferedReader.ready()) {
            // Look for words with numbers and put them into file
            String line = bufferedReader.readLine();
            String[] words = line.split(" ");
            for (String word : words) {
                if (word.matches(".*\\d+.*"))  // if there is (are) number(s) in the word
//                if (!word.matches("^\\D*$"))  // if there is (are) number(s) in the word
//                if (isWordContainNumber(word))  // if there is (are) number(s) in the word
                    bufferedWriter.write(word + " "); // write this word into file
            }
        }

        bufferedReader.close();
        bufferedWriter.close();
    }
}
//    private static boolean isWordContainNumber(String word){
//        if ( word.contains("0") ||
//             word.contains("1") ||
//             word.contains("2") ||
//             word.contains("3") ||
//             word.contains("4") ||
//             word.contains("5") ||
//             word.contains("6") ||
//             word.contains("7") ||
//             word.contains("8") ||
//             word.contains("9")) return true;
//        else return false;
//    }
//}
