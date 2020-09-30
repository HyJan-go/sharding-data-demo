package com.sharding.datademo.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

/**
 * @description: 使用组合方式扩展
 * @author: HyJan
 * @create: 2020-09-30 09:32
 **/
@Data
@NoArgsConstructor
@AllArgsConstructor
public class CommentEx {

    private Comment comment;

    private List<Integer> ids;

}
