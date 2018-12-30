package com.example.springboot01.mapper;

import com.example.springboot01.dto.UserDTO;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;
import tk.mybatis.mapper.common.BaseMapper;

import java.util.List;

/**
 * @ ClassName UserDTOMapper
 * @ Description TODO
 * @ Author hzd
 * @ Date 2018/12/7 14:54
 * @ Version 1.0
 */
@Mapper
@Repository
public interface UserDTOMapper extends BaseMapper<UserDTO> {
    List<UserDTO> queryByList();
    Integer checkUser(@Param("id")Integer id, @Param("password")String password);

    UserDTO isUser(@Param("userName")String userName);

    List<UserDTO> selectTestAll();
}
