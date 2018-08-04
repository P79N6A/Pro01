package com.czhand.ocms.search.api.controller.solr;

import com.czhand.ocms.search.api.dto.OcmsResumeDTO;
import com.czhand.ocms.search.app.service.ResumeSolrService;
import io.choerodon.core.exception.CommonException;
import io.choerodon.core.iam.ResourceLevel;
import io.choerodon.swagger.annotation.Permission;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiOperation;
import org.apache.solr.client.solrj.response.UpdateResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;
import java.util.Optional;

/*
 * @description:
 * @program: search-engine
 * @author: syun
 * @create: 2018-07-29 21:29
 */
@RestController
@RequestMapping("/resume/solr")
public class ResumeSolrController {

    @Autowired
    private ResumeSolrService resumeSolrService;



    @Permission(level = ResourceLevel.SITE)
    @ApiOperation("全文搜索(全部记录)")
    @PostMapping("/kw")
    public ResponseEntity<List<OcmsResumeDTO>> searchInfo(@RequestParam("keyword") String keyword){

        return Optional.ofNullable(resumeSolrService.search(keyword))
                .map(result -> new ResponseEntity<>(result, HttpStatus.OK))
                .orElseThrow(() -> new CommonException("error.resume.search"));
    }

    /**
     * resume表全文搜索(分页)
     * @param keyword 关键字
     * @param page 页码
     * @param size 每页记录数
     * @return
     */
    @Permission(level = ResourceLevel.SITE)
    @ApiOperation("顾问信息全文搜索(分页及筛选)")
    @PostMapping("/search/{page}/{size}")
    public ResponseEntity<Map<String, Object>> search(@RequestParam(value = "keyword",required = false) String keyword,
                                                      @PathVariable(value = "page") Integer page,
                                                      @PathVariable(value = "size") Integer size,
                                                      @RequestBody OcmsResumeDTO resumeDTO){

        return Optional.ofNullable(resumeSolrService.search(keyword,page,size,resumeDTO))
                .map(result -> new ResponseEntity<>(result, HttpStatus.OK))
                .orElseThrow(() -> new CommonException("error.resume.search"));
    }



    @Permission(level = ResourceLevel.SITE)
    @ApiImplicitParam("删除索引")
    @DeleteMapping("delete/{condition}")
    public ResponseEntity<UpdateResponse> deleteAll(@PathVariable(value = "condition") String condition){
        return Optional.ofNullable(resumeSolrService.deleteIndex(condition))
                .map(result -> new ResponseEntity<>(result, HttpStatus.OK))
                .orElseThrow(() -> new CommonException("error.resume.search"));
    }






}
