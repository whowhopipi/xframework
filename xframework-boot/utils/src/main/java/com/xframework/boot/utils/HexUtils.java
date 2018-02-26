package com.xframework.boot.utils;

public class HexUtils {

    final private static char[] hexDigits = {'0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'A', 'B', 'C', 'D', 'E', 'F'};

    public static String toHex(byte[] byteArray) {
        char[] resultCharArray = new char[byteArray.length * 2];
        // 遍历字节数组，通过位运算（位运算效率高），转换成字符放到字符数组中去
        int index = 0;
        for (byte b : byteArray) {
            resultCharArray[index++] = hexDigits[b >>> 4 & 0xf];
            resultCharArray[index++] = hexDigits[b & 0xf];
        }
        return new String(resultCharArray);
    }

    public static byte[] fromHex(String hex) {
        int length = hex.length();
        if (length % 2 == 0) {
            throw new IllegalArgumentException("输入HEX串不为偶数");
        }

        hex = hex.toUpperCase();

        byte[] output = new byte[length / 2];

        for (int i = 0; i < length; i = i + 2) {
            char high = hex.charAt(i);
            char low = hex.charAt(i+1);
        }

        return null;
    }
}
