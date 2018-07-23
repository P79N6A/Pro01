package com.example.demo.service.impl;

import com.example.demo.mapper.EquipmentinfolistMapper;
import com.example.demo.model.Equipmentinfolist;
import com.example.demo.service.equipment_managerList_service;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;




/*
 created by zhoujun on 2018/6/19
 */
@Service
@Transactional(rollbackFor = { RuntimeException.class, Exception.class })
public class EquipmentmanagerListServiceImp implements equipment_managerList_service {
    @Autowired
    private  EquipmentinfolistMapper mapper;

    /**
     * 通过equipmentid(设备编号)查询
     * @param equipmentid 设备编号
     * @return List<Equipmentinfolist>
     */
    @Override
    public List<Equipmentinfolist> selectByequipmentid(Long equipmentid) {
        return mapper.selectByequipmentid(equipmentid);
    }

    /**
     * 黄泽东
     * @param keyword
     * @return
     */
    @Override
    public PageInfo<Equipmentinfolist> selectByKeyWord(int pageNum, int pageSize,String keyword,Long equipmentid) {
        //若是为空则查询所有的数据
        int pageCount;//总页数
        int totalCounts2=mapper.getCount();//总条数
        if(totalCounts2/pageSize==0){
            pageCount=totalCounts2/pageSize;
        }else {
            pageCount=totalCounts2/pageSize+1;
        }
        System.out.println("一共有条数"+totalCounts2+"/n"+"一共页数:"+pageCount);

        PageHelper.startPage(pageNum, pageSize);


        if(keyword.equals("")){

            List<Equipmentinfolist> lists=mapper.sellectAll(equipmentid);
            PageInfo<Equipmentinfolist> pageInfo = new PageInfo<>(lists);
            return pageInfo;
        }else{
            List<Equipmentinfolist> lists=mapper.selectByKeyWord(keyword,equipmentid);
            PageInfo<Equipmentinfolist> pageInfo = new PageInfo<>(lists);
            return pageInfo;
        }
        //不为空则对传入的参数进行模糊查询的处理
        //keyword="%"+keyword+"%";
    }



        /**
         *
         * @Title: getList
         * @Description: 从数据库中获取所有商品类型列表
         * @param current 当前页
         * @param pageSize 当前页面展示数目
         * @return
         * @throws Exception
         */
        @Override
        public List<Equipmentinfolist> getList(int current, int pageSize) throws Exception {
            //使用分页插件,核心代码就这一行
            int total=mapper.getCount();
            System.out.println("一共有条数"+total);
            PageHelper.startPage(current, pageSize);
            // 获取
            List<Equipmentinfolist> typeList = mapper.getList();
            return typeList;
        }

}
