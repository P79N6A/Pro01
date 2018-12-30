package com.example.springboot01.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Id;
import javax.persistence.Table;
import java.util.Date;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "cux_users")
public class UserDTO {
@Id
private Integer userId;
private String    userName;
private String  password;
private  String  sex;
private  Integer  age;
private  String  phoneNumber;
@JsonFormat(pattern = "yyyy-MM-dd hh:mm:ss",locale = "zh",timezone = "GMT+8")
private  Date   creationDate;
@JsonFormat(pattern = "yyyy-MM-dd hh:mm:ss",locale = "zh",timezone = "GMT+8")
private Date  lastUpdateDate;
private String  comments;
}
