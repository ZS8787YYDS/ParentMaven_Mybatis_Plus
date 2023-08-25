package com.zisheng.Configuration;

import com.baomidou.mybatisplus.extension.plugins.MybatisPlusInterceptor;
import com.baomidou.mybatisplus.extension.plugins.inner.PaginationInnerInterceptor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;


@Configuration // 加上configuration注解，表明该类为配置类，在里面可以声明多个第三方bean对象
public class MPConfiguration {
    @Bean
    public MybatisPlusInterceptor mybatisInterceptor()
    {
        // 创建MybatisPlusInterceptor拦截器对象
        MybatisPlusInterceptor mybatisPlusInterceptor = new MybatisPlusInterceptor();
        // 调用addInnerInterceptor方法添加内部拦截器,要想实现分页操作，要添加分页拦截器
        mybatisPlusInterceptor.addInnerInterceptor(new PaginationInnerInterceptor());
        return mybatisPlusInterceptor;
    }
}
