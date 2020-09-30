package com.sharding.datademo.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.sharding.datademo.domain.Online;
import com.sharding.datademo.mapper.OnlineMapper;
import com.sharding.datademo.service.OnlineService;
import org.springframework.stereotype.Service;
@Service
public class OnlineServiceImpl extends ServiceImpl<OnlineMapper, Online> implements OnlineService{

}
