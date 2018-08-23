package com.javarush.task.task22.task2207;

import java.io.*;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

/* 
Обращенные слова
*/
public class Solution {
    public static List<Pair> result = new LinkedList<>();

    public Solution() {
    }

    public static void main(String[] args) throws IOException {
        /*
        Мой вариант полносью рабочий, но не проходит валидатор

        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        String fileName = bufferedReader.readLine(); // c:\temp\test.txt
        bufferedReader.close();

//        BufferedReader fileReader = new BufferedReader(new FileReader(fileName));
        BufferedReader fileReader = new BufferedReader(new InputStreamReader(new FileInputStream(fileName),"UTF-8"));
        StringBuilder sb = new StringBuilder();
        while (fileReader.ready()){
            sb.append(fileReader.readLine()).append(" ");
        }
//        String[] words = sb.toString().split(" ");
        String[] words = sb.toString().split("\\s+");
        for (int i = 0; i < words.length; i++) {
            boolean put = false;
            String word = words[i];
            String reversed = new StringBuilder(word).reverse().toString();
            for (int j = i; j < words.length; j++) {
                if (put || isContain(word)) break;
                if (reversed.equals(words[j])){
                    Pair pair = new Pair();
                    pair.setFirst(word);
                    pair.setSecond(reversed);
                    result.add(pair);
                    put = true;
                }
            }
        }
        System.out.println(result);
        */

        // Вариант из интернета
        BufferedReader reader1 = new BufferedReader(new InputStreamReader(System.in));
        BufferedReader reader = new BufferedReader(new FileReader(reader1.readLine()));
        StringBuilder s = new StringBuilder();
        Map<String,String> hashmap = new HashMap<String,String>();
        while (reader.ready())
        {
            s.append(reader.readLine() +" ");
        }
        String[] strings = s.toString().split(" ");
        for (int i = 0; i < strings.length-1; i++)
        {
            for (int j = i+1; j < strings.length; j++)
            {
                if (strings[i].equals(new StringBuilder(strings[j]).reverse().toString()))
                {
                    hashmap.put(strings[i],strings[j]);
                }
            }
        }
        for (Map.Entry<String,String> pair : hashmap.entrySet())
        {
            Pair temp = new Pair();
            temp.setFirst(pair.getKey());
            temp.setSecond(pair.getValue());
//            result.add(new Pair(pair.getKey(),pair.getValue()));
            result.add(temp);
        }
        for (Pair pair: result)
        {
            System.out.println(pair);
        }
    }
    public static boolean isContain(String word){
        for (Pair pair : result) {
            if (pair.getSecond().equals(word)) // find reversed
                return true;
        }
        return false;
    }

    public static class Pair {
        String first;
        String second;

        public Pair() {
        }

        public void setFirst(String first) {
            this.first = first;
        }

        public void setSecond(String second) {
            this.second = second;
        }

        public String getSecond() {
            return second;
        }

        public String getFirst() {
            return first;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;

            Pair pair = (Pair) o;

            if (first != null ? !first.equals(pair.first) : pair.first != null) return false;
            return second != null ? second.equals(pair.second) : pair.second == null;

        }

        @Override
        public int hashCode() {
            int result = first != null ? first.hashCode() : 0;
            result = 31 * result + (second != null ? second.hashCode() : 0);
            return result;
        }

        @Override
        public String toString() {
            return  first == null && second == null ? "" :
                    first == null && second != null ? second :
                    second == null && first != null ? first :
                    first.compareTo(second) < 0 ? first + " " + second : second + " " + first;

        }

    }

}
