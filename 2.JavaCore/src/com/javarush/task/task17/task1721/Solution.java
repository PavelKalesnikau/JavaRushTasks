package com.javarush.task.task17.task1721;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

/* 
Транзакционность
*/

public class Solution {
    public static List<String> allLines = new ArrayList<String>();
    public static List<String> forRemoveLines = new ArrayList<String>();

    public static void main(String[] args) {

        try {
            Solution solution = new Solution();

            BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
            String filename1 = reader.readLine();
            String filename2 = reader.readLine();
            reader.close();

            InputStreamReader isReader1 = new InputStreamReader(new FileInputStream(filename1));
            BufferedReader fReader1 = new BufferedReader(isReader1);

            String line;
            while ((line = fReader1.readLine()) != null) allLines.add(line);

            InputStreamReader isReader2 = new InputStreamReader(new FileInputStream(filename2));
            BufferedReader fReader2 = new BufferedReader(isReader2);

            while ((line = fReader2.readLine()) != null) forRemoveLines.add(line);

            isReader1.close();
            isReader2.close();
            fReader1.close();
            fReader2.close();

            // локальные копии
            List<String> allLines_local = new ArrayList<String>();
            List<String> forRemoveLines_local = new ArrayList<String>();

//            solution.allLines_local.addAll(allLines);
//            solution.forRemoveLines_local.addAll(forRemoveLines);

            solution.joinData();

//            allLines.clear();
//            forRemoveLines.clear();
//            allLines.addAll(solution.allLines_local);
//            forRemoveLines.addAll(solution.forRemoveLines_local);

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void joinData() throws CorruptedDataException {
        if (allLines.containsAll(forRemoveLines)) allLines.removeAll(forRemoveLines);
        else {
            allLines.clear();
            throw new CorruptedDataException();
        }
    }
}
