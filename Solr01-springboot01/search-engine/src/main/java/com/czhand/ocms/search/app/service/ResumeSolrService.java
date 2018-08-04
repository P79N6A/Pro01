package com.czhand.ocms.search.app.service;


import com.czhand.ocms.search.api.dto.OcmsResumeDTO;
import org.apache.solr.client.solrj.response.UpdateResponse;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;
import java.util.Map;

/*
 * @description:
 * @program: springboottest13
 * @author: syun
 * @create: 2018-07-27 10:42
 */
public interface ResumeSolrService {


    /**
     * 关键字全文搜索,默认一百条
     * @param keyword
     * @return
     */
    public List<OcmsResumeDTO> search(String keyword);

    /**
     * 关键字全文搜索,分页查询
     * @param keyword 关键字
     * @param page 页码
     * @param size 每页记录数
     * @return
     */
    public Map<String, Object> search(String keyword,Integer page,Integer size);


    public Map<String, Object> search(String keyword, Integer page, Integer size, OcmsResumeDTO resumeDTO);


    /**
     * solr resume增量导入
     * @return post信息
     */
    public String deltaImport();

    public UpdateResponse deleteIndex(String condition);

}
