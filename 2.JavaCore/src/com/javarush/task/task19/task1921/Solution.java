package com.javarush.task.task19.task1921;

import java.io.FileReader;
import java.io.IOException;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

/* 
Хуан Хуанович
*/

public class Solution {
    public static final List<Person> PEOPLE = new ArrayList<Person>();

    public static void main(String[] args) throws IOException, ParseException {
        if (args.length == 0) return;

        String fileName = args[0];
        // c:\temp\names2.txt
        FileReader fileReader = new FileReader(fileName);

        // Read entire file into ArrayList with help of FileReader
        ArrayList<String> file = new ArrayList<String>();
        StringBuilder contentBuilder = new StringBuilder();
        while (fileReader.ready()) {
            int i = fileReader.read();
            if (i != 10 && i != 13) contentBuilder.append((char) i);
            else {
                if (i == 10) {
                    file.add(contentBuilder.toString());
                    contentBuilder.delete(0, contentBuilder.length());
                }
            }
        }
        file.add(contentBuilder.toString()); // put the last string into ArrayList
        fileReader.close();

        // Parse file data
        for (String line : file) {
            String[] words = line.split(" ");
            StringBuilder name = new StringBuilder();
            for (int i = 0; i < words.length-3; i++) {
                // Parse name
                name.append(words[i]+" ");
            }
            String date = words[words.length-3]+" "  // day
                    +     words[words.length-2]+" "  // month
                    +     words[words.length-1];     // year
            DateFormat dateFormat = new SimpleDateFormat("dd MM yyyy", Locale.ENGLISH);
            PEOPLE.add(new Person(name.toString().trim(), dateFormat.parse(date)));
        }
    }
}
