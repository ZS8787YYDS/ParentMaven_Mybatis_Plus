package com.zisheng.service.impl;

import com.zisheng.Pojo.User;
import com.zisheng.Mapper.UserMapper;
import com.zisheng.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 用户表 服务实现类
 * </p>
 *
 * @author zisheng8787
 * @since 2023-08-26
 */
@Service
public class UserServiceImpl implements IUserService {
    @Autowired
    private UserMapper userMapper;
    @Override
    public User selectById(Integer id) {
//        User user = userMapper.selectById(id);
        User user = userMapper.findById(id);
        return user;

    }
}
