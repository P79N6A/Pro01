package com.czhand.ocms.search.app.service;

import com.czhand.ocms.search.api.dto.OcmsDemandDTO;
import org.apache.solr.client.solrj.response.UpdateResponse;

import java.util.List;
import java.util.Map;

/*
 * @program: search-engine
 * @author: syun
 * @create: 2018-08-01 14:42
 */
public interface DemandSolrService {


    public Map<String, Object> search(String keyword,Integer page,Integer size);

    public Map<String, Object> searchByManage(String keyword, Integer page, Integer size, OcmsDemandDTO demandDTO);

    public Map<String, Object> searchByExamine(String keyword, Integer page, Integer size, OcmsDemandDTO demandDTO);

    public String deltaImport();

    public UpdateResponse deleteIndex(String condition);
}
