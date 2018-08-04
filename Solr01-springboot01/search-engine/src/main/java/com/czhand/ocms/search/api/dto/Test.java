package com.czhand.ocms.search.api.dto;

import org.apache.solr.client.solrj.beans.Field;

/**
 * 测试类
 * @author Antemis
 * @date 上午 9:51 2018/7/18/0018
 */
public class Test {

    @Field
    private String id;

    @Field
    private String test;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getTest() {
        return test;
    }

    public void setTest(String test) {
        this.test = test;
    }
}
