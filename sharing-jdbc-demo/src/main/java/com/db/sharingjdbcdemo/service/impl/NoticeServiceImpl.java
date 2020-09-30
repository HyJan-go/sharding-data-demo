package com.db.sharingjdbcdemo.service.impl;

import org.springframework.stereotype.Service;
import javax.annotation.Resource;
import java.util.List;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.db.sharingjdbcdemo.domain.Notice;
import com.db.sharingjdbcdemo.mapper.NoticeMapper;
import com.db.sharingjdbcdemo.service.NoticeService;
@Service
public class NoticeServiceImpl extends ServiceImpl<NoticeMapper, Notice> implements NoticeService{

}
