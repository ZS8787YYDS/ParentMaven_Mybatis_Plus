package com.zisheng.Mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.zisheng.Pojo.User;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

/**
 * Mybatis的使用步骤：
 * 第一步：引入Mybatis-plus-boot-starter的起步依赖
 * 第二步：定义一个Mapper接口，继承BaseMapper接口，指定泛型
 * 第三步：默认是去操作名称为实体类名称小写的表。在泛型对应的实体类中上去添加tableName注解，指定实体类所绑定的表。
 *        则调用mybatisPlus提供的方法就会去操作实体类所对应数据库中的表
 * 定义一个Mapper接口，继承了BaseMapper接口，就会继承BaseMapper接口的全部方法
 * 使用MybatisPlus的之后就不需要自己去写SQL代码及其方法了，会自动生成的。当前也可以继续写代码的，写一个个的接口方法。
 */
@Mapper
public interface TestMapper extends BaseMapper<User> {
    @Select("select * from tb_user")
    List<User> PageSelect();
}
