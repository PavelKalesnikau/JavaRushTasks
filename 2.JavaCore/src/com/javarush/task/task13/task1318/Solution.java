package com.javarush.task.task13.task1318;

import java.io.*;
import java.util.Scanner;

/* 
Чтение файла
*/

public class Solution {
    public static void main(String[] args) throws IOException{
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        String strFileName = bufferedReader.readLine();
        FileInputStream fileInputStream = null;
        try
        {
            fileInputStream = new FileInputStream(strFileName);
            BufferedReader br = new BufferedReader( new InputStreamReader(fileInputStream));
            String line;
            while(( line = br.readLine()) != null ) {
                System.out.println(line);
            }
            br.close();
        }
        catch (Exception e)
        {
            if(fileInputStream!=null)
                fileInputStream.close();
        }
        finally {
            if(fileInputStream!=null)
                fileInputStream.close();
        }
        bufferedReader.close();
       /* BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        String fileName = reader.readLine();

        FileInputStream fileInputStream = new FileInputStream(fileName);
        InputStreamReader isReader = new InputStreamReader(fileInputStream);
        BufferedReader fileReader = new BufferedReader(isReader);

//        while (fileInputStream.available()>0){
//            int fileByte = fileInputStream.read();
//            System.out.println((char)fileByte);
//        }

        String line;
        while ((line = fileReader.readLine()) != null) System.out.println(line);

        fileInputStream.close();
        isReader.close();
        fileReader.close();
        reader.close();*/
    }
}