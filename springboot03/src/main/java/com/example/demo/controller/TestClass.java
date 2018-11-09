package com.example.demo.controller;
import net.sf.json.JSONArray;
import java.util.*;
/**
 * @author akoasm hzd
 * @since date: 2018/11/8 time: 17:58
 **/

/**
 * json去重
 */
public class TestClass {
     int HANG=0;
     int LIE=0;
    public static void main(String[] args) {
        test();
    }
    public static void test(){
        TestClass TestClass=new TestClass();
        //初始化显示1行
        TestClass.HANG=1;
        // 一个未转化的字符串
        String str = "[{name:'hzd1'},{name:'hzd2'},{name:'hzd3'},{name:'hzd1'},{name:'hzd2'}]" ;
        // 首先把字符串转成 JSONArray  对象
        JSONArray json = JSONArray.fromObject(str );
        System.out.println("初始化数据:"+json);
        HashSet<Object> testSet1 = new HashSet<Object>(json);
        //初始化列
        TestClass.LIE=testSet1.size();
        System.out.println("去重后数据:"+testSet1);

        Object[][] arr = new Object[TestClass.HANG][TestClass.LIE];
        List list= Arrays.asList(testSet1.toArray());
        int k=0;
        for (int i=0;i<TestClass.HANG;i++){
            for (int j=0;j<TestClass.LIE;j++){
                for (;k<list.size();k++){
                    System.out.println("每次得到："+list.get(k));
                    arr[i][j]=list.get(k);
                    k++;
                    break;
                }
            }
        }
        System.out.println("end:"+JSONArray.fromObject(arr).toString());
    }
}

/*
*
*
*
package com.lk.Utils;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.json.JSONArray;
import org.json.JSONObject;


public class LkCommon
{
    public JSONArray handle(JSONArray jsonArray)
    {

        Set name = new HashSet<String>();
        for (int i = 0; i < jsonArray.length(); i++)
        {
            JSONObject a = jsonArray.getJSONObject(i);
            name.add(a.get("name"));
        }
        List list = new ArrayList(name);

        JSONArray bbb = new JSONArray();

        for (int i = 0; i < list.size(); i++)
        {
            String a = (String) list.get(i);
            JSONArray dd = new JSONArray();
            for (int j = 0; j < jsonArray.length(); j++)
            {
                JSONObject b = jsonArray.getJSONObject(j);
                if (a.equals(b.getString("name")))
                {
                    JSONObject c = new JSONObject();
                    c.put("name", b.get("name"));
                    dd.put(c);
                }
            }
            bbb.put(dd);
        }
        return bbb;
    }



}

* */