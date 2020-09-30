package com.sharding.datademo.remote;

import com.sharding.datademo.domain.Comment;
import com.sharding.datademo.remote.hystrix.CommentRemoteHystrix;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;

/**
 * @description: 远程调用comment
 * @author: HyJan
 * @create: 2020-09-28 17:12
 **/
@FeignClient(name = "sharding-jdbc-demo",path = "/comment",fallback = CommentRemoteHystrix.class)
public interface CommentRemote {

    /**
     * 批量插入
     * @param comments
     * @return
     */
    @PostMapping(value = "/insert/batch",consumes = MediaType.APPLICATION_JSON_UTF8_VALUE)
    String insertCommentBatch(@RequestBody List<Comment> comments);

    /**
     * 单条插入
     * @param comment
     * @return
     */
    @PostMapping(value = "/insert",consumes = MediaType.APPLICATION_JSON_UTF8_VALUE)
    String insert(@RequestBody Comment comment);

    @PostMapping(value = "/select",consumes = MediaType.APPLICATION_JSON_UTF8_VALUE)
     Boolean isExist(@RequestBody Integer id);
}
