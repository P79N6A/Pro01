package com.example.springboot01.service;

import com.example.springboot01.dto.ItemsDTO;
import org.springframework.stereotype.Service;

import java.util.List;


public interface ItemsDTOService {

    int daleteTest(ItemsDTO itemsDTO);
    public int insert(ItemsDTO pojo);


    public int insertList(List< ItemsDTO> pojos);


    public List<ItemsDTO> select(ItemsDTO pojo);

    public int update(ItemsDTO pojo);

}
