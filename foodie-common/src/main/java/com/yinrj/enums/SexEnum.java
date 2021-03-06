package com.yinrj.enums;

/**
 * @author yinrongjie
 * @version 1.0
 * @description
 * @date 2021/5/9
 */
public enum SexEnum {
    WOMAN(0, "女"),
    MAN(1, "男"),
    SECRET(2, "保密");

    public final Integer type;
    public final String value;

    SexEnum(Integer type, String value) {
        this.type = type;
        this.value = value;
    }
}
