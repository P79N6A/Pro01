package com.example.demo.controller;

import com.example.demo.model.FceLocalinfo;
import com.example.demo.service.DemoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

/**
 *
 */
@Controller
public class DemoController {


    private final DemoService demoService;

    @Autowired
    public DemoController(DemoService demoService) {
        this.demoService = demoService;
    }

    @RequestMapping("/")
    public String toTest(){
    return "test";
    }
    @RequestMapping("/react01")
    public String toTestReact(){
        return "react01";
    }

    @RequestMapping(value="find")/*,method ={ RequestMethod.POST}*/
    @ResponseBody
    public FceLocalinfo find( FceLocalinfo fi,String aaa){/*由于已经*/
        System.out.println(fi.getLocainfo()+fi.getAddress());
        System.out.println(aaa);

        /*要传入系统识别的id所以要用fi.getId()*/
        return  demoService.find(fi.getId());
    }
    @RequestMapping("find2")
    @ResponseBody
    public List<FceLocalinfo> find2(){
        return  demoService.find2();
    }

    @RequestMapping("delete")
    @ResponseBody
    public int delete(FceLocalinfo fi){

        System.out.println(fi.getLocainfo());

        return  demoService.delete(fi.getId());
    }

    @RequestMapping("update")
    @ResponseBody
    public int update(FceLocalinfo fi){/*在浏览器中输入id=。。就行了*/

        System.out.println(fi.getLocainfo());
        return  demoService.update(fi);
    }


    @RequestMapping("insert")
    @ResponseBody
    public int insert(FceLocalinfo fi){

        System.out.println(fi.getLocainfo());
        return  demoService.insert(fi);
    }


    @RequestMapping("/index")
    public String toIndex(){
        return "index";
    }

    @RequestMapping("/ssmDemo01")
    public String ssmDemo01(){
        return "ssmDemo01/index";
    }
}
