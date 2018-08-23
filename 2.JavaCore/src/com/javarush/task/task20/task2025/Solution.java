package com.javarush.task.task20.task2025;

/*
Алгоритмы-числа
*/

import java.util.*;

/*
Задача

        Натуральное десятичное N - значное число называется числом Армстронга, если сумма его цифр, возведенных в степень N, равна самому числу.

        Примеры: 153 = 13 + 53 + 33 ; 1634 = 14 + 64 + 34 + 44.

        Найти все числа Армстронга для 1<=N<=9.

Решение

        Конечно, данную задачу можно было решить "в лоб", т.е. сделать простой перебор всех 109 чисел и каждое число проверить.
        При этом на весьма солидной машине программа могла бы работать достаточно долго. Если бы цель задания заключалась только в нахождении чисел Армстронга,
        а не в составлении универсальной программы, разработка которой могла бы занимать большое время, то конечно, лучше было бы за 10 минут написать и 3 часа подождать.

        Идея уменьшения класса исследуемых чисел заключается в следующем : можно делать перебор не самих чисел, а значений,
        которые могут получаться в результате степенной суммы ( т.е. суммы цифр числа, возведенных в степень числа цифр этого числа ).
        Здесь используется следующее свойство : от перемены цифр местами в числе степенная сумма не меняется. Т.е. например,
        незачем рассматривать все числа из класса : 135, 153, 315, 351, 531 и 513; достаточно рассмотреть одно из них, например, число 135;
        вычислить его степенную сумму : (135)ст = 153, а потом лишь убедиться в том что число 153 - это число Армстронга.
        Этот метод снижает число перебираемых чисел почти в N! раз. Сам же перебор осуществляется довольно просто : рассматриваются все числа,
        у которых любая цифра не меньше предыдущей и не больше последующей. Например: 12, 1557, 333 и т.д.

        Итак, вышеописанный метод снизил число перебираемых чисел с 109 до приблизительно 200000. Но это не все на чем стоит остановливаться.
        Можно применить еще одну хитрость, которая заключается в следующем : можно значительно ускорить вычисление степенной суммы.
        Можно заметить, что при вычислениях часто приходится многократно возводить некоторое число в некоторую степень.
        Чтобы это оптимизировать вводится двухмерный массив, в i-ой строке и j-ом столбце которого находится значение степенной суммы i с основанием j
        (например, Degree[123,j] = 1j + 2j + 3j ). Таким образом , используется значение массива Degree[i,j].
        Это существенно ускоряет процесс вычисления, если это сравнивать с некоторым процессом, в котором используется функция Degree(i,j),
        каждый раз вычисляющая значение ij. Для вычисления выражения 10j аналогичнo используется массив Degree10.
        Нужно заметить, что такая операция возведения в степень в программе вы полняется более 10000 раз; матрица Degree заполняется в начале программы,
        где операция возведения i в степень j выполняется около 8000 раз.

        В промежутке 1<=N<=9 программа находит следующие 32 числа Армстронга:

        0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 153, 370, 371, 407, 1634, 8208, 9474, 54748, 92727, 93084, 548834, 1741725, 4210818, 9800817,
        9926315, 24678050, 24678051, 88593477, 146511208, 472335975, 534494836, 912985153.
*/
//***********************************************************
/*

/*public class Solution {
    static private long[][] pows = null;

    public static long[] getNumbers(long N) {
        long[] result = null;

        ArrayList<Long> list = new ArrayList<Long>();

        pows = build_pows();

        for (long i = 0; i < N; i++) {

            if (!(isFit(i))) continue;
            long number = get_sum(i);


            if (list.contains(number)) continue;
            if (!isArmstrong(number)) continue;

            list.add(number);
        }
        int size = list.size();
        Collections.sort(list);

        result = new long[size];
        for (int i = 0; i < size; i++) {
            result[i] = list.get(i);
        }

        return result;
    }

    private static long[][] build_pows() {
        long[][] pows = new long[11][10];
        pows[1][0] = 0;
        pows[1][1] = 1;
        pows[1][2] = 2;
        pows[1][3] = 3;
        pows[1][4] = 4;
        pows[1][5] = 5;
        pows[1][6] = 6;
        pows[1][7] = 7;
        pows[1][8] = 8;
        pows[1][9] = 9;
        for (int i = 2; i < 11; i++) {
            for (int j = 1; j < 10; j++) {
                pows[i][j] = pows[i - 1][j] * j;
            }
        }
        return pows;
    }


*//*
    Check, if the number fit for calculation
     *//**//*
*//*
    private static boolean isFit(long N) {
*//*
        int l = get_number_length(number);

        int last = 10;
        while (number > 0) {
            if (number % 10 > last) return false;
            last = (int)( number % 10 );
            number /= 10;
        }
        return true;
*//*
        long num = N / 10;
        long last = num % 10;
        while (num > 0) {
            if (num % 10 <= last) {
                last = num % 10;
                if (last == 0) {
                    last = 10;
                }
                num = num / 10;
            } else {
                return false;
            }
        }
        return true;
    }

    private static boolean isArmstrong(long number) {
        long sum = get_sum(number);
        if (sum == number) return true;
        else return false;
    }

    private static long get_sum(long number) {
        int length = get_number_length(number);
        long sum = 0;
        for (long i = number; i > 0; i /= 10) {
            int n = (int)( i % 10 );
            try {

                sum += pows[length][n];

            } catch (ArrayIndexOutOfBoundsException ex) {
                System.err.println("number = " + number);
                System.err.println("length = " + length);
                System.err.println("n = " + n);
                throw ex;
            }
        }
        return sum;
    }

    private static int get_number_length(long number) {
        int count = 0;
        while (number > 0) {
            number /= 10;
            count++;
        }
        return count;
    }

    public static void main(String[] args) {
        long start = new Date().getTime();

        long[] result = getNumbers(1000000000);

        long end = new Date().getTime();

        System.out.printf("Time is %ds\n", (end - start) / 1000);

        for (int i = 0; i < result.length; i++) {
            System.out.println(result[i]);
        }
    }
}*/

public class Solution {
    public static long[] getNumbers(long N) {
        long[] result = null;
        TreeSet<Long> numbers = new TreeSet<>();

        //Массив степеней
        final int SIZE = 12;
        long[][] powLst = new long[SIZE][SIZE];

        //Здесь лежит нарезка цифр
        int[] lst = new int[20];


        label:
        for (long i = 1; i < N; i++) {
            // 1.Отбраковываем числа у которых сумма цифр одинаковая (сокращаем до 200 000 тыс варинтов и менее)
            // 2.Получаем нарезку цифр в виде массива
            long x = i;
            int lenCount = 0;
            int current;
            int last = Integer.MAX_VALUE;
            while (x != 0) {
                current = (int) (x % 10);
                if ((current != 0 && last != 0) && last < current)
                    continue label;
                last = current;
                lst[lenCount] = current;
                x = x / 10;
                lenCount++;
            }

            //3. Считаем степень, и заполняем таблицу степеней
            //Находим сумму степеней цифр числа, например сюда поступило 037 с пункта 2
            long summa1 = 0;
            for (int j = 0; j < lenCount; j++) {
                if (powLst[lst[j]][lenCount] == 0) { //Если в массиве степеней еще нет значения
                    long a1 = lst[j];
                    if (a1 != 0 && a1 != 1) {          //Если цифра 0 или 1, то смысла считать степень нет
                        long a2 = lst[j];
                        for (int jj = 1; jj < lenCount; jj++) //Считаем степень
                            a1 *= a2;
                    }
                    powLst[lst[j]][lenCount] = a1;//Добавляем в массив степеней новое значение
                }
                summa1 += powLst[lst[j]][lenCount];
            }
            //Например, Сумма степеней получилось = 370

            //4. Получаем нарезку цифр
            long xx = summa1;
            lenCount = 0;
            while (xx != 0) {
                lst[lenCount] = (int) (xx % 10);
                lenCount++;
                xx = xx / 10;
            }

            //5. Из полученной суммы берем сумму степеней, для проверки на  число амстронга
            long summa2 = 0;
            for (int j = 0; j < lenCount; j++) {
                if (powLst[lst[j]][lenCount] == 0) { //Если в массиве степеней еще нет значения
                    long a1 = lst[j];
                    if (a1 != 0 && a1 != 1) {          //Если цифра 0 или 1, то смысла считать степень нет
                        long a2 = lst[j];
                        for (int jj = 1; jj < lenCount; jj++) //Считаем степень
                            a1 *= a2;
                    }
                    powLst[lst[j]][lenCount] = a1;//Добавляем в массив степеней новое значение
                }
                summa2 += powLst[lst[j]][lenCount];
            }

            //6. Добавляем результат
            if (summa1 == summa2 && summa1 < N)
                numbers.add(summa1);
        }
        result = new long[numbers.size()];

        int count = 0;
        for (Long l : numbers) {
            result[count] = l;
            count++;
        }
        return result;
    }

    public static void main(String[] args) {
        Long t0 = System.currentTimeMillis();
        long[] numbers = getNumbers(Integer.MAX_VALUE);
//        long[] numbers = getNumbers(146511208);
//        int[] numbers = getNumbers(100);
        Long t1 = System.currentTimeMillis();
        System.out.println("time: " + (t1 - t0) / 1000d + " sec");
        System.out.println("memory: " + (Runtime.getRuntime().totalMemory() - Runtime.getRuntime().freeMemory()) / (1024 * 1024) + " mb");
        System.out.println(Arrays.toString(numbers));
    }
}

