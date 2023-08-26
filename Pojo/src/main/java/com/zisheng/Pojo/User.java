package com.zisheng.Pojo;

import com.baomidou.mybatisplus.annotation.*;
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
    /*设置主键生成策略*/
    /**
     * NONE: 无自动生成策略，即需要自己输入
     * Auto：使用数据库ID自动生成策略控制ID生成
     * Input：需要自己进行输入
     * ASSIGN_ID：利用雪花算法生成id，是一个64位的字符串，要采用Long类型进行存储
     * ASSIGN_UUID: 由UUID生成算法作为id的生成策略
     */
//    @TableId(type = IdType.ASSIGN_ID)
    private Long id;
    private String name;
    /**user_table
     * 通过TableField注解的value属性可以设置实体类的属性对应表中的哪个字段
     * 通过select属性可以设置当前这个属性是否参与查询，true表示参与，false表示不参与
     * 通过exist属性可以设置当前这个属性在数据库表当中是否存在，false表示不存在，true表示存在
     */
    @TableField(value = "gender",select = false) // 指定当前属性对应于数据库表中gender这一字段，并且这个属性不参与查询操作
    private Byte gender;
    private Short age;
    @TableField(exist = false) // 将exist设置为false，表示这个属性在数据库表中是不存在的
    private Integer score;
//    // 添加逻辑删除属性,通过@TableLogic注解设置删除状态以及未删除状态下默认值.
    //   也可以在配置文件中进行配置
//    @TableLogic(value = "0",delval = "1")
    private Byte deleteState;
    @Version // 表示该属性为乐观锁，一般情况下命名为version
    private Long version;
}
