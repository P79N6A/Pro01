package com.example.springboot03.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import javax.persistence.Id;
import javax.persistence.Table;
import java.util.Date;

/**
 * @ ClassName User
 * @ Description TODO
 * @ Author hzd
 * @ Date 2018/12/9 14:39
 * @ Version 1.0
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "cux_users")
public class User {
    @Id
    private Integer userId;
//    @NotNull
//    @Length(max =20, min=6,message = "用户名长度必须再6到20")
    private String    userName;
    @JsonIgnore//让前台不显示这个字段
    private String  password;
    @JsonInclude(JsonInclude.Include.NON_NULL)//有时候用户不想看到为空的字段的值
    private  String  sex;
    private  Integer  age;
    private  String  phoneNumber;
    @JsonFormat(pattern = "yyyy-MM-dd hh:mm:ss",locale = "zh",timezone = "GMT+8")
    private  Date   creationDate;
    @JsonFormat(pattern = "yyyy-MM-dd hh:mm:ss",locale = "zh",timezone = "GMT+8")
    private Date  lastUpdateDate;
    private String  comments;

}