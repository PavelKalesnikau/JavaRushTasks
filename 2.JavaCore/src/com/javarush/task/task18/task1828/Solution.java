package com.javarush.task.task18.task1828;

/* 
Прайсы 2
*/

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

// -u 19847984 Шапка для сноубордистов 182.00 54
// -d 19847985

public class Solution {
    public static void main(String[] args) throws IOException {

        // Решение из интернета
        if (args.length < 1 || !(args[0].equals("-u") || args[0].equals("-d"))) return;
        float price = 0;
        int qty = 0;

        if (args[0].equals("-u")) {
            //Если что-то передали не то
            try {
                price = Float.parseFloat(args[args.length - 2]);
                qty = Integer.parseInt(args[args.length - 1]);
            } catch (NumberFormatException e) {
                return;
            }
        }

       //Если у нас аргументов больше 4 из-за пробелов в строке productName
        String productName = null;
        if (args[0].equals("-u")) {
            if (args.length > 5) {
                StringBuffer buf = new StringBuffer();
                for (int i = 2; i < args.length - 2; i++)
                    buf.append(args[i]).append(" ");
                productName = buf.substring(0, buf.length() - 1);
            } else
                productName = args[2];
        }

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

        //Find ID in line
        Pattern p = Pattern.compile("([0-9]{1,8})");
        String ID = args[1];
        for (int i = 0; i < lines.size(); i++) {
            String line = lines.get(i);
            Matcher m = p.matcher(line);
            if (m.lookingAt()) {
                try {
                    //System.out.println(s.substring(m.start(), m.end()));
                    String id = line.substring(m.start(), m.end());
                    if (ID.equals(id)) {
                        if (args[0].equals("-u")) {
                            String replaceLine = String.format(Locale.ROOT, "%-8s%-30s%-8.2f%-4d", ID, productName, price, qty);
                            lines.remove(i);
                            lines.add(i, replaceLine);
                        } else if (args[0].equals("-d")) {
                            lines.remove(i);
                        }
                    }
                    ;
                } catch (NumberFormatException e) {
                    continue;
                }
            }
        }

        try (BufferedWriter buf = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(fileName)))) {
            for (String s : lines)
                buf.write(s + "\r\n");
        }
    }
}
