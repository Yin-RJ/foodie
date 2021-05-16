package com.yinrj.enums;

/**
 * @author yinrongjie
 * @version 1.0
 * @description
 * @date 2021/5/17
 */
public enum YesNoEnum {
    YES(1, "是"),
    NO(0, "否");

    public Integer type;
    public String msg;

    YesNoEnum(Integer type, String msg) {
        this.type = type;
        this.msg = msg;
    }
}
