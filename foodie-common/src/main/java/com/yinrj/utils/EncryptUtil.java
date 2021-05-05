package com.yinrj.utils;

import com.yinrj.encrypt.MD5;

/**
 * @author yinrongjie
 * @version 1.0
 * @description
 * @date 2021/4/24
 */
public class EncryptUtil {
    public static synchronized String encrypt(String word) {
        try {
            return MD5.getMD5Str(word);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return word;
    }
}
