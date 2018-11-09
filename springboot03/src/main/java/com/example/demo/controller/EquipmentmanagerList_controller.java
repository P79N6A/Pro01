package com.example.demo.controller;

import com.example.demo.model.Equipmentinfolist;
import com.example.demo.service.impl.EquipmentmanagerListServiceImp;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.math.BigDecimal;
import java.util.List;

/**
 * @author HuangZeDong
 */
@Controller
public class EquipmentmanagerList_controller {

    private final EquipmentmanagerListServiceImp service;

    @Autowired
    public EquipmentmanagerList_controller(EquipmentmanagerListServiceImp service) {
        this.service = service;
    }

    /*
        created by zhoujun on 2018/6/19
     */
    /**
     *
     * 通过设备id(equipmentid)查找数据
     * @param id id
     * @return List<Equipmentinfolist>
     */
    @RequestMapping("/findByEquId")
    @ResponseBody
    private List<Equipmentinfolist> selectByEquipmentId(Long id){
        //剔除以被标识为删除的记录
        return service.selectByequipmentid(id);
    }

    /**Tab
     * HuangZeDong
     * @param keyword keyword
     * @return PageInfo<Equipmentinfolist>
     */
    @GetMapping("/equipmentList/queryHuang")
    @ResponseBody
    public PageInfo<Equipmentinfolist> queryHuang(int pageNum, int pageSize,
                                                  @RequestParam(value = "keyword",defaultValue = "" ,required = false)String keyword,
                                                  @RequestParam(value = "equipmentid",defaultValue = "",required =false )Long equipmentid,
    HttpServletRequest request, HttpServletResponse response){
        String origin = request.getHeader("Origin");
        response.setHeader("Access-Control-Allow-Origin", origin);
        //翻转equal调用""
        /*if (null!=keyword&&!"".equals(keyword)){
            System.out.println("关键字是"+keyword);
        }else{
            System.out.println("---------------------------------关键字为空------"+keyword);
        }
        if(equipmentid!=null){
            System.out.println("设备是："+equipmentid);
        }else{
            System.out.println("********************************设备为空***"+equipmentid);
        }*/
        PageInfo<Equipmentinfolist> list1=service.selectByKeyWord(pageNum,pageSize,keyword,equipmentid);
        BigDecimal decimal;
         /*public PageInfo(List<T> list) {
            this(list, 8);getList因为List
        }*/
        for (int i=0;i<list1.getList().size();i++){
            /*  System.out.println(list1.get(i).getAngleOfInclination() );*/
            decimal=list1.getList().get(i).getAngleOfInclination();
            BigDecimal setScale1 = decimal.setScale(2,BigDecimal.ROUND_HALF_UP);
            list1.getList().get(i).setAngleOfInclination(setScale1);

            if ("0".equals(list1.getList().get(i).getStatus00())){
                list1.getList().get(i).setStatus00("正常");
            }else {
                list1.getList().get(i).setStatus00("不正常");
            }
            if ("0".equals(list1.getList().get(i).getStatus01())){
                list1.getList().get(i).setStatus01("正常");
            }else {
                list1.getList().get(i).setStatus01("不正常");
            }
            if ("0".equals(list1.getList().get(i).getStatus02())){
                list1.getList().get(i).setStatus02("正常");
            }else {
                list1.getList().get(i).setStatus02("不正常");
            }
            if ("0".equals(list1.getList().get(i).getStatus03())){
                list1.getList().get(i).setStatus03("正常");
            }else {
                list1.getList().get(i).setStatus03("不正常");
            }
            if ("0".equals(list1.getList().get(i).getStatus04())){
                list1.getList().get(i).setStatus04("正常");
            }else {
                list1.getList().get(i).setStatus04("低");
            }
            if ("0".equals(list1.getList().get(i).getStatus05())){
                list1.getList().get(i).setStatus05("正常");
            }else {
                list1.getList().get(i).setStatus05("低");
            }
            if ("0".equals(list1.getList().get(i).getStatus06())){
                list1.getList().get(i).setStatus06("正常");
            }else {
                list1.getList().get(i).setStatus06("倾斜");
            }
            if ("0".equals(list1.getList().get(i).getStatus07())){
                list1.getList().get(i).setStatus07("静止");
            }else {
                list1.getList().get(i).setStatus07("震动");
            }
            //规定暂时写死
            list1.getList().get(i).setStatus17("正常");
        }
        return list1;
    }
    /**
     * 由于作者黄泽东Echart没有动态state equipmentid的值，所以暂时只查询
     * @param pageNum pageNum
     * @param pageSize pageSize
     * @param keyword keyword
     * @param equipmentid equipmentid
     * @return PageInfo<Equipmentinfolist>
     */
    @GetMapping("/equipmentList/queryEcharts")
    @ResponseBody
    public PageInfo<Equipmentinfolist> queryEcharts(int pageNum, int pageSize,
                                                    @RequestParam(value = "keyword",defaultValue = "" ,required = false)String keyword,
                                                    @RequestParam(value = "equipmentid",defaultValue = "",required =false )Long equipmentid,
                                                    HttpServletRequest request, HttpServletResponse response){
        String origin = request.getHeader("Origin");
        response.setHeader("Access-Control-Allow-Origin", origin);
        return service.selectByEcharts(pageNum,pageSize);
    }

}
/*      这些信息是保留decimal的小数位数的方法，将来可能会有用，所以保留
        BigDecimal decimal = new BigDecimal("1.12345");
        System.out.println(decimal);
        BigDecimal setScale = decimal.setScale(4,BigDecimal.ROUND_HALF_DOWN);
        System.out.println(setScale);
        BigDecimal setScale1 = decimal.setScale(4,BigDecimal.ROUND_HALF_UP);
        System.out.println(setScale1);
*/