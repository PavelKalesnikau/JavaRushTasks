package com.javarush.task.task30.task3012;

/* 
Получи заданное число
*/

public class Solution {
    public static void main(String[] args) {
        Solution solution = new Solution();
        solution.createExpression(74);
    }

    public void createExpression(int number) {
        StringBuilder resultToPrint = new StringBuilder(number + " =");
        String result3 = convertTo3(number);

        for (int i = 0; i < result3.length(); i++) {
            int n = 0;
            char c = result3.charAt(i);
            switch (c){
                case '2': // -1
                case '1': // +1

                    if (c == '2') resultToPrint.append(" - ");
                    else if(c == '1') resultToPrint.append(" + ");

                    n = (int) (Math.pow(3, i));

                    resultToPrint.append(n);

                    break;
                case '0': // 0
                    // just skip it
                    break;
            }
        }
        System.out.println(resultToPrint);
    }

    private String convertTo3(int number) {
        String result;
        if (number == 1) return new StringBuilder("1").toString();
        if (number % 3 == 1) {
            return new StringBuilder("1").append(convertTo3(number / 3)).toString();
        } else if (number % 3 > 1) {
            // 2 = -1
            return new StringBuilder("2").append(convertTo3((number + 1) / 3)).toString();
        } else
            return new StringBuilder("0").append(convertTo3(number / 3)).toString();
    }
}
