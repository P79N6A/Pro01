package com.czhand.ocms.search.app.service.impl;

import com.czhand.ocms.search.app.service.SolrCloudConfService;
import com.czhand.ocms.search.infra.common.FileUtil;
import com.czhand.ocms.search.infra.common.HttpUtil;
import org.apache.solr.client.solrj.impl.ZkClientClusterStateProvider;
import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.nio.file.Paths;

/*
 * @description:
 * @program: SolrCloudConfHandler
 * @author: syun
 * @create: 2018-07-27 15:21
 */
@Service
public class SolrCloudConfServiceImpl implements SolrCloudConfService {


    private Logger logger = LoggerFactory.getLogger(SolrCloudConfServiceImpl.class);


    @Autowired
    private ZkClientClusterStateProvider zkClientClusterStateProvider;


    public  void uploadConf(String confName,String path){
        try {
            zkClientClusterStateProvider.uploadConfig(Paths.get(path),confName);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


    public String downloadConf(String confName,String destPath){
        try {
            zkClientClusterStateProvider.downloadConfig(confName, Paths.get(destPath));
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }


    /**
     * 配置文件上传
     * @param file
     * @param configName
     */
    public  void uploadConf(MultipartFile file,String configName){
        try {
            String tempPath = FileUtil.fileWrite(file);
            Thread.sleep(500L);
            File tempFile = new File(tempPath);
            String unzip = FileUtil.unZipFiles(tempFile,tempFile.getParent()+"/");
            Thread.sleep(500L);
//            System.out.println(tempFile.getAbsoluteFile());

            logger.info("tempFile.getAbsoluteFile():{}",tempFile.getAbsoluteFile());

//            临时文件删除
            tempFile.delete();
//            上传配置文件至zookeeper
            zkClientClusterStateProvider.uploadConfig(Paths.get(unzip), configName);
        } catch (IOException e) {
            e.printStackTrace();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }


    /**
     * 配置所需上传
     */
    public String uploadFile(MultipartFile file,String path){
        String filePath = null;
        try {
            filePath = FileUtil.fileWrite(file, path);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return filePath;
    }






}
