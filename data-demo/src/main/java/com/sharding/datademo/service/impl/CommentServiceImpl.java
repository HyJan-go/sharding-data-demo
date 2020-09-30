package com.sharding.datademo.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.sharding.datademo.domain.Comment;
import com.sharding.datademo.mapper.CommentMapper;
import com.sharding.datademo.service.CommentService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class CommentServiceImpl extends ServiceImpl<CommentMapper, Comment> implements CommentService {

    @Resource
    private CommentMapper commentMapper;

    @Override
    public List<Comment> selectBatchByIds(List<Integer> ids) {
        return commentMapper.selectBatchByIds(ids);
    }
}
