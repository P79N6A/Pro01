package com.example.springboot03.controller;

import com.example.springboot03.config.encryptionAlgorithm.symmetricEncryption.EncrypDES;
import com.example.springboot03.dto.IMoocJSONResult;
import com.example.springboot03.dto.User;
import com.example.springboot03.exception.ResultFactory;
import com.example.springboot03.mapper.UserMapper;
import com.example.springboot03.service.UserService;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.crypto.BadPaddingException;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.NoSuchPaddingException;
import javax.validation.Valid;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.util.*;

/**
 * @ ClassName UserController
 * @ Description USER CURD
 * 对象转换为json对象传送给前端
 * 热部署之一：devtools
 * 热部署之二：要手动关闭端口就不讲
 * @ Author hzd
 * @ Date 2018/12/9 14:41
 * @ Version 1.0
 */
@RestController
@RequestMapping("/UserController")
public class UserController {
    Integer isUserFlag=0;
    //依赖注入
    @Autowired
    UserMapper userMapper;
    @Autowired
    UserService userService;

    @RequestMapping(value = "cs")
    public User cs() {
        //调用dao层
        User user = userMapper.selectUserByName("hzd7");
        return user;
    }
    @RequestMapping(value = "cs2")
    public List<User> cs2() {
        User user = new User();
        user.setUserId(2);
        //调用dao层
        List<User> user2 = userMapper.selectAll();
        return user2;
    }

    @GetMapping("/singleBaseDelete")
    public int singleBaseDelete(Integer id) {
        return userMapper.deleteByPrimaryKey(id);
    }
    @PostMapping("/singleBaseUpdate")
    public int singleBaseUpdate(@RequestBody @Valid User user) {
        return userMapper.updateByPrimaryKey(user);
    }


    @GetMapping("/singleBaseSelect")
    public User singleBaseSelect(Integer id) {
        return userMapper.selectByPrimaryKey(id);
    }
    @GetMapping("/singleBaseSelectAll")
    public List<User> singleBaseSelectAll() {
        return userMapper.selectAll();
    }
    @GetMapping("/singleBaseSelectAll2")
    public List<User> singleBaseSelectAll2(Map map) {
        map.put("result", userMapper.selectAll());
        return userMapper.selectAll();
    }
    @GetMapping("/singleBaseSelectAll3")
    public Map<String,Object> singleBaseSelectAll3() {
        Map<String, Object> map = new HashMap<String, Object>();
        try {
            List<User> listAll=userMapper.selectAll();
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
            List<User> list= (List<User>) singleBaseSelectAll3().get("data");
            //list.forEach(item->System.out.println(item));//Lambda 遍历list
            list.forEach(item->{
                if(userName.equals(item.getUserName())&&password.equals(item.getPassword())){
                    UserController.this.isUserFlag=1;
                }
            });
            map = ResultFactory.makeOkResult(UserController.this.isUserFlag);
        } catch (Exception e) {
            e.printStackTrace();
            map = ResultFactory.makeErrorResult();
        }
        return map;
    }
        @GetMapping("/testaaa")
    public List<User> pageTest2(){
        List<User> list=userMapper.queryByList();
        return  list;
    }
        @PostMapping("/singleBaseInsert")
    public ResponseEntity<Integer> singleBaseInsert(@RequestBody @Valid User user) throws NoSuchPaddingException, NoSuchAlgorithmException, BadPaddingException, InvalidKeyException, IllegalBlockSizeException {
            EncrypDES de1 = new EncrypDES();
            String msg =user.getPassword();
            byte[] encontent = de1.Encrytor(msg);
            byte[] decontent = de1.Decryptor(encontent);
            System.out.println("明文是:" + msg);
            System.out.println("加密后:" + new String(encontent));
            System.out.println("解密后:" + new String(decontent));
            user.setPassword(new String(encontent));
//            user.setLastUpdateDate(new Date());
        return Optional.of(userMapper.insert(user)).map(result -> new ResponseEntity(result, HttpStatus.OK))
                .orElseThrow(() -> new RuntimeException("运行出错"));
    }
    @GetMapping("/page")
    @ResponseBody
    public PageInfo<User> pageTest(int pageNum, int pageSize){
        PageInfo<User> list=userService.pageTest(pageNum,pageSize);
        return  list;
    }

    @GetMapping("/myPageTest")
    @ResponseBody
    public Map<String,User> myPageTest(int pageNum,int pageSize){
        System.out.println("当前页："+pageNum+"页数"+pageSize);

        List<User> list=userService.myPageTest(pageNum*pageSize,pageSize);
        for (User user:list) { System.out.println(user); }
        int total=userMapper.selectAllNumber();
        Map map=new HashMap();
        map.put("list",list);
        map.put("total",total);
        System.out.println(map.get(list));
        return  map;
    }
    @PostMapping("/myUpdate")
    public int myUpdate(@RequestBody @Valid User user) {
        return userMapper.updateByPrimaryKey(user);
    }

    /*
     * @Author hzd
     * @Description 使用ObjectMapper把对象转换为json对象
     * @Date  2018/12/16 0:29
     * @Param 
     * @return 
     */
    @GetMapping("/getUserJson2")
    public IMoocJSONResult getUserJson1() {
        User user=new User();
        user.setUserName("awdad");
        user.setAge(222);
        System.out.println("黄泽东3333");
        return IMoocJSONResult.ok(user);
    }
    @GetMapping("/getUserJson4")
    public IMoocJSONResult getUserJson3() {
        User user=new User();
        user.setUserName("xzcvb");
        user.setAge(222);
        System.out.println("黄泽东3333");
        return IMoocJSONResult.ok(user);
    }
}
//}


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