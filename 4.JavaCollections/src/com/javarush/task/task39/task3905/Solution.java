package com.javarush.task.task39.task3905;

/* 
Залей меня полностью
*/
public class Solution {
    public static void main(String[] args) {
    Color [][] picture = new Color[][]{{Color.GREEN, Color.GREEN, Color.GREEN, Color.GREEN, Color.GREEN, Color.GREEN, Color.GREEN, Color.GREEN},
                                       {Color.GREEN, Color.GREEN, Color.ORANGE, Color.ORANGE, Color.ORANGE, Color.ORANGE,Color.ORANGE, Color.GREEN},
                                       {Color.GREEN, Color.ORANGE, Color.ORANGE, Color.ORANGE, Color.ORANGE, Color.ORANGE, Color.GREEN, Color.GREEN},
                                       {Color.GREEN, Color.GREEN, Color.ORANGE,  Color.GREEN, Color.GREEN, Color.ORANGE, Color.ORANGE, Color.GREEN},
                                       {Color.GREEN, Color.ORANGE, Color.ORANGE,  Color.GREEN, Color.GREEN, Color.ORANGE, Color.GREEN, Color.GREEN},
                                       {Color.GREEN, Color.GREEN, Color.ORANGE, Color.ORANGE, Color.ORANGE, Color.ORANGE, Color.ORANGE, Color.GREEN},
                                       {Color.GREEN, Color.ORANGE, Color.ORANGE,  Color.ORANGE, Color.ORANGE, Color.ORANGE, Color.ORANGE, Color.GREEN},
                                       {Color.GREEN, Color.GREEN, Color.GREEN,  Color.GREEN, Color.GREEN, Color.GREEN, Color.GREEN, Color.GREEN}};
        for (int i = 0; i < picture.length; i++) {
            for (int j = 0; j < picture[0].length; j++) {
                System.out.print(picture[i][j] + "  ");
            }
            System.out.println();
        }
        System.out.println();
        System.out.println();

        new PhotoPaint().paintFill(picture, 0,1, Color.BLUE);

        for (int i = 0; i < picture.length; i++) {
            for (int j = 0; j < picture[0].length; j++) {
                System.out.print(picture[i][j] + "  ");
            }
            System.out.println();
        }

    }
}
