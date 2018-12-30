package com.example.springboot01.service.impl;

import com.example.springboot01.dto.UserDTO;
import com.example.springboot01.mapper.UserDTOMapper;
import com.example.springboot01.service.UserDTOService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import java.util.List;

/**
 * @ ClassName UserDTOServiceImpl
 * @ Description TODO
 * @ Author hzd
 * @ Date 2018/12/7 16:56
 * @ Version 1.0
 */
@Component
public class UserDTOServiceImpl implements UserDTOService {
    @Resource
    UserDTOMapper userDTOMapper;
    @Override
    public int insertOne( UserDTO userDTO) {
        return userDTOMapper.insert(userDTO);
    }

    @Override
    public List<UserDTO> selectTest() {
        return userDTOMapper.selectAll();
    }

    @Override
    public PageInfo<UserDTO> pageTest(int pageNum,int pageSize) {
        PageHelper.startPage(pageNum,pageSize);
        List<UserDTO> list=userDTOMapper.selectTestAll();
        return  new PageInfo<>(list);
    }

}
