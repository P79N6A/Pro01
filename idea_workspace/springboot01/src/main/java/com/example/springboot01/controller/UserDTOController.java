package com.example.springboot01.controller;

import com.example.springboot01.dto.UserDTO;
import com.example.springboot01.exception.ResultFactory;
import com.example.springboot01.mapper.UserDTOMapper;
import com.example.springboot01.service.UserDTOService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import javax.validation.Valid;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

@RestController
@RequestMapping("/UserController")
public class UserDTOController {
    Integer isUserFlag=0;
    @Resource
    UserDTOService userDTOService;
    @Resource
    UserDTOMapper userDTOMapper;

    @PostMapping("/singleBaseInsert")
    public ResponseEntity<Integer> singleBaseInsert(@RequestBody @Valid UserDTO userDTO) {
        return Optional.of(userDTOMapper.insert(userDTO)).map(result -> new ResponseEntity(result, HttpStatus.OK))
                .orElseThrow(() -> new RuntimeException("运行出错"));
    }

    @GetMapping("/singleBaseDelete")
    public int singleBaseDelete(Integer id) {
        return userDTOMapper.deleteByPrimaryKey(id);
    }

    @PostMapping("/singleBaseUpdate")
    public int singleBaseUpdate(@RequestBody @Valid UserDTO userDTO) {
        return userDTOMapper.updateByPrimaryKey(userDTO);
    }

    @GetMapping("/singleBaseSelect")
    public UserDTO singleBaseSelect(Integer id) {
        return userDTOMapper.selectByPrimaryKey(id);
    }

    @GetMapping("/singleBaseSelectAll")
    public List<UserDTO> singleBaseSelectAll() {
        return userDTOMapper.selectAll();
    }

    @GetMapping("/singleBaseSelectAll2")
    public List<UserDTO> singleBaseSelectAll2(Map map) {
        map.put("result", userDTOMapper.selectAll());
        return userDTOMapper.selectAll();
    }

    @GetMapping("/singleBaseSelectAll3")
    public Map<String,Object> singleBaseSelectAll3() {
        Map<String, Object> map = new HashMap<String, Object>();
        try {
            List<UserDTO> listAll=userDTOMapper.selectAll();
            map = ResultFactory.makeOkResult(listAll);
        } catch (Exception e) {
            e.printStackTrace();
            map = ResultFactory.makeErrorResult();
        }
        return map;
    }
    /*
     * @Author hzd
     * @Description 判断用户是否存在 查询全部结果集 lambda遍历判断
     * @Date  2018/12/8 21:54
     * @Param userName password
     * @return
     */

    @GetMapping("/checkUser")
    public Map<String,Object> checkUser(String userName,String password) {
        Map<String, Object> map = new HashMap<String, Object>();
        try {
            List<UserDTO> list= (List<UserDTO>) singleBaseSelectAll3().get("data");
            //list.forEach(item->System.out.println(item));//Lambda 遍历list
            list.forEach(item->{
                if(userName.equals(item.getUserName())&&password.equals(item.getPassword())){
                    UserDTOController.this.isUserFlag=1;
                }
            });
            map = ResultFactory.makeOkResult(UserDTOController.this.isUserFlag);
        } catch (Exception e) {
            e.printStackTrace();
            map = ResultFactory.makeErrorResult();
        }
        return map;
    }

    @GetMapping("/page")
    @ResponseBody
    public PageInfo<UserDTO> pageTest(int pageNum,int pageSize){
        PageInfo<UserDTO> list=userDTOService.pageTest(pageNum,pageSize);
        return  list;
    }

    @GetMapping("/testaaa")
    public List<UserDTO> pageTest2(){
        List<UserDTO> list=userDTOMapper.queryByList();
        return  list;
    }
}


//============Java8之前的方式==========
//        Map<String, Integer> items = new HashMap<>();
//        items.put("A", 10);
//        items.put("B", 20);
//        items.put("C", 30);
//        items.put("D", 40);
//        items.put("E", 50);
//        items.put("F", 60);
//        for (Map.Entry<String, Integer> entry : items.entrySet()) {
//        System.out.println("Item : " + entry.getKey() + " Count : " + entry.getValue());
//        }
//        ============forEach + Lambda表达式==========
//        Map<String, Integer> items = new HashMap<>();
//        items.put("A", 10);
//        items.put("B", 20);
//        items.put("C", 30);
//        items.put("D", 40);
//        items.put("E", 50);
//        items.put("F", 60);
//        items.forEach((k,v)->System.out.println("Item : " + k + " Count : " + v));
//        items.forEach((k,v)->{
//        System.out.println("Item : " + k + " Count : " + v);
//        if("E".equals(k)){
//        System.out.println("Hello E");
//        }
//        });
//
//        二遍历List:
//        ============Java8之前的方式==========
//
//        List<String> items = new ArrayList<>();
//        items.add("A");
//        items.add("B");
//        items.add("C");
//        items.add("D");
//        items.add("E");
//
//        for(String item : items){
//        System.out.println(item);
//        }
//        ============forEach + Lambda表达式==========
//        List<String> items = new ArrayList<>();
//        items.add("A");
//        items.add("B");
//        items.add("C");
//        items.add("D");
//        items.add("E");
////输出：A,B,C,D,E
//        items.forEach(item->System.out.println(item));
////输出 : C
//        items.forEach(item->{
//        if("C".equals(item)){
//        System.out.println(item);
//        }
//        });