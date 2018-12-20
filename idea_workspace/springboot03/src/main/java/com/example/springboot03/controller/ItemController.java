package com.example.springboot03.controller;

import com.example.springboot03.dto.Item;
import com.example.springboot03.dto.User;
import com.example.springboot03.mapper.ItemMapper;
import com.example.springboot03.service.ItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @ ClassName ItemController
 * @ Description
 * @ Author hzd
 * @ Date 2018/12/9 17:05
 * @ Version 1.0
 */

@RestController
@RequestMapping("/ItemController")
public class ItemController {
    @Autowired
    ItemMapper itemMapper;
    @Autowired
    ItemService itemService;

    @PostMapping("/singleBaseInsert")
    public int singleBaseInsert(@RequestBody @Valid Item item){
        return itemMapper.insert(item);
    }
    @GetMapping("/singleBaseDelete")
    public int singleBaseDelete(Integer id){
        return itemMapper.deleteByPrimaryKey(id);
    }
    @PostMapping("/singleBaseUpdate")
    public int singleBaseUpdate(@RequestBody @Valid Item item){
        return itemMapper.updateByPrimaryKey(item);
    }
    @GetMapping("/singleBaseSelect")
    public Item singleBaseSelect(Integer id){
        return itemMapper.selectByPrimaryKey(id);
    }
    @GetMapping("/singleBaseSelectAll")
    public List<Item> singleBaseSelectAll(){
        return itemMapper.selectAll();
    }

    @RequestMapping("/test")
    public int test(Item pojo){
        return itemService.daleteTest(pojo);
    }
    @RequestMapping("/selectAllTest")
    public List<Item> selectAllTest(Item pojo){
        return itemMapper.selectAll();
    }


    @PostMapping("/insert")
    public int insert(@RequestBody Item pojo){
        return itemService.insert(pojo);
    }
    @PostMapping("/insertList")
    public int insertList(List< Item> pojos){
        return itemService.insertList(pojos);
    }
    @RequestMapping("/select")
    public List<Item> select(Item pojo){
        return itemService.select(pojo);
    }
    @PostMapping("/update")
    public int update(Item pojo){
        return itemService.update(pojo);
    }


    /*
     * @Author hzd
     * @Description 自己js分页，用mybatis，limit pageNum,pageSize    pageNum=pageNum*pageSizes  hh
     * @Date  2018/12/10 11:09
     * @Param 
     * @return 
     */
    
    @GetMapping("/myPageTest")
    @ResponseBody
    public Map<String,Item> myPageTest(int pageNum, int pageSize){
        System.out.println("当前页："+pageNum+"页数"+pageSize);

        List<Item> list=itemService.myPageTest(pageNum*pageSize,pageSize);
        for (Item item:list) { System.out.println(item); }
        int total=itemMapper.selectAllNumber();
        Map map=new HashMap();
        map.put("list",list);
        map.put("total",total);
        System.out.println(map.get(list));
        return  map;
    }

    @GetMapping("/singleBaseSelect18")
    public List<Item> singleBaseSelect2(){
        return itemMapper.selectAll();
    }
}
