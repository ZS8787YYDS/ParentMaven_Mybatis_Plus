package com.zisheng.controller;


import com.zisheng.Pojo.Result;
import com.zisheng.Pojo.User;
import com.zisheng.service.impl.UserServiceImpl;
import org.apache.catalina.realm.UserDatabaseRealm;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * <p>
 * 用户表 前端控制器
 * </p>
 *
 * @author zisheng8787
 * @since 2023-08-26
 */
@RestController
@RequestMapping("/path")
public class UserController {
    @Autowired
    private UserServiceImpl userService;
    private static final Logger log = LoggerFactory.getLogger(UserDatabaseRealm.class);
    @GetMapping("/{id}")
    public Result selectById(@PathVariable Integer id)
    {
        log.info("查询id为{}的信息",id);
        User user = userService.selectById(id);
        return Result.success(user);
    }
}

