package com.javarush.task.task32.task3211;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.math.BigInteger;
import java.security.MessageDigest;
import java.util.Arrays;

/* 
Целостность информации
*/

public class Solution {
    public static void main(String... args) throws Exception {
        ByteArrayOutputStream bos = new ByteArrayOutputStream();
        ObjectOutputStream oos = new ObjectOutputStream(bos);
        oos.writeObject(new String("test string"));
        oos.flush();
        System.out.println(compareMD5(bos, "5a47d12a2e3f9fecf2d9ba1fd98152eb")); //true

    }

    public static boolean compareMD5(ByteArrayOutputStream byteArrayOutputStream, String md5) throws Exception {

        MessageDigest md = MessageDigest.getInstance("MD5");
        md.update(byteArrayOutputStream.toByteArray());
        byte[] mdbytes = md.digest();

        // convert byte to hex in string view
        StringBuffer sb = new StringBuffer();
        // convert the byte to hex format
        for (int i = 0; i < mdbytes.length; i++) {
//            0xff & mdbytes[i] - данная операция отрицательное число делает положительным (старшие 8 байт int становятся нулями)
            String s = Integer.toHexString(0xff & mdbytes[i]);
            s = (s.length() == 1) ? "0" + s : s;
            sb.append(s);
        }

//        BigInteger tmp = new BigInteger(1, mdbytes);
//        String hex = tmp.toString(16);
        String hex = sb.toString();
        return hex.equals(md5);
    }
}
