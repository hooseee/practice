package com.hsen.merkleTree;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

/**
 * @ProjectName: hsen
 * @Package: com.hsen.utils
 * @Author: sen
 * @CreateDate: 2018/6/12 21:47
 * @Description: java类作用描述
 * @Version: 1.0
 * Copyright: Copyright (c) 2018
 **/
public class EncryHex {

    public static String getSHA2Hex(String data) {
        byte[] hex_byte;
        try {
            MessageDigest md = MessageDigest.getInstance("SHA-256");
            md.update(data.getBytes());
            hex_byte = md.digest();
            StringBuilder sb = new StringBuilder(2 * hex_byte.length);

            for (byte b : hex_byte) {
                sb.append(String.format("%02x", b & 0xff));
            }
            return sb.toString();
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        }

        return "";

    }
}
