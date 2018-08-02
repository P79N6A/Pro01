package com.example.demo.service;

import com.example.demo.model.Equipmentinfolist;
import com.github.pagehelper.PageInfo;


import java.util.List;

public interface equipment_managerList_service {

    /**
     * 通过设备id查找设备信息
     * @return 设备信息以List<Equipmentinfolist>
     */
    List<Equipmentinfolist> selectByequipmentid(Long equipmentId);

    /**
     * 后端分页查询
     * @param current current
     * @param pageSize pageSize
     * @param keyword keyword
     * @param equipmentid equipmentid
     * @return Equipmentinfolist
     */
    PageInfo<Equipmentinfolist> selectByKeyWord(int current, int pageSize, String keyword, Long equipmentid);

    /**
     * 其实Echarts不用分页，这里偷懒就按照分页写，只是sql不一样
     * @param current current
     * @param pageSize pageSize
     * @return Equipmentinfolist
     */
    PageInfo<Equipmentinfolist> selectByEcharts(int current, int pageSize);

}
