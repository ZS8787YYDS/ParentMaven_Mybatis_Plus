package com.zisheng.Mapper;

import com.zisheng.Pojo.User;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;

/**
 * <p>
 * 用户表 Mapper 接口
 * </p>
 *
 * @author zisheng8787
 * @since 2023-08-26
 */
@Mapper
public interface UserMapper extends BaseMapper<User> {
    User findById(Integer id);

}

