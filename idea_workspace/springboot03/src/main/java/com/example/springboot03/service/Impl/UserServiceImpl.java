package com.example.springboot03.service.Impl;

import com.example.springboot03.dto.User;
import com.example.springboot03.mapper.UserMapper;
import com.example.springboot03.service.UserService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * @ ClassName UserServiceImpl
 * @ Description TODO
 * @ Author hzd
 * @ Date 2018/12/9 16:25
 * @ Version 1.0
 */
@Service
public class UserServiceImpl implements UserService {
    @Override
    public int insertOne(User user) {
        return 0;
    }

    @Override
    public List<User> selectTest() {
        return null;
    }

@Autowired
UserMapper userMapper;
//    @Resource
//    UserMapper userMapper;
//    @Override
//    public int insertOne( User user) {
//        return userMapper.insert(user);
//    }
//
//    @Override
//    public List<User> selectTest() {
//        return userMapper.selectAll();
//    }
//
    @Override
    public PageInfo<User> pageTest(int pageNum, int pageSize) {
        PageHelper.startPage(pageNum,pageSize);
        List<User> list=userMapper.selectTestAll();
        return  new PageInfo<>(list);
    }
    @Override
    public  List<User> myPageTest(int pageNum, int pageSize){
        return userMapper.myPageTest(pageNum,pageSize);
    }
}
