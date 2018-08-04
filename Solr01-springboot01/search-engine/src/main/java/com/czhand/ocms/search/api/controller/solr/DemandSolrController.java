package com.czhand.ocms.search.api.controller.solr;

import com.czhand.ocms.search.api.dto.OcmsDemandDTO;
import com.czhand.ocms.search.app.service.DemandSolrService;
import com.czhand.ocms.search.infra.feign.ObjectFeginService;
import com.netflix.discovery.converters.Auto;
import io.choerodon.core.exception.CommonException;
import io.choerodon.core.iam.ResourceLevel;
import io.choerodon.swagger.annotation.Permission;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.Map;
import java.util.Optional;

/*
 * @description:
 * @program: search-engine
 * @author: syun
 * @create: 2018-08-01 15:12
 */
@RestController
@RequestMapping("resume/solr/demand")
public class DemandSolrController {

    @Autowired
    private DemandSolrService demandSolrService;


    @Permission(level = ResourceLevel.SITE)
    @ApiOperation("需求信息全文搜索(分页),通过项目经理id匹配")
    @PostMapping("/searchManage/{page}/{size}")
    public ResponseEntity<Map<String, Object>> searchInfopageManage(@RequestParam(value = "keyword" ,required = false)  String keyword,
                                                              @PathVariable(value = "page") Integer page,
                                                              @PathVariable(value = "size") Integer size,
                                                              @RequestBody OcmsDemandDTO demandDTO){

        return Optional.ofNullable(demandSolrService.searchByManage(keyword,page,size,demandDTO))
                .map(result -> new ResponseEntity<>(result, HttpStatus.OK))
                .orElseThrow(() -> new CommonException("error.resume.search"));
    }

    @Permission(level = ResourceLevel.SITE)
    @ApiOperation("需求信息全文搜索(分页),通过审批人id匹配")
    @PostMapping("/searchExamine/{page}/{size}")
    public ResponseEntity<Map<String, Object>> searchInfopageExamine(@RequestParam(value = "keyword" ,required = false)  String keyword,
                                                              @PathVariable(value = "page") Integer page,
                                                              @PathVariable(value = "size") Integer size,
                                                              @RequestBody OcmsDemandDTO demandDTO){

        return Optional.ofNullable(demandSolrService.searchByExamine(keyword,page,size,demandDTO))
                .map(result -> new ResponseEntity<>(result, HttpStatus.OK))
                .orElseThrow(() -> new CommonException("error.resume.search"));
    }



    @Permission(level = ResourceLevel.SITE)
    @ApiImplicitParam("删除索引")
    @DeleteMapping("delete/{condition}")
    public String deleteAll(@PathVariable(value = "condition") String condition){
//        return Optional.ofNullable(demandSolrService.deleteIndex())
        return null;
    }

}
