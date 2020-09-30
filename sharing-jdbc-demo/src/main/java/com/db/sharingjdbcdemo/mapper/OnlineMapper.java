package com.db.sharingjdbcdemo.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.db.sharingjdbcdemo.domain.Online;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface OnlineMapper extends BaseMapper<Online> {
}