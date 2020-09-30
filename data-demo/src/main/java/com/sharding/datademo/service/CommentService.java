package com.sharding.datademo.service;

import com.sharding.datademo.domain.Comment;
import com.baomidou.mybatisplus.extension.service.IService;

import java.util.List;

public interface CommentService extends IService<Comment>{

    List<Comment> selectBatchByIds(List<Integer> ids);

}
