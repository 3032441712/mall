package com.dragon.mall.util;

import java.io.UnsupportedEncodingException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class EncryptUtil {
    public static String MD5(String inStr) {
        String result = null;
        char hexDigits[] = { '0', '1', '2', '3', '4', '5', '6', '7', '8', '9',
                'a', 'b', 'c', 'd', 'e', 'f' };
        if (inStr != null) {
            try {
                MessageDigest md = MessageDigest.getInstance("MD5");
                byte[] source = inStr.getBytes("utf-8");
                md.update(source);
                byte[] tmp = md.digest();
                char[] str = new char[32];

                for (int i = 0, j = 0; i < 16; i++) {
                    byte b = tmp[i];
                    str[j++] = hexDigits[b >>> 4 & 0xf];
                    str[j++] = hexDigits[b & 0xf];
                }

                result = new String(str);
            } catch (NoSuchAlgorithmException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            } catch (UnsupportedEncodingException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
        }

        return result;
    }
}
