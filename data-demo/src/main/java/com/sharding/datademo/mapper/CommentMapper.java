package com.sharding.datademo.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.sharding.datademo.domain.Comment;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface CommentMapper extends BaseMapper<Comment> {

    List<Comment> selectBatchByIds(@Param("list") List<Integer> list);

}