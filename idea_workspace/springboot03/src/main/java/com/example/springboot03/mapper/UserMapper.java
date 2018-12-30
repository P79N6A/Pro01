package com.example.springboot03.mapper;

import com.example.springboot03.dto.User;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;
import tk.mybatis.mapper.common.BaseMapper;

import java.util.List;

/**
 * @ ClassName UserMapper
 * @ Description TODO
 * @ Author hzd
 * @ Date 2018/12/9 14:41
 * @ Version 1.0
 */
@Mapper     //声明是一个Mapper,与springbootApplication中的@MapperScan二选一写上即可
@Repository
public interface UserMapper  extends BaseMapper<User> {
    User selectUserByName(String name);

    List<User> queryByList();
    List<User> selectTestAll();

    List<User> myPageTest(@Param("pageNum") Integer pageNum,@Param("pageSize") Integer pageSize);

    Integer selectAllNumber();

    Integer myUpdate(User user);
}