package com.zisheng.QueryCondition;

import com.zisheng.Pojo.User;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
// 这个类继承了实体类User，获得了实体类的属性及其相应的实例方法
public class HandleNull extends User {
    // 新增了年龄属性，表示年龄的上限，继承过来的age属性表示年龄的下限
    private Short ageUp;
}
