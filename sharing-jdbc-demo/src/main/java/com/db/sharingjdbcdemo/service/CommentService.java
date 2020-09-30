package com.db.sharingjdbcdemo.service;

import com.db.sharingjdbcdemo.domain.Comment;
import com.baomidou.mybatisplus.extension.service.IService;
public interface CommentService extends IService<Comment>{

    boolean insert(Comment comment);

}
