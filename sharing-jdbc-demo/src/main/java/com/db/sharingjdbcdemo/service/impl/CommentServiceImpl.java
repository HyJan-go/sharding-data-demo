package com.db.sharingjdbcdemo.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.db.sharingjdbcdemo.domain.Comment;
import com.db.sharingjdbcdemo.mapper.CommentMapper;
import com.db.sharingjdbcdemo.service.CommentService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Service
public class CommentServiceImpl extends ServiceImpl<CommentMapper, Comment> implements CommentService{

    @Resource
    private CommentMapper commentMapper;

    @Override
    public boolean insert(Comment comment) {
        int insert = commentMapper.insert(comment);
        return insert == 1 ? true : false;
    }
}
