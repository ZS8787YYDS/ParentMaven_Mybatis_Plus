package com.zisheng.Mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.zisheng.Pojo.User;
import org.apache.ibatis.annotations.Mapper;

/**
 * 定义一个Mapper接口，继承了BaseMapper接口，就会继承BaseMapper接口的全部方法
 */
@Mapper
public interface TestMapper extends BaseMapper<User> {
//    @Select("select * from user_table where id = #{id}")
//     User searchById(Integer id);
}
