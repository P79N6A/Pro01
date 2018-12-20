package com.example.springboot03.exception;

/**
 * @ ClassName ResultFactory
 * @ Description TODO
 * @ Author hzd
 * @ Date 2018/12/8 20:09
 * @ Version 1.0
 */
import org.springframework.http.HttpStatus;

import java.util.HashMap;
import java.util.Map;

public class ResultFactory {

    public static Map<String,Object> makeOkResult(Object data){
        Map<String,Object> res = new HashMap<String,Object>();
        res.put("status", HttpStatus.OK);
        res.put("msg", HttpStatus.values());
        res.put("data", data);
        return res;
    }

    public static Map<String,Object> makeErrorResult(){
        Map<String,Object> res = new HashMap<String,Object>();
        res.put("status", HttpStatus.INTERNAL_SERVER_ERROR);
        res.put("msg", "Error");
        res.put("data", null);
        return res;
    }

}
