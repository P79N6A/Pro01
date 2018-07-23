package com.example.demo.service;

import com.example.demo.mapper.FceLocalinfoMapper;
import com.example.demo.model.FceLocalinfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DemoService {

    @Autowired
    private FceLocalinfoMapper mapper;


    public FceLocalinfo find(Long id){


        return  mapper.selectByPrimaryKey(id);
    }
    public List<FceLocalinfo> find2(){


        return  mapper.selectByPrimaryKey2();
    }

    public int delete(Long id){


        return  mapper.deleteByPrimaryKey(id);
    }

    public int update(FceLocalinfo f1){

        return  mapper.updateByPrimaryKey(f1);
    }
    public int insert(FceLocalinfo f1){

        return  mapper.insert(f1);
    }

}
