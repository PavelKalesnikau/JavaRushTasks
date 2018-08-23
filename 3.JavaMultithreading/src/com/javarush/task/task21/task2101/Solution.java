package com.javarush.task.task21.task2101;

/* 
Определяем адрес сети
*/
public class Solution {
    public static void main(String[] args) {
        byte[] ip = new byte[]{(byte) 192, (byte) 168, 1, 2};
        byte[] mask = new byte[]{(byte) 255, (byte) 255, (byte) 254, 0};
        byte[] netAddress = getNetAddress(ip, mask);
        print(ip);          //11000000 10101000 00000001 00000010
        print(mask);        //11111111 11111111 11111110 00000000
        print(netAddress);  //11000000 10101000 00000000 00000000
    }

    public static byte[] getNetAddress(byte[] ip, byte[] mask) {
        byte[] netAddress = new byte[4];
        netAddress[0] = (byte) (ip[0] & mask[0]);
        netAddress[1] = (byte) (ip[1] & mask[1]);
        netAddress[2] = (byte) (ip[2] & mask[2]);
        netAddress[3] = (byte) (ip[3] & mask[3]);
        return netAddress;
    }

    public static void print(byte[] bytes) {
        System.out.print(padd(Integer.toBinaryString(bytes[0]), 8) + " " +
                padd(Integer.toBinaryString(bytes[1]), 8) + " " +
                padd(Integer.toBinaryString(bytes[2]), 8) + " "  +
                padd(Integer.toBinaryString(bytes[3]), 8) );
        System.out.println();
    }
    private static String padd(String binString, int wantedLength){
        if (binString.length() < wantedLength){
            StringBuilder sb = new StringBuilder(binString);
            while (sb.length() < wantedLength) sb.insert(0, "0");
            return sb.toString();
        }else if (binString.length() > wantedLength) {
            return binString.substring(binString.length()-wantedLength);
        }else{
            return binString;
        }
    }
}
