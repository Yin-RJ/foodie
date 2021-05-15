package com.yinrj.enums;

/**
 * @author yinrongjie
 * @version 1.0
 * @description
 * @date 2021/5/15
 */
public enum CommentsLevelEnum {
    GOOD(1, "好评"),
    NOMAL(2, "中评"),
    BAD(3, "差评");

    public Integer type;
    public String msg;

    CommentsLevelEnum(Integer type, String msg) {
        this.type = type;
        this.msg = msg;
    }
}
