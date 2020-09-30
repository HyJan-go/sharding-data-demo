package com.db.sharingjdbcdemo.service.impl;

import org.springframework.stereotype.Service;
import javax.annotation.Resource;
import java.util.List;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.db.sharingjdbcdemo.mapper.OnlineMapper;
import com.db.sharingjdbcdemo.domain.Online;
import com.db.sharingjdbcdemo.service.OnlineService;
@Service
public class OnlineServiceImpl extends ServiceImpl<OnlineMapper, Online> implements OnlineService{

}
