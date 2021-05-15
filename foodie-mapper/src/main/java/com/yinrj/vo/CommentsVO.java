package com.yinrj.vo;

import lombok.Data;

import java.util.Date;

/**
 * @author yinrongjie
 * @version 1.0
 * @description
 * @date 2021/5/15
 */
@Data
public class CommentsVO {
    private Integer commentLevel;
    private Date createTime;
    private String content;
    private String userFace;
    private String nickname;
    private String sepcName;
}
