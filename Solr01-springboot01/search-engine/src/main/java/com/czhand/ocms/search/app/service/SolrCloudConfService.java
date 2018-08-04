package com.czhand.ocms.search.app.service;

import org.springframework.web.multipart.MultipartFile;

/*
 * @program: search-engine
 * @author: syun
 * @create: 2018-07-30 16:00
 */
public interface SolrCloudConfService {




    public void uploadConf(MultipartFile file, String configName);

    public String uploadFile(MultipartFile file, String path);

}
