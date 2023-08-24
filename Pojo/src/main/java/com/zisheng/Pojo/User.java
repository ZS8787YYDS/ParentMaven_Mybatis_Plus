package com.zisheng.Pojo;

import com.baomidou.mybatisplus.annotation.TableName;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * Lombok的相关注解，负责简化实体类书写，可以自动提供get set方法 toString方法 hashCode方法 以及
 * 有参 无参构造器
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
/**
 * 指定该实体类所对应数据库中的表,这个实体类会作为泛型的数据类型传递给BaseMapper接口
 * 使得BaseMapper接口中的方法会去操作该实体类所对应的表
 */
@TableName("user_table")
public class User {
    private Integer id;
    private String name;
    private Byte gender;
    private Short age;
}
