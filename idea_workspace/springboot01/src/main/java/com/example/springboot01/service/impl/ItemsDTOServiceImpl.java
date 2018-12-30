package com.example.springboot01.service.impl;

import com.example.springboot01.dto.ItemsDTO;
import com.example.springboot01.mapper.ItemsDTOMapper;
import com.example.springboot01.service.ItemsDTOService;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Component
public class ItemsDTOServiceImpl implements ItemsDTOService {

    @Resource
    private ItemsDTOMapper itemsDTOMapper;

    @Override
    public int daleteTest(ItemsDTO itemsDTO) {
        return itemsDTOMapper.delete(itemsDTO);
    }

    public int insert(ItemsDTO pojo){
        return itemsDTOMapper.insert(pojo);
    }

    public int insertList(List< ItemsDTO> pojos){
        return itemsDTOMapper.insertList(pojos);
    }

    public List<ItemsDTO> select(ItemsDTO pojo){
        return itemsDTOMapper.select(pojo);
    }

    public int update(ItemsDTO pojo){
        return itemsDTOMapper.update(pojo);
    }

}
