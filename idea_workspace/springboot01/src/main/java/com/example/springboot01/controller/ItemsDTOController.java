package com.example.springboot01.controller;

import javax.annotation.Resource;
import javax.validation.Valid;
import java.util.List;
import com.example.springboot01.dto.ItemsDTO;
import com.example.springboot01.dto.UserDTO;
import com.example.springboot01.mapper.ItemsDTOMapper;
import com.example.springboot01.service.ItemsDTOService;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/ItemsDTOController")
public class ItemsDTOController {
    @Resource
    private ItemsDTOService itemsDTOService;
    @Resource
    private ItemsDTOMapper itemsDTOMapper;
/*
 * @Author hzd
 * @Description 自动生成mapper 测试
 * @Date  2018/12/8 0:38
 * @Param 
 * @return 
 */
//    @PostMapping("/singleBaseInsert")
//    public int singleBaseInsert(@RequestBody @Valid ItemsDTO itemsDTO){
//        return itemsDTOMapper.insert(itemsDTO);
//    }
//    @GetMapping("/singleBaseDelete")
//    public int singleBaseDelete(Integer id){
//        return itemsDTOMapper.deleteByPrimaryKey(id);
//    }
//    @PostMapping("/singleBaseUpdate")
//    public int singleBaseUpdate(@RequestBody @Valid ItemsDTO itemsDTO){
//        return itemsDTOMapper.updateByPrimaryKey(itemsDTO);
//    }
//    @GetMapping("/singleBaseSelect")
//    public ItemsDTO singleBaseSelect(Integer id){
//        return itemsDTOMapper.selectByPrimaryKey(id);
//    }
//    @GetMapping("/singleBaseSelectAll")
//    public List<ItemsDTO> singleBaseSelectAll(){
//        return itemsDTOMapper.selectAll();
//    }
//



//
//    @RequestMapping("/test")
//    public int test(ItemsDTO pojo){
//        return itemsDTOService.daleteTest(pojo);
//    }
//    @RequestMapping("/selectAllTest")
//    public List<ItemsDTO> selectAllTest(ItemsDTO pojo){
//        return itemsDTOMapper.selectAll();
//    }
//
//
//    @PostMapping("/insert")
//    public int insert(@RequestBody ItemsDTO pojo){
//        return itemsDTOService.insert(pojo);
//    }
//    @PostMapping("/insertList")
//    public int insertList(List< ItemsDTO> pojos){
//        return itemsDTOService.insertList(pojos);
//    }
//    @RequestMapping("/select")
//    public List<ItemsDTO> select(ItemsDTO pojo){
//        return itemsDTOService.select(pojo);
//    }
//    @PostMapping("/update")
//    public int update(ItemsDTO pojo){
//        return itemsDTOService.update(pojo);
//    }

}
