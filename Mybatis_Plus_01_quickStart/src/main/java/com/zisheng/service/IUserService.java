package com.zisheng.service;

import com.zisheng.Pojo.User;
import com.zisheng.Pojo.User;

/**
 * <p>
 * 用户表 服务类
 * </p>
 *
 * @author zisheng8787
 * @since 2023-08-26
 */
public interface IUserService{
    User selectById(Integer id);
}
