package com.xframework.boot.utils;

import lombok.extern.slf4j.Slf4j;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.security.DigestInputStream;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

@Slf4j
public class MD5Utils {

    public static String digest(String input) {
        // 输入的字符串转换成字节数组
        byte[] inputByteArray = input.getBytes();
        return digest(inputByteArray);
    }

    public static String digest(byte[] input) {
        try {
            long start = System.currentTimeMillis();
            MessageDigest messageDigest = MessageDigest.getInstance("MD5");
            // 输入的字符串转换成字节数组
            messageDigest.update(input);
            byte[] output = messageDigest.digest();
            long end = System.currentTimeMillis();
            if (log.isDebugEnabled())
                log.debug("MD5耗时：" + (end - start) + "ms");
            return HexUtils.toHex(output);
        } catch (NoSuchAlgorithmException e) {
            log.warn("MD5失败", e);
            return null;
        }
    }

    public static String digest(File file) {
        int bufferSize = 256 * 1024;

        FileInputStream fileInputStream = null;
        DigestInputStream digestInputStream = null;
        try {
            // 拿到一个MD5转换器（同样，这里可以换成SHA1）
            MessageDigest messageDigest = MessageDigest.getInstance("MD5");
            // 使用DigestInputStream
            fileInputStream = new FileInputStream(file);
            digestInputStream = new DigestInputStream(fileInputStream, messageDigest);
            // read的过程中进行MD5处理，直到读完文件
            byte[] buffer = new byte[bufferSize];
            while (digestInputStream.read(buffer) > 0) ;
            // 获取最终的MessageDigest
            messageDigest = digestInputStream.getMessageDigest();
            // 拿到结果，也是字节数组，包含16个元素
            byte[] resultByteArray = messageDigest.digest();
            // 同样，把字节数组转换成字符串
            return HexUtils.toHex(resultByteArray);
        } catch (Exception e) {
            log.warn("", e);
        } finally {
            if (digestInputStream != null) {
                try {
                    digestInputStream.close();
                } catch (IOException e) {
                    log.warn("", e);
                }
            }

            if (fileInputStream != null) {
                try {
                    fileInputStream.close();
                } catch (IOException e) {
                    log.warn("", e);
                }
            }
        }
        return null;
    }
}
