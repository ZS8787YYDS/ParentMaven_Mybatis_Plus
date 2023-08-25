package com.zisheng.Pojo;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * Lombok的相关注解，负责简化实体类书写，并且可以自动提供get set方法 toString方法 equals方法 hashCode方法 以及
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
    /**
     * 通过value属性可以设置实体类的属性对应表中的哪个字段
     * 通过select属性可以设置当前这个属性是否参与查询，true表示参与，false表示不参与
     * 通过exist属性可以设置当前这个属性在数据库表当中是否存在，false表示不存在，true表示存在
     */
    @TableField(value = "gender",select = false)
    private Byte gender;
    private Short age;
//    @TableField(exist = false)
//    private Integer score;
}
