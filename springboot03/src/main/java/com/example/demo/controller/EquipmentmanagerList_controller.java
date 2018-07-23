package com.example.demo.controller;

import com.example.demo.model.Equipmentinfolist;
import com.example.demo.service.impl.EquipmentmanagerListServiceImp;

import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import java.math.BigDecimal;
import java.util.List;


@RestController
public class EquipmentmanagerList_controller {

    @Autowired
    private EquipmentmanagerListServiceImp service;

    /*
        created by zhoujun on 2018/6/19
     */
    /**
     *
     * 通过设备id(equipmentid)查找数据
     * @param id
     * @return List<Equipmentinfolist>
     */
    @RequestMapping("/findByEquId")
    @ResponseBody
    private List<Equipmentinfolist> selectByEquipmentId(Long id){
        //剔除以被标识为删除的记录
        List<Equipmentinfolist> list= service.selectByequipmentid(id);
        return list;
    }

    /**Tab
     * HuangZeDong
     * @param keyword
     * @return
     */
    @RequestMapping("/equipmentList/queryHuang")
    @ResponseBody
    public PageInfo<Equipmentinfolist> queryHuang(int pageNum, int pageSize,
                                                  @RequestParam(value = "keyword",defaultValue = "" ,required = false)String keyword,
                                                  @RequestParam(value = "equipmentid",defaultValue = "",required =false )Long equipmentid
    ){
/*

        BigDecimal decimal = new BigDecimal("1.12345");
        System.out.println(decimal);
        BigDecimal setScale = decimal.setScale(4,BigDecimal.ROUND_HALF_DOWN);
        System.out.println(setScale);

        BigDecimal setScale1 = decimal.setScale(4,BigDecimal.ROUND_HALF_UP);
        System.out.println(setScale1);
*/

        PageInfo<Equipmentinfolist> list1=service.selectByKeyWord(pageNum,pageSize,keyword,equipmentid);

        BigDecimal decimal=new BigDecimal("1.12345");

        for (int i=0;i<list1.getList().size();i++){
          /*  System.out.println(list1.get(i).getAngleOfInclination() );*/
            decimal=list1.getList().get(i).getAngleOfInclination();
            BigDecimal setScale1 = decimal.setScale(2,BigDecimal.ROUND_HALF_UP);

            list1.getList().get(i).setAngleOfInclination(setScale1);

        }
        return list1;
    }



    /**
     *
     * @Title: getGoodsTypeList
     * @Description: 获取商品类型列表
     * @return
     * @throws Exception
     */
    @RequestMapping(value = "/getGoodsTypeList")
    public List<Equipmentinfolist> getGoodsTypeList(int current, int pageSize) throws Exception {
        // 调用业务逻辑,返回数据
        return service.getList(current,pageSize);
    }


}
