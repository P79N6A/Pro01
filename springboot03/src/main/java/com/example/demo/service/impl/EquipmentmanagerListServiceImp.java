package com.example.demo.service.impl;

import com.example.demo.mapper.EquipmentinfolistMapper;
import com.example.demo.model.Equipmentinfolist;
import com.example.demo.service.equipment_managerList_service;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EquipmentmanagerListServiceImp implements equipment_managerList_service {

    private final EquipmentinfolistMapper mapper;

    @Autowired
    public EquipmentmanagerListServiceImp(EquipmentinfolistMapper mapper) {
        this.mapper = mapper;
    }

    /**
     * 通过equipmentid(设备编号)查询
     * @param equipmentid 设备编号
     * @return List<Equipmentinfolist>
     */
    @Override
    public List<Equipmentinfolist> selectByequipmentid(Long equipmentid) {
        return mapper.selectByequipmentid(equipmentid);
    }
    @Override
    public PageInfo<Equipmentinfolist> selectByKeyWord(int pageNum, int pageSize, String keyword, Long equipmentid) {
        /*在PageInfo已经有（总页数，当前页，最后一页等），所以不再放入，所以注释
        int pageCount;//总页数
        //总条数
        int totalCounts2=mapper.getCount();
        if(totalCounts2/pageSize==0){
            pageCount=totalCounts2/pageSize;
        }else {
            pageCount=totalCounts2/pageSize+1;
        }
        System.out.println("一共有条数"+totalCounts2+"/n"+"一共页数:"+pageCount);*/

        PageHelper.startPage(pageNum, pageSize);

        List<Equipmentinfolist> lists=mapper.selectByKeyWord(keyword,equipmentid);

       /* PageInfo<Equipmentinfolist> pageInfo = new PageInfo<>(lists);
        return pageInfo;*/
        return new PageInfo<>(lists);
    }

    /**
     * @author HuangZeDong 功能分页和查Echarts
     * @param pageNum pageNum
     * @param pageSize pageSize
     * @return Equipmentinfolist
     */
    @Override
    public PageInfo<Equipmentinfolist> selectByEcharts(int pageNum, int pageSize) {
        PageHelper.startPage(pageNum, pageSize);

        List<Equipmentinfolist> lists=mapper.selectByEcharts();

        return new PageInfo<>(lists);
    }


}
