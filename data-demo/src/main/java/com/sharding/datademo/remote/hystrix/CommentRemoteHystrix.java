package com.sharding.datademo.remote.hystrix;

import com.sharding.datademo.domain.Comment;
import com.sharding.datademo.remote.CommentRemote;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * @description: CommentRemote 调用失败后降级处理
 * @author: HyJan
 * @create: 2020-09-28 17:17
 **/
@Component
public class CommentRemoteHystrix implements CommentRemote {

    @Override
    public String insertCommentBatch(List<Comment> comments) {
        return "service is fallback";
    }

    @Override
    public String insert(Comment comment) {
        return"service is fallback";
    }

    @Override
    public Boolean isExist(Integer id) {
            return false;
    }
}
