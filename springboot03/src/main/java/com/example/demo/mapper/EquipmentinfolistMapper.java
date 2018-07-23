package com.example.demo.mapper;

import com.example.demo.model.Equipmentinfolist;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/*
 created by zhoujun on 2018/6/19
 */
public interface EquipmentinfolistMapper {
    int deleteByPrimaryKey(Long id);

    int insert(Equipmentinfolist record);

    int insertSelective(Equipmentinfolist record);

    Equipmentinfolist selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(Equipmentinfolist record);

    int updateByPrimaryKey(Equipmentinfolist record);

    List<Equipmentinfolist> selectByequipmentid(Long equipmentid);

    /**@author 黄泽东
     * @Date 2018/6/20
     * @return
     */
    List<Equipmentinfolist> sellectAll(@Param("equid") Long equipmentid);
    List<Equipmentinfolist> selectByKeyWord(@Param("keyword") String keyword, @Param("equid") Long equipmentid);

    List<Equipmentinfolist>getList();


    int getCount();

}