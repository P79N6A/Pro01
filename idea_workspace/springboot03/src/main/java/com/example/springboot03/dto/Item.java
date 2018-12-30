package com.example.springboot03.dto;

/**
 * @ ClassName Item
 * @ Description TODO
 * @ Author hzd
 * @ Date 2018/12/9 17:05
 * @ Version 1.0
 */
import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Id;
import javax.persistence.Table;
import java.util.Date;

/**
 * @ ClassName ItemsDTO
 * @ Description TODO
 * @ Author hzd
 * @ Date 2018/12/8 0:10
 * @ Version 1.0
 */

@Data
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "cux_todo_items")
public class Item {
    @Id
    private  Integer todoItemId;
    private   Integer userId;
    private    String todoItemTitle;
    private   String todoItemContent;
    private    String priority;
    @JsonFormat(pattern = "yyyy-MM-dd hh:mm:ss",locale = "zh",timezone = "GMT+8")
    private   Date creationDate;
    @JsonFormat(pattern = "yyyy-MM-dd hh:mm:ss",locale = "zh",timezone = "GMT+8")
    private   Date lastUpdateDate;
    private   String comments;
}
