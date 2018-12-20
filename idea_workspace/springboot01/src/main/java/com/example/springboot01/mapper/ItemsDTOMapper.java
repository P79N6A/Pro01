package com.example.springboot01.mapper;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import java.util.List;
import com.example.springboot01.dto.ItemsDTO;
import org.springframework.stereotype.Repository;
import tk.mybatis.mapper.common.BaseMapper;

@Mapper
@Repository
public interface ItemsDTOMapper extends BaseMapper<ItemsDTO> {

   int insert(@Param("pojo") ItemsDTO pojo);

    int insertList(@Param("pojos") List< ItemsDTO> pojo);

    List<ItemsDTO> select(@Param("pojo") ItemsDTO pojo);

    int update(@Param("pojo") ItemsDTO pojo);

}
