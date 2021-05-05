package com.yinrj.encrypt;

import org.apache.commons.codec.binary.Base64;

import java.security.MessageDigest;

/**
 * @author yinrongjie
 * @version 1.0
 * @description
 * @date 2021/4/24
 */
public class MD5 {
    public static String getMD5Str(String strValue) throws Exception {
        MessageDigest md5 = MessageDigest.getInstance("MD5");
        return Base64.encodeBase64String(md5.digest(strValue.getBytes()));
    }
}
