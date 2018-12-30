package com.example.springboot03.dto;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

/**
 * @ ClassName MyResource
 * @ Description TODO
 * @ Author hzd
 * @ Date 2018/12/30 12:39
 * @ Version 1.0
 */
@Configuration   //引用资源文件的配置
@ConfigurationProperties(prefix = "com.example.springboot03") //前缀后面的
@PropertySource(value = "classpath:myResource.properties")  //根路径下的文件
public class MyResource {
    private String name;
    private String password;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
