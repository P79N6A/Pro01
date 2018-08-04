package com.czhand.ocms.search.app.service.impl;

import com.czhand.ocms.search.api.dto.OcmsDemandDTO;
import com.czhand.ocms.search.api.dto.OcmsObjectDTO;
import com.czhand.ocms.search.api.dto.UserDTO;
import com.czhand.ocms.search.app.service.DemandSolrService;
import com.czhand.ocms.search.infra.common.HttpUtil;
import com.czhand.ocms.search.infra.feign.DemandApplyFeginService;
import com.czhand.ocms.search.infra.feign.IamFeginUserService;
import com.czhand.ocms.search.infra.feign.ObjectFeginService;
import org.apache.solr.client.solrj.SolrClient;
import org.apache.solr.client.solrj.SolrQuery;
import org.apache.solr.client.solrj.SolrServerException;
import org.apache.solr.client.solrj.response.QueryResponse;
import org.apache.solr.client.solrj.response.UpdateResponse;
import org.apache.solr.common.SolrDocument;
import org.apache.solr.common.SolrDocumentList;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/*
 * @description:
 * @program: search-engine
 * @author: syun
 * @create: 2018-08-01 14:46
 */
@Service
public class DemandSolrServiceImpl implements DemandSolrService {

    @Autowired
    private SolrClient client;


    @Autowired
    private ObjectFeginService objectFeginService;

    @Autowired
    private IamFeginUserService iamFeginUserService;


    @Autowired
    private DemandApplyFeginService demandApplyFeginService;


    @Value("${spring.data.solr.solr-host}")
    private String solrHost;

    private Logger logger = LoggerFactory.getLogger(DemandSolrServiceImpl.class);



    @Override
    public Map<String, Object> search(String keyword, Integer page, Integer size) {

        Map<String, Object> map = new HashMap<>();
        SolrQuery sq = new SolrQuery();
//        设置查询条件
        StringBuffer queryParams = new StringBuffer();
        queryParams.append("modular:").append(keyword).append(" OR ")
                .append("requirementDescription:").append(keyword).append(" OR ")
                .append("workAddress:").append(keyword).append(" OR ")
                .append("type:").append(keyword).append(" OR ")
                .append("demandNo:").append(keyword);
        sq.set("q", queryParams.toString());
//        设置分页
        sq.setStart(page);
        sq.setRows(size);

        QueryResponse qr = null;
        try {
            qr = client.query("demand", sq);
        } catch (SolrServerException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        List<OcmsDemandDTO> list = qr.getBeans(OcmsDemandDTO.class);
        SolrDocumentList documents = qr.getResults();
        for(SolrDocument document:documents){
            System.out.println(document.toString());

        }
//        获取总数
        Long total = documents.getNumFound();
        int index = 0;
        for (OcmsDemandDTO temp : list) {
            temp.setId((Long) documents.get(index).get("demand_id"));
            index++;
        }
        map.put("list", list);
        map.put("total", total);
        return map;
    }


    @Override
    public Map<String, Object> searchByManage(String keyword,Integer page,Integer size,OcmsDemandDTO demandDTO) {
        Map<String, Object> map = new HashMap<>();
        SolrQuery sq = new SolrQuery();
        String demandNo = demandDTO.getDemandNo();
        String type = demandDTO.getType();
        String modular = demandDTO.getModular();
        Long employmentTime = demandDTO.getEmploymentTime();

//        设置查询条件
        StringBuffer queryParams = new StringBuffer();

//        若是keyword为空则匹配所有
        if(keyword!=null){
            if(keyword.equals("")||keyword.equals("undefined")){
                queryParams.append("id:*");
            }else {
                queryParams.append("requirementDescription:").append(keyword).append(" OR ")
                        .append("workAddress:").append(keyword);
            }
        }else {
            queryParams.append("id:*");
        }
//          设置筛选
        if(demandNo!=null){
            if(!demandNo.equals("undefined")|!demandNo.equals("")){
                queryParams.append(" AND ").append("demandNo:").append(demandNo);
            }
        }
        if(!(type==null)){
            if(!type.equals("undefined")|!type.equals("")){
                queryParams.append(" AND ").append("type:").append(type);
            }
        }
        if(!(modular==null)){
            if(!modular.equals("undefined")|!modular.equals("")){
                queryParams.append(" AND ").append("modular:").append(modular);
            }
        }
        if(!(employmentTime==null)){
            queryParams.append(" AND ").append("employmentTime:").append(employmentTime);
        }
        if(demandDTO.getStatus()!=null){
            queryParams.append(" AND ").append("status:").append(demandDTO.getStatus());
        }
        if (demandDTO.getExamineStatus() != null) {
            queryParams.append(" AND ").append("examineStatus:").append(demandDTO.getExamineStatus());
        }
        if(demandDTO.getCreatedBy()!=null){
            queryParams.append(" AND ").append("createdBy:").append(demandDTO.getCreatedBy());
        }


        logger.info("queryParams:{}",queryParams.toString());
        sq.set("q", queryParams.toString());
//        设置分页
        sq.setStart(page);
        sq.setRows(size);

        QueryResponse qr = null;
        try {
            qr = client.query("demand", sq);
        } catch (SolrServerException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        List<OcmsDemandDTO> list = qr.getBeans(OcmsDemandDTO.class);
        SolrDocumentList documents = qr.getResults();

//        获取总数
        Long total = documents.getNumFound();
        int index = 0;
//        调用baseInfo的Object查询接口设置参数
        ResponseEntity<OcmsObjectDTO> ocmsObjectDTO = null;
        for (OcmsDemandDTO temp : list) {
            temp.setId((Long) documents.get(index).get("demand_id"));
//            System.out.println(temp.toString());
            ocmsObjectDTO = objectFeginService.query(temp.getOcmsObjectId());
            temp.setObjectName(ocmsObjectDTO.getBody().getObjectName());

//
//            获取审批人姓名
            if(temp.getExamineId()!=null){
                System.out.println(temp.getExamineId());
                Long[] longs = new Long[]{temp.getExamineId()};
                List<UserDTO> list1 = iamFeginUserService.listUsersByIds(longs).getBody();
                if(list1.size()>0){
                    UserDTO user = list1.get(0);
                    temp.setExamineName(user.getLoginName());
                    temp.setExamineRealName(user.getRealName());
                }
            }
//            获取报名人数
            if(temp.getId()!=null){
                Integer count = demandApplyFeginService.getCount(temp.getId());
                temp.setParticipantNumber(count);
            }

            index++;
        }
        map.put("list", list);
        map.put("total", total);
        return map;
    }



    @Override
    public Map<String, Object> searchByExamine(String keyword,Integer page,Integer size,OcmsDemandDTO demandDTO) {
        Map<String, Object> map = new HashMap<>();
        SolrQuery sq = new SolrQuery();
        String demandNo = demandDTO.getDemandNo();
        String type = demandDTO.getType();
        String modular = demandDTO.getModular();
        Long employmentTime = demandDTO.getEmploymentTime();

//        设置查询条件
        StringBuffer queryParams = new StringBuffer();

//        若是keyword为空则匹配所有
        if(keyword!=null){
            if(keyword.equals("")||keyword.equals("undefined")){
                queryParams.append("id:*");
            }else {
                queryParams.append("requirementDescription:").append(keyword).append(" OR ")
                        .append("workAddress:").append(keyword);
            }
        }else {
            queryParams.append("id:*");
        }
//          设置筛选
        if(demandNo!=null){
            if(!demandNo.equals("undefined")|!demandNo.equals("")){
                queryParams.append(" AND ").append("demandNo:").append(demandNo);
            }
        }
        if(!(type==null)){
            if(!type.equals("undefined")|!type.equals("")){
                queryParams.append(" AND ").append("type:").append(type);
            }

        }
        if(!(modular==null)){
            if(!modular.equals("undefined")|!modular.equals("")){
                queryParams.append(" AND ").append("modular:").append(modular);
            }
        }
        if(!(employmentTime==null)){
            queryParams.append(" AND ").append("employmentTime:").append(employmentTime);
        }
        if(demandDTO.getStatus()!=null){
            queryParams.append(" AND ").append("status:").append(demandDTO.getStatus());
        }
        if (demandDTO.getExamineStatus() != null) {
            queryParams.append(" AND ").append("examineStatus:").append(demandDTO.getExamineStatus());
        }
//        匹配审批人id
        if (demandDTO.getExamineId() != null) {
            queryParams.append(" AND ").append("examineId:").append(demandDTO.getExamineId());
        }

        logger.info("queryParams:{}",queryParams.toString());
        sq.set("q", queryParams.toString());
//        设置分页
        sq.setStart(page);
        sq.setRows(size);

        QueryResponse qr = null;
        try {
            qr = client.query("demand", sq);
        } catch (SolrServerException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        List<OcmsDemandDTO> list = qr.getBeans(OcmsDemandDTO.class);
        SolrDocumentList documents = qr.getResults();

//        获取总数
        Long total = documents.getNumFound();
        int index = 0;
//        调用baseInfo的Object查询接口设置参数
        ResponseEntity<OcmsObjectDTO> ocmsObjectDTO = null;
        for (OcmsDemandDTO temp : list) {
            temp.setId((Long) documents.get(index).get("demand_id"));
//            System.out.println(temp.toString());
            ocmsObjectDTO = objectFeginService.query(temp.getOcmsObjectId());
            temp.setObjectName(ocmsObjectDTO.getBody().getObjectName());

//
//            获取审批人姓名
            if(temp.getExamineId()!=null){
                System.out.println(temp.getExamineId());
                Long[] longs = new Long[]{temp.getExamineId()};
                List<UserDTO> list1 = iamFeginUserService.listUsersByIds(longs).getBody();
                if(list1.size()>0){
                    UserDTO user = list1.get(0);
                    temp.setExamineName(user.getLoginName());
                    temp.setExamineRealName(user.getRealName());
                }
            }
//            获取报名人数
            if(temp.getId()!=null){
                Integer count = demandApplyFeginService.getCount(temp.getId());
                temp.setParticipantNumber(count);
            }

            index++;
        }
        map.put("list", list);
        map.put("total", total);
        return map;
    }


    @Override
    public String deltaImport() {
        String request = HttpUtil.sendPost(solrHost+"/demand/dataimport?command=delta-import", null);
        return request;
    }


    /**
     * 删除索引
     * @param condition
     * @return
     */
    public UpdateResponse deleteIndex(String condition){
        UpdateResponse updateResponse = null;
        try {
           updateResponse  =  client.deleteByQuery("demand", condition);
        } catch (SolrServerException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return updateResponse;
    }

}
