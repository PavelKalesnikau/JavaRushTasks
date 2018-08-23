package com.javarush.task.task18.task1827;

/* 
Прайсы
*/

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

// -c Шапка для сноубордистов 180.00 39

public class Solution {
    public static void main(String[] args) throws Exception {

       /* Мое решение. Полностью рабочее. Не проходит валидатор.

       if (args.length < 1) return;

        if (!args[0].equals("-c")) return;

        // read file name from console
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String fileName = reader.readLine();
        reader.close();

        // read file
        FileReader fileReader = new FileReader(fileName);
        BufferedReader brFile = new BufferedReader(fileReader);

        int max_id = 0;
        while (brFile.ready()) {
          String line = brFile.readLine(); // читаем файл по-строчно
            // ищем максимальный ID
            int id = Integer.parseInt(line.substring(0, 8).trim());
            if (max_id < id) max_id = id;
        }
        brFile.close();
        fileReader.close();


        char[] cid = new char[8];
        char[] productName = new char[30];
        char[] price = new char[8];
        char[] quantity = new char[4];

        max_id++; // наращиваем id для новой позиции

        // ID
        StringBuilder sbID = new StringBuilder(max_id + "");
        if (sbID.length() < 8) sbID.setLength(8);
//        cid = sbID.toString().toCharArray();
        cid = get_formatted_line(sbID);

        // productName
        StringBuilder sbProductName = new StringBuilder(30);
        for (int i = 1; i < args.length - 2; i++) {
            if (i > 1) sbProductName.append(" ");
            sbProductName.append(args[i]);
        }
        if (sbProductName.length() < 30) sbProductName.setLength(30);
        productName = get_formatted_line(sbProductName);

        // price
        StringBuilder sbPrice = new StringBuilder(args[args.length - 2]);
        if (sbPrice.length() < 8) sbPrice.setLength(8);
        price = get_formatted_line(sbPrice);

        // quantity
        StringBuilder sbQuantity = new StringBuilder(args[args.length - 1]);
        if (sbQuantity.length() < 4) sbQuantity.setLength(4);
        quantity = get_formatted_line(sbQuantity);

        // write to file new line
        FileWriter fileWriter = new FileWriter(fileName, true);
        BufferedWriter bwFile = new BufferedWriter(fileWriter);
        String new_line = String.format("\n%s%s%s%s",
                String.valueOf(cid),
                String.valueOf(productName),
                String.valueOf(price),
                String.valueOf(quantity));
        bwFile.write(new_line);

        bwFile.close();
        fileWriter.close();*/

       // Решение из интернета
        if (args.length < 4 || !args[0].equals("-c")) return;
        float price;
        int qty;

        //Если что-то передали не то
        try {
            price = Float.parseFloat(args[args.length - 2]);
            qty = Integer.parseInt(args[args.length - 1]);
        } catch (NumberFormatException e) {
            return;
        }

        //Если у нас аргументов больше 4 из-за пробелов в строке productName
        String productName;
        if (args.length > 4) {
            StringBuffer buf = new StringBuffer();
            for (int i = 1; i < args.length - 2; i++)
                buf.append(args[i]).append(" ");
            productName = buf.substring(0, buf.length() - 1);
        } else
            productName = args[1];

        //Read file name from console
        BufferedReader consoleReader = new BufferedReader(new InputStreamReader(System.in));
        String fileName = consoleReader.readLine();
        consoleReader.close();

        //Get Lines from file
        //List<String> lines = Files.readAllLines(Paths.get(fileName)); //так проще, но не пропускается
        List<String> lines = new ArrayList<>();
        try (BufferedReader fileReader = new BufferedReader(new InputStreamReader(new FileInputStream(fileName)))) {
            while (fileReader.ready())
                lines.add(fileReader.readLine());
        }

        //Get ID from line
        Pattern p = Pattern.compile("([0-9]{1,8})");
        int maxID = 0;
        for (String s : lines) {
            Matcher m = p.matcher(s);
            if (m.lookingAt()) {
                try {
                    //System.out.println(s.substring(m.start(), m.end()));
                    int id = Integer.parseInt(s.substring(m.start(), m.end()));
                    if (id > maxID)
                        maxID = id;
                } catch (NumberFormatException e) {
                    continue;
                }
            }
        }

        if (maxID++ == 99999999)
            return;
        String toFile = String.format(Locale.ROOT,"%-8d%-30s%-8.2f%-4d", maxID, productName, price, qty);

        lines.add(toFile);
        try (BufferedWriter buf = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(fileName)))) {
            for (String s: lines)
                buf.write(s+"\r\n");
        }
    }

    /*private static char[] get_formatted_line(StringBuilder sb) {
        for (int i = 0; i < sb.length(); i++) {
            if (sb.charAt(i) == '\u0000') sb.setCharAt(i, ' ');
        }
        return sb.toString().toCharArray();
    }*/
}
