package com.zisheng.Mapper;

import com.zisheng.Pojo.User;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface TestMapper {
//    @Select("select * from user_table where id = #{id}")
     User searchById(Integer id);
}
