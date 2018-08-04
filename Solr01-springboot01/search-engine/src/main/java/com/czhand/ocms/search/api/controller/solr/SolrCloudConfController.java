package com.czhand.ocms.search.api.controller.solr;

import com.czhand.ocms.search.app.service.SolrCloudConfService;
import io.choerodon.core.iam.ResourceLevel;
import io.choerodon.swagger.annotation.Permission;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

/*
 * @description:
 * @program: search-engine
 * @author: syun
 * @create: 2018-07-27 16:04
 */
@RestController
@RequestMapping("/resume/config")
public class SolrCloudConfController {

    @Autowired
    private SolrCloudConfService solrCloudConfService;


    /**
     * 配置文件上传
     * @param file 上传的文件夹的zip压缩文件
     * @return
     */
    @Permission(level = ResourceLevel.SITE)
    @PostMapping()
    @ApiOperation("配置文件上传(以zip格式)")
    public String confUpload(@RequestParam("file")MultipartFile file,
                             @RequestParam("configName") String configName) {
        solrCloudConfService.uploadConf(file, configName);
        return "upload success";
    }


    /**
     * 文件上传
     * @param file 需要上传的文件
     * @param path 系统绝对路径
     * @return
     */
    @Permission(level = ResourceLevel.SITE)
    @PostMapping("/fileUpload")
    @ApiOperation("文件上传")
    public String jarUpload(@RequestParam("file")MultipartFile file,
                            @RequestParam("path") String path){

        return solrCloudConfService.uploadFile(file, path);
    }



//    @GetMapping("/test/{test}")
//    public String test(@PathVariable("test") String test){
//
//        solrCloudConfService.test();
//
//        return "suceee";
//    }
//



}
