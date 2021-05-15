package com.yinrj.dao;

import com.yinrj.pojo.ItemsComments;
import com.yinrj.vo.CommentsVO;
import org.apache.ibatis.annotations.Param;
import tk.mybatis.mapper.common.Mapper;
import tk.mybatis.mapper.common.MySqlMapper;

import java.util.List;
import java.util.Map;

@org.apache.ibatis.annotations.Mapper
public interface ItemsCommentsDao extends Mapper<ItemsComments>, MySqlMapper<ItemsComments> {
    List<CommentsVO> getCommentsByItemId(@Param("paramMap") Map<String, Object> map);
}