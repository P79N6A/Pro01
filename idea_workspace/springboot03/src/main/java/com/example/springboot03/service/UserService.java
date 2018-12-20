package com.example.springboot03.service;

import com.example.springboot03.dto.User;
import com.github.pagehelper.PageInfo;

import java.util.List;

/**
 * @ ClassName UserService
 * @ Description TODO
 * @ Author hzd
 * @ Date 2018/12/9 16:24
 * @ Version 1.0
 */
public interface UserService {
    int insertOne(User user);
    List<User> selectTest();
    PageInfo<User> pageTest(int pageNum, int pageSize);
    List<User> myPageTest(int pageNum, int pageSize);
}
