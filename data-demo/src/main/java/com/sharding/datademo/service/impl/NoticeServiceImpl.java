package com.sharding.datademo.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.sharding.datademo.domain.Notice;
import com.sharding.datademo.mapper.NoticeMapper;
import com.sharding.datademo.service.NoticeService;
import org.springframework.stereotype.Service;
@Service
public class NoticeServiceImpl extends ServiceImpl<NoticeMapper, Notice> implements NoticeService{

}
