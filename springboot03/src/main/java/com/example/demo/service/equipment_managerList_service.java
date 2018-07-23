package com.example.demo.service;

import com.example.demo.model.Equipmentinfolist;
import com.github.pagehelper.PageInfo;


import java.util.List;

/*
 created by zhoujun on 2018/6/19
 */
public interface equipment_managerList_service {

    /**
     * 通过设备id查找设备信息
     * @return 设备信息以List<Equipmentinfolist>
     */
    List<Equipmentinfolist> selectByequipmentid(Long equipmentId);

    /**
     * 黄泽东
     * @param keyword
     * @return
     */
    public PageInfo<Equipmentinfolist> selectByKeyWord(int current, int pageSize,String keyword, Long equipmentid);


    public List<Equipmentinfolist> getList(int pageNum, int pageSize)throws Exception;

}
