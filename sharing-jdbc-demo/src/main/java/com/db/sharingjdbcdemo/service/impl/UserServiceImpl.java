package com.db.sharingjdbcdemo.service.impl;

import org.springframework.stereotype.Service;
import javax.annotation.Resource;
import java.util.List;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.db.sharingjdbcdemo.domain.User;
import com.db.sharingjdbcdemo.mapper.UserMapper;
import com.db.sharingjdbcdemo.service.UserService;
@Service
public class UserServiceImpl extends ServiceImpl<UserMapper, User> implements UserService{

}
