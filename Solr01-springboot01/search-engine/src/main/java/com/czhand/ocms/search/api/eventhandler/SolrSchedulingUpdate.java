package com.czhand.ocms.search.api.eventhandler;

import com.czhand.ocms.search.app.service.DemandSolrService;
import com.czhand.ocms.search.app.service.ResumeSolrService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.text.SimpleDateFormat;

/*
 * @description:
 * @program: search-engine
 * @author: syun
 * @create: 2018-08-01 13:12
 */
@Component
public class SolrSchedulingUpdate {

    @Autowired
    private ResumeSolrService resumeSolrService;

    @Autowired
    private DemandSolrService demandSolrService;

    private static final Logger log = LoggerFactory.getLogger(SolrSchedulingUpdate.class);

    private static final SimpleDateFormat dateFormat = new SimpleDateFormat("HH:mm:ss");


    /**
     * resume表
     * 定时增量导入数据
     */
    @Scheduled(initialDelay = 1000, fixedRate = 1000*60*5)
    public void resumeUpdate() {
        log.info("resume deltaImport {}", resumeSolrService.deltaImport());
    }


    @Scheduled(initialDelay = 1000,fixedRate = 1000*60*5)
    public void demandUpdate(){
        log.info("demand deltaImport {}", demandSolrService.deltaImport());
    }


}
