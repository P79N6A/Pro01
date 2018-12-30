package com.example.springboot03.service.Impl;

import com.example.springboot03.dto.Item;
import com.example.springboot03.mapper.ItemMapper;
import com.example.springboot03.service.ItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * @ ClassName ItemServiceImpl
 * @ Description TODO
 * @ Author hzd
 * @ Date 2018/12/9 17:06
 * @ Version 1.0
 */
@Service
public class ItemServiceImpl implements ItemService {
    @Autowired
    private ItemMapper itemMapper;

    @Override
    public int daleteTest(Item Item) {
        return itemMapper.delete(Item);
    }

    public int insert(Item pojo){
        return itemMapper.insert(pojo);
    }

    public int insertList(List< Item> pojos){
        return itemMapper.insertList(pojos);
    }

    public List<Item> select(Item pojo){
        return itemMapper.select(pojo);
    }

    public int update(Item pojo){
        return itemMapper.update(pojo);
    }

    @Override
    public  List<Item> myPageTest(int pageNum, int pageSize){
        return itemMapper.myPageTest(pageNum,pageSize);
    }
}
