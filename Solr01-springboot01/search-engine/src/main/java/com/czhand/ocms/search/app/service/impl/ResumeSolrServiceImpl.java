package com.czhand.ocms.search.app.service.impl;

import com.czhand.ocms.search.api.dto.OcmsResumeDTO;
import com.czhand.ocms.search.app.service.ResumeSolrService;
import com.czhand.ocms.search.infra.common.HttpUtil;
import org.apache.solr.client.solrj.SolrClient;
import org.apache.solr.client.solrj.SolrQuery;
import org.apache.solr.client.solrj.SolrServerException;
import org.apache.solr.client.solrj.response.QueryResponse;
import org.apache.solr.client.solrj.response.UpdateResponse;
import org.apache.solr.common.SolrDocumentList;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/*
 * @description:
 * @program: springboottest13
 * @author: syun
 * @create: 2018-07-27 10:43
 */
@Service
public class ResumeSolrServiceImpl implements ResumeSolrService {

    @Autowired
    private SolrClient client;

    @Value("${spring.data.solr.solr-host}")
    private String solrHost;



    @Override
    public List<OcmsResumeDTO> search(String keyword) {

        Map<String, Object> map = new HashMap<>();
        SolrQuery sq = new SolrQuery();

//        设置查询条件
        StringBuffer queryParams = new StringBuffer();
        queryParams.append("name:").append(keyword).append(" OR ")
                .append("otherRemarks:").append(keyword).append(" OR ")
                .append("university:").append(keyword).append(" OR ")
                .append("skills:").append(keyword).append(" OR ")
                .append("email:").append(keyword).append(" OR ")
                .append("qqNum:").append(keyword).append(" OR ")
                .append("mobile:").append(keyword).append(" OR ")
                .append("loginName:").append(keyword).append(" OR ")
                .append("evaluationLevel:").append(keyword).append(" OR ")
                .append("residence:").append(keyword);
        System.out.println(queryParams.toString());
        sq.set("q", queryParams.toString());

//        设置分页
        sq.setStart(0);
        sq.setRows(100);


        QueryResponse qr = null;
        try {
            qr = client.query("resume", sq);
        } catch (SolrServerException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        List<OcmsResumeDTO> list = qr.getBeans(OcmsResumeDTO.class);
        SolrDocumentList documents = qr.getResults();

//        获取总数
        Long total = documents.getNumFound();
        int index = 0;
        for (OcmsResumeDTO temp : list) {
            temp.setId((Long) documents.get(index).get("resume_id"));
            index++;
        }
        map.put("list", list);
        map.put("total", total);
        return list;

    }

    @Override
    public Map<String, Object> search(String keyword, Integer page, Integer size) {


        Map<String, Object> map = new HashMap<>();
        SolrQuery sq = new SolrQuery();

//        设置查询条件
        StringBuffer queryParams = new StringBuffer();
        queryParams.append("name:").append(keyword).append(" OR ")
                .append("otherRemarks:").append(keyword).append(" OR ")
                .append("university:").append(keyword).append(" OR ")
                .append("skills:").append(keyword).append(" OR ")
                .append("email:").append(keyword).append(" OR ")
                .append("qqNum:").append(keyword).append(" OR ")
                .append("mobile:").append(keyword).append(" OR ")
                .append("loginName:").append(keyword).append(" OR ")
                .append("evaluationLevel:").append(keyword).append(" OR ")
                .append("residence:").append(keyword);
        System.out.println(queryParams.toString());
        sq.set("q", queryParams.toString());

//        设置分页
        sq.setStart(page);
        sq.setRows(size);

        QueryResponse qr = null;
        try {
            qr = client.query("resume", sq);
        } catch (SolrServerException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        List<OcmsResumeDTO> list = qr.getBeans(OcmsResumeDTO.class);
        SolrDocumentList documents = qr.getResults();

//        获取总数
        Long total = documents.getNumFound();
        int index = 0;
        for (OcmsResumeDTO temp : list) {
            temp.setId((Long) documents.get(index).get("resume_id"));
            index++;
        }
        map.put("list", list);
        map.put("total", total);
        return map;

    }

    @Override
    public Map<String, Object> search(String keyword, Integer page, Integer size, OcmsResumeDTO resumeDTO) {

        Map<String, Object> map = new HashMap<>();
        SolrQuery sq = new SolrQuery();


        String name = resumeDTO.getName();
        String skills = resumeDTO.getSkills();
        String evaluationLevel = resumeDTO.getEvaluationLevel();

//        设置查询条件
        StringBuffer queryParams = new StringBuffer();
//         设置关键字的模糊匹配
        if(keyword!=null){
            if(!keyword.equals("")|keyword.equals("undefined")){
                queryParams.append("otherRemarks:").append(keyword).append(" OR ")
                        .append("university:").append(keyword).append(" OR ")
                        .append("email:").append(keyword).append(" OR ")
                        .append("loginName:").append(keyword).append(" OR ")
                        .append("residence:").append(keyword);
            }else {
                queryParams.append("id:*");
            }

        }else {
            queryParams.append("id:*");
        }
//          设置筛选
        if (name != null) {
            if(!name.equals("")||!name.equals("undefined")){
                queryParams.append(" AND ").append("name:").append(name);
            }
        }
        if (skills != null) {
            if(!skills.equals("")||!skills.equals("undefined")){
                queryParams.append(" AND ").append("skills:").append(skills);
            }
        }
        if (evaluationLevel != null) {
            if(!evaluationLevel.equals("")||!evaluationLevel.equals("undefined")){
                queryParams.append(" AND ").append("evaluationLevel:").append(evaluationLevel);
            }
        }

        if (resumeDTO.getWorkYear() != null) {
            queryParams.append(" AND ").append("workYear:").append(resumeDTO.getWorkYear());
        }
        if (resumeDTO.getEndWorkDate() != null) {
            queryParams.append(" AND ").append("endWorkDate:").append(resumeDTO.getEndWorkDate());
        }
        if(resumeDTO.getSex()!=null){
            queryParams.append(" AND ").append("sex:").append(resumeDTO.getSex());
        }


        System.out.println(queryParams.toString());
        sq.set("q", queryParams.toString());

//        设置分页
        sq.setStart(page);
        sq.setRows(size);

        QueryResponse qr = null;
        try {
            qr = client.query("resume", sq);
        } catch (SolrServerException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        List<OcmsResumeDTO> list = qr.getBeans(OcmsResumeDTO.class);
        SolrDocumentList documents = qr.getResults();

//        获取总数
        Long total = documents.getNumFound();
        int index = 0;
        for (OcmsResumeDTO temp : list) {
            temp.setId((Long) documents.get(index).get("resume_id"));
            index++;
        }
        map.put("list", list);
        map.put("total", total);
        return map;

    }


    /**
     * 对于resume的增量导入
     *
     * @return
     */
    public String deltaImport() {

        String request = HttpUtil.sendPost(solrHost+"/resume/dataimport?command=delta-import", null);
        return request;
    }


    /**
     * 删除索引
     * @param condition
     * @return
     */
    public UpdateResponse deleteIndex(String condition){
        System.out.println("condition: "+condition);
        UpdateResponse updateResponse = null;
        try {
            updateResponse  =  client.deleteById("resume",condition);
            client.commit("resume");
        } catch (SolrServerException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return updateResponse;
    }



}
