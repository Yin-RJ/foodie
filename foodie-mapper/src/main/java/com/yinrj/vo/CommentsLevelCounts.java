package com.yinrj.vo;

import lombok.AllArgsConstructor;
import lombok.Data;

/**
 * @author yinrongjie
 * @version 1.0
 * @description
 * @date 2021/5/15
 */
@Data
@AllArgsConstructor
public class CommentsLevelCounts {
    private Integer totalCounts;
    private Integer goodCounts;
    private Integer normalCounts;
    private Integer badCounts;
}
