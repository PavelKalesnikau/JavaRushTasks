package com.javarush.task.task22.task2209;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.*;

/*
Составить цепочку слов
*/
/* public class Solution {
   public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in)); // c:\temp\words6.txt
        String fileName = reader.readLine();
        reader.close();

        BufferedReader fileReader = new BufferedReader(new FileReader(fileName));
        StringBuilder sb = new StringBuilder();

        while (fileReader.ready()) sb.append(fileReader.readLine()).append(" ");

        String[] words = sb.toString().split("\\s+");

        for (String word: words) {
            System.out.print(word + " ");
        }
        System.out.println();

        StringBuilder result = getLine(words);
        System.out.println(result.toString());
    }

    public static StringBuilder getLine(String... words) {
        if (words.length == 0) return new StringBuilder("");

        words = deleteDuplicates(words);

        LinkedHashSet<String> set = new LinkedHashSet<String>();
        // sorting
        for (int i = 0; i < words.length; i++) {
            if (isContain(set, words[i])) continue;
            for (int j = 0; j < words.length; j++) {
                if (i == j) continue;
                if (words[i].toLowerCase().charAt(0) == words[j].toLowerCase().charAt(words[j].length()-1)){
                    set.add(words[j]);
                    set.add(words[i]);
                    break;
                } else if (words[j].toLowerCase().charAt(0) == words[i].toLowerCase().charAt(words[i].length()-1)){
                    set.add(words[i]);
                    set.add(words[j]);
                    break;
                }
            }
        }

        StringBuilder result = new StringBuilder();
        int length = set.size(), i = 0;
        for (String word: set) {
            i++;
            result.append(word);
            if (i < length) result.append(" ");
        }
        return result;
    }

    private static boolean isContain(LinkedHashSet<String> set, String word) {
        for (String s: set) {
            if (s.toLowerCase().equals(word.toLowerCase())) return true;
        }
        return false;
    }

    private static String[] deleteDuplicates(String... words) {
        HashSet<String> set = new HashSet<String>();
        for (String word: words) {
            set.add(word);
        }
        return set.toArray(new String[set.size()]); // unique words
    }
}*/
public class Solution {
    public static void main(String[] args) throws IOException {
        String fileName = null;
        try (BufferedReader reader = new BufferedReader(new InputStreamReader(System.in)))
        {fileName = reader.readLine();}

        String content = new String(Files.readAllBytes(Paths.get(fileName)), StandardCharsets.UTF_8);
        String[] words = content.split(" ");

        StringBuilder result = getLine(words);
        System.out.println(result.toString());
    }

    public static StringBuilder getLine(String... words) {

        StringBuilder result = new StringBuilder();
        if (words == null || words.length == 0) return result;
        if (words.length==1 || words[0].equals("")) return result.append(words[0]);

        ArrayList<String> wordsList = new ArrayList<>();

        wordsList.addAll(Arrays.asList(words));
        while (wordsList.remove("")){
            wordsList.remove("");
        }
        while (isYes(wordsList)) {
            Collections.shuffle(wordsList);
        }
        for (String word: wordsList){
            result.append(word).append(" ");
        }
        result.deleteCharAt(result.length()-1);
        return result;
    }

    public static boolean isYes(ArrayList<String> wordsList) {
        for (int i = 0; i < wordsList.size() - 1; i++) {
            String firstWord = wordsList.get(i).toLowerCase();
            String secondWord = wordsList.get(i + 1).toLowerCase();
            if (firstWord.charAt(firstWord.length() - 1) != secondWord.charAt(0)) return true;
        }
        return false;
    }
}

