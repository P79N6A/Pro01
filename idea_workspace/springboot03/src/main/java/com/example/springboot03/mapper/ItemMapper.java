package com.example.springboot03.mapper;

import com.example.springboot03.dto.Item;
import com.example.springboot03.dto.User;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;
import tk.mybatis.mapper.common.BaseMapper;

import java.util.List;

@Mapper     //声明是一个Mapper,与springbootApplication中的@MapperScan二选一写上即可
@Repository
public interface ItemMapper extends BaseMapper<Item> {
    int insert(@Param("pojo") Item pojo);

    int insertList(@Param("pojos") List< Item> pojo);

    List<Item> select(@Param("pojo") Item pojo);

    int update(@Param("pojo") Item pojo);

    List<Item> myPageTest(@Param("pageNum") Integer pageNum, @Param("pageSize") Integer pageSize);
    Integer selectAllNumber();
}
