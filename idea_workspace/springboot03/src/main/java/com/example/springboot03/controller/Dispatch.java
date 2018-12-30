package com.example.springboot03.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.util.DigestUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * @ ClassName Dispatch
 * @ Description
 * @ Author hzd
 * @ Date 2018/12/8 14:04
 * @ Version 1.0
 */
@Controller
public class Dispatch {
    private final Logger log = LoggerFactory.getLogger(this.getClass());
    /*
     * @Author hzd
     * @Description //无论是@RestController还是@Controller都不影响返回页面
     * @Date  2018/12/8 15:09
     * @Param
     * @return
     */
    @PostMapping(value = "/queryMaterialType")
    public Object test(){
        log.info("--------------->>打印日志");
        return "hellow world";
    }

    @GetMapping(value = "/login")
    public String login(HttpServletRequest request, HttpServletResponse response){
        return "login";
    }
    @GetMapping(value = "/index")
    public ModelAndView test(ModelAndView mv) {
        mv.setViewName("index");//页面
        mv.addObject("title","欢迎使用Thymeleaf!");
        return mv;
    }
//    @GetMapping(value = "/jsp")
//    public String test2() {
////        mv.setViewName("/index2");//页面
////        mv.addObject("title","欢迎使用Thymeleaf!");
//        return "/index";
//    }
@GetMapping(value="/register")
public String index() {
    return "register";
}

    @GetMapping(value="/fyexample2")
    public String index2() {
        return "fyexample2";
    }

    @GetMapping(value="/fy3")
    public String index3() {
        return "fy3";
    }
    @GetMapping(value="/fy4")
    public String index4() {
        return "fy4";
    }
    @GetMapping(value="/fy5")
    public String index5() {
        return "fy5";
    }

    @GetMapping(value="/userManager")
    public String userManager() {
        return "userManager";
    }
    @GetMapping(value="/ItemALlManager")
    public String itemManager() {
        return "ItemALlManager";
    }
    @GetMapping(value="/md5")
    public String md5() {
        String md5Password = DigestUtils.md5DigestAsHex("aaa".getBytes());
        System.out.println("加密后的内容"+md5Password);
        return "login";
    }
    @GetMapping(value="/reactTest01")
    public String reactTest() {
        return "reactTest01";
    }


//    @RestController,返回json数据
//    @Controller，返回login.jsp页面
//    @RequestMapping(value = "/login", method = RequestMethod.GET)
//    public String login(HttpServletRequest request, HttpServletResponse response){
//        return "login";
//    }

    //无论是@RestController还是@Controller都不影响返回页面
//    @RequestMapping(value = "/loginPage", method = RequestMethod.GET)
//    public ModelAndView loginPage(HttpServletRequest request,HttpServletResponse response){
//        ModelAndView mav = new ModelAndView();
//        mav.setViewName("login");
//        return mav;
//    }

}



//资源参考：https://blog.csdn.net/qq_34532187/article/details/82843658
//ModelAndView是Spring MVC里面重要的组成部分。分为两部分Model和View，Model是后端的返回值，View指的视图。先回忆一下当用户向服务器发送请求时，Spring MVC处理请求的过程：
//1. DispatcherServlet捕获前端请求；
//2. DispatcherServlet对请求URL进行解析，得到请求资源标识符（URI）。然后根据该URI，调用HandlerMapping获得该Handler是配置的所有相关的对象（包括Handler对象以及Handler对象对应的拦截器），最后以HandlerExecutionChain对象的形式返回
//3. 由HandleMapping定位到具体的（Handler）controller，controller将处理用户请求。
//4.一旦controller处理完用户请求，则返回ModelAndView对象给DispatcherSevlet前端控制
//4. 根据返回的ModelAndView，选择一个适合的ViewResolver（必须是已经注册到Spring容器中的ViewResolver）返回给DispatcherServlet 。
//5. ViewResolver 结合Model和View，来渲染视图
//6. 将渲染结果返回给客户端。
//    回忆完mvc的过程，应该大致可以明白ModelAndView负责哪一部分了，简单来说就是负责绑定模型数据转发到相应页面
//thymeleaf ：这个东西是完全可以代替JSP的。thymeleaf最大的优势后缀为html,就是只需要浏览器就可以展现页面, 还有就是thymeleaf可以很好的和spring集成。因为Spring boot中配置JSP相当麻烦，并且也没有很好的契合，对于习惯JSP的大佬们来说十分头疼，不过Springboot支持thymeleaf模板引擎，这个习惯了也是相当好用的。
