package com.example.springboot03.service;

import com.example.springboot03.dto.Item;
import com.example.springboot03.dto.User;

import java.util.List;

public interface ItemService {
    int daleteTest(Item item);
    public int insert(Item pojo);


    public int insertList(List<Item> pojos);


    public List<Item> select(Item pojo);

    public int update(Item pojo);

    List<Item> myPageTest(int pageNum, int pageSize);
}
