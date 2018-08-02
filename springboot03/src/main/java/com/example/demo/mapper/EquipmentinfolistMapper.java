package com.example.demo.mapper;

import com.example.demo.model.Equipmentinfolist;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface EquipmentinfolistMapper {
    int deleteByPrimaryKey(Long id);

    int insert(Equipmentinfolist record);

    int insertSelective(Equipmentinfolist record);

    Equipmentinfolist selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(Equipmentinfolist record);

    int updateByPrimaryKey(Equipmentinfolist record);

    List<Equipmentinfolist> selectByequipmentid(Long equipmentid);


    /**
     * By HuangZeDong
     * @param keyword keyword
     * @param equipmentid equipmentid
     * @return List<Equipmentinfolist>
     */

    List<Equipmentinfolist> selectByKeyWord(@Param("keyword") String keyword,@Param("equid") Long equipmentid);

    /**
     *  By HuangZeDong
     * @return int
     */
    int getCount();

    /**
     *  By HuangZeDong
     * @return List<Equipmentinfolist>
     */
    List<Equipmentinfolist> selectByEcharts();
}