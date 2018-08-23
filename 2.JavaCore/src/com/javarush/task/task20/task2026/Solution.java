package com.javarush.task.task20.task2026;

/* 
Алгоритмы-прямоугольники
*/
public class Solution {
    private static int N;

    public static void main(String[] args) {
/*
        byte[][] a = new byte[][]{
                {1, 1, 0, 0},
                {1, 1, 0, 0},
                {1, 1, 0, 0},
                {1, 1, 0, 1}
        };
*/
        byte[][] a = new byte[][]{
                {1, 1, 0, 1},
                {1, 1, 0, 1},
                {0, 0, 0, 0},
                {1, 1, 0, 1}
        };
        int count = getRectangleCount(a);
        System.out.println("count = " + count + ". Должно быть 4");
    }

    public static int getRectangleCount(byte[][] a) {
        N = a.length;
        char[][] b = new char[N][N];
        int count = 0;
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                b[i][j] = ' ';
            }
        }

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if (a[i][j] == 1 && b[i][j] == ' ') {
                    markRectangle(i, j, a, b);
                    count++;
                } else continue;
            }
        }

        return count;
    }

    private static void markRectangle(int x, int y, byte[][] a, char[][] b) {

        for (int i = x; i < N; i++) {
            for (int j = y; j < N; j++) {
                if (a[i][j] == 1) {
                    b[i][j] = 'X';
                } else
                    break;
            }
            if (i< N-1 && a[i+1][y] == 0) break;
        }
    }
}
