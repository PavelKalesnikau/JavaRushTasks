package com.javarush.task.task20.task2027;

import java.util.ArrayList;
import java.util.List;

/* 
Кроссворд
*/
public class Solution {
   static private int N_ROW, N_CLMN;

    public static void main(String[] args) {
        int[][] crossword = new int[][]{
                {'f', 'd', 'e', 'r', 'l', 'k'},
                {'u', 's', 'a', 'm', 'e', 'o'},
                {'l', 'n', 'g', 'r', 'o', 'v'},
                {'m', 'l', 'p', 'r', 'r', 'h'},
                {'p', 'o', 'e', 'e', 'j', 'j'}
        };
        System.out.println(detectAllWords(crossword, "home", "same"));
//        System.out.println(detectAllWords(crossword, "homel", "sames", "emoh", "emas", "fderlk", "klredf",
//                "fulmp", "poeejj", "jjeeop", "pmluf", "kovhj", "jhvok", "lprr", "rrpl", "lprr", "voel",
//                "lock", "r", "re", "eo", "oe", null, "", " "));
        /*
Ожидаемый результат
home - (5, 3) - (2, 0)
same - (1, 1) - (4, 1)
         */
    }

    enum DIRECTION{
        UP,
        DOWN,
        LEFT,
        RIGHT,
        UP_LEFT,
        UP_RIGHT,
        DOWN_LEFT,
        DOWN_RIGHT
    }
    public static List<Word> detectAllWords(int[][] crossword, String... words) {
        N_ROW = crossword.length;
        N_CLMN = crossword[0].length;

        ArrayList<Word> wordsList = new ArrayList<Word>();

        for (String word: words ) {
            if (word == null || word.length()==0) continue;

            for (int x = 0; x < N_CLMN; x++) {
                for (int y = 0; y < N_ROW; y++) {
                    char letter = word.charAt(0); // looking for first letter
                    if ( letter == crossword[y][x]){
                        Word find = findWord(crossword, word, x, y);
                        if (find != null) wordsList.add(find);
                    }
                }
            }
        }
        return wordsList;
    }

    private static Word findWord(int[][] crossword, String word, int start_x, int start_y) {
        int end_x, end_y;
        Word find = null;
        for (DIRECTION direction: DIRECTION.values()) {
            switch (direction){
                case UP:
                    find = findUP(crossword, word, start_x, start_y);
                    break;
                case DOWN:
                    find = findDOWN(crossword, word, start_x, start_y);
                    break;
                case RIGHT:
                    find = findRIGHT(crossword, word, start_x, start_y);
                    break;
                case LEFT:
                    find = findLEFT(crossword, word, start_x, start_y);
                    break;
                case UP_LEFT:
                    find = findUPLEFT(crossword, word, start_x, start_y);
                    break;
                case UP_RIGHT:
                    find = findUPRIGHT(crossword, word, start_x, start_y);
                    break;
                case DOWN_LEFT:
                    find = findDOWNLEFT(crossword, word, start_x, start_y);
                    break;
                case DOWN_RIGHT:
                    find = findDOWNRIGHT(crossword, word, start_x, start_y);
                    break;
            }
            if (find != null) return find;
        }
        return null;
    }
    private static Word findUP(int[][] crossword, String word, int start_x, int start_y){
        int x = start_x; // X-кордината первой буквы, ее будем уменьшать на 1 для движения UP
        int k = 1; // вторая буква слова
        int length = word.length();
        while (x > 0 && k < length){
            x--; // переход вверх: : начинаем со второй буквы слова word
            char c = (char) crossword[start_y][x];
            if (word.charAt(k++) != c) return null;
        }
        if(k != length) return null; // не нашли слово целиком
//        if (x == start_x && length > 1) return null;
        if (x == start_x) return null;

        Word find = new Word(word);
        find.setStartPoint(start_x, start_y);
        find.setEndPoint(x, start_y);
        return find;
    }
    private static Word findDOWN(int[][] crossword, String word, int start_x, int start_y){
        int x = start_x; // X-кордината первой буквы, ее будем увеличивать на 1 для движения DOWN
        int k = 1; // вторая буква слова
        int length = word.length();
        while (x < N_ROW-1 && k < length){
            x++; // переход вниз: : начинаем со второй буквы слова word
            char c = (char) crossword[start_y][x];
            if (word.charAt(k++) != c) return null;
        }
        if(k != length) return null; // не нашли слово целиком
//        if (x == start_x && length > 1) return null;
        if (x == start_x) return null;

        Word find = new Word(word);
        find.setStartPoint(start_x, start_y);
        find.setEndPoint(x, start_y);
        return find;
    }
    private static Word findLEFT(int[][] crossword, String word, int start_x, int start_y){
        int y = start_y; // Y-кордината первой буквы, ее будем уменьшать на 1 для движения LEFT
        int k = 1; // вторая буква слова
        int length = word.length();
        while (y > 0 && k < length){
            y--; // переход влево: начинаем со второй буквы слова word
            char c = (char) crossword[y][start_x];
            if (word.charAt(k++) != c) return null;
        }
        if(k != length) return null; // не нашли слово целиком
//        if (y == start_y && length > 1) return null;
        if (y == start_y) return null;

        Word find = new Word(word);
        find.setStartPoint(start_x, start_y);
        find.setEndPoint(start_x, y);
        return find;
    }
    private static Word findRIGHT(int[][] crossword, String word, int start_x, int start_y){
        int y = start_y; // Y-кордината первой буквы, ее будем увеличивать на 1 для движения RIGHT
        int k = 1; // вторая буква слова
        int length = word.length();
        while (y < N_CLMN-1 && k < length){
            y++; // переход вправо: начинаем со второй буквы слова word
            char c = (char) crossword[y][start_x];
            if (word.charAt(k++) != c) return null;
        }
        if(k != length) return null; // не нашли слово целиком
//        if (y == start_y && length > 1) return null;
        if (y == start_y) return null;

        Word find = new Word(word);
        find.setStartPoint(start_x, start_y);
        find.setEndPoint(start_x, y);
        return find;
    }

    private static Word findUPRIGHT(int[][] crossword, String word, int start_x, int start_y){
        int x = start_x; // X-кордината первой буквы, ее будем уменьшать на 1 для движения UP
        int y = start_y; // Y-кордината первой буквы, ее будем увеличивать на 1 для движения RIGHT
        int k = 1; // вторая буква слова
        int length = word.length();
        while (x > 0 && y < N_CLMN-1 && k < length){
            x--; // переход вверх: : начинаем со второй буквы слова word
            y++; // переход вправо: начинаем со второй буквы слова word
            char c = (char) crossword[y][x];
            if (word.charAt(k++) != c) return null;
        }
        if(k != length) return null; // не нашли слово целиком
//        if (x == start_x && length > 1) || (y == start_y && length > 1)) return null;
        if (x == start_x && y == start_y) return null;

        Word find = new Word(word);
        find.setStartPoint(start_x, start_y);
        find.setEndPoint(x, y);
        return find;
    }
    private static Word findUPLEFT(int[][] crossword, String word, int start_x, int start_y){
        int x = start_x; // X-кордината первой буквы, ее будем уменьшать на 1 для движения UP
        int y = start_y; // Y-кордината первой буквы, ее будем уменьшать на 1 для движения LEFT
        int k = 1; // вторая буква слова
        int length = word.length();
        while (x > 0 && y > 0 && k < length){
            x--; // переход вверх: : начинаем со второй буквы слова word
            y--; // переход влево: начинаем со второй буквы слова word
            char c = (char) crossword[y][x];
            if (word.charAt(k++) != c) return null;
        }
        if(k != length) return null; // не нашли слово целиком
//        if ((x == start_x && length > 1) || (y == start_y && length > 1)) return null;
        if (x == start_x && y == start_y) return null;

        Word find = new Word(word);
        find.setStartPoint(start_x, start_y);
        find.setEndPoint(x, y);
        return find;
    }
    private static Word findDOWNLEFT(int[][] crossword, String word, int start_x, int start_y){
        int x = start_x; // X-кордината первой буквы, ее будем увеличивать на 1 для движения DOWN
        int y = start_y; // Y-кордината первой буквы, ее будем уменьшать на 1 для движения LEFT
        int k = 1; // вторая буква слова
        int length = word.length();
        while (x < N_ROW-1 && y > 0 && k < length){
            x++; // переход вниз: : начинаем со второй буквы слова word
            y--; // переход влево: начинаем со второй буквы слова word
            char c = (char) crossword[y][x];
            if (word.charAt(k++) != c) return null;
        }
        if(k != length) return null; // не нашли слово целиком
//        if ((x == start_x && length > 1) || (y == start_y && length > 1)) return null;
        if (x == start_x && y == start_y) return null;

        Word find = new Word(word);
        find.setStartPoint(start_x, start_y);
        find.setEndPoint(x, y);
        return find;
    }
    private static Word findDOWNRIGHT(int[][] crossword, String word, int start_x, int start_y){
        int x = start_x; // X-кордината первой буквы, ее будем увеличивать на 1 для движения DOWN
        int y = start_y; // Y-кордината первой буквы, ее будем увеличивтаь на 1 для движения RIGHT
        int k = 1; // вторая буква слова
        int length = word.length();
        while (x < N_ROW-1 && y < N_CLMN-1 && k < length){
            x++; // переход вниз: : начинаем со второй буквы слова word
            y++; // переход вправо: начинаем со второй буквы слова word
            char c = (char) crossword[y][x];
            if (word.charAt(k++) != c) return null;
        }
        if(k != length) return null; // не нашли слово целиком
//        if ((x == start_x && length > 1) || (y == start_y && length > 1)) return null;
        if (x == start_x && y == start_y) return null;

        Word find = new Word(word);
        find.setStartPoint(start_x, start_y);
        find.setEndPoint(x, y);
        return find;
    }


    public static class Word {
        private String text;
        private int startX;
        private int startY;
        private int endX;
        private int endY;

        public Word(String text) {
            this.text = text;
        }

        public void setStartPoint(int i, int j) {
            startX = i;
            startY = j;
        }

        public void setEndPoint(int i, int j) {
            endX = i;
            endY = j;
        }

        @Override
        public String toString() {
            return String.format("%s - (%d, %d) - (%d, %d)", text, startX, startY, endX, endY);
        }
    }
}
