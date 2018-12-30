package com.example.springboot01.service;

import com.example.springboot01.dto.UserDTO;
import com.github.pagehelper.PageInfo;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @ ClassName service
 * @ Description TODO
 * @ Author hzd
 * @ Date 2018/12/7 16:55
 * @ Version 1.0
 */

public interface UserDTOService {
    int insertOne(UserDTO userDTO);
    List<UserDTO> selectTest();
    PageInfo<UserDTO> pageTest(int pageNum,int pageSize);
}
