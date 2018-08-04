package com.czhand.ocms.search.infra.feign.fallback;

import com.czhand.ocms.search.infra.feign.DemandApplyFeginService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

/*
 * @description:
 * @program: search-engine
 * @author: syun
 * @create: 2018-08-03 10:47
 */
public class DemandApplyFallBack implements DemandApplyFeginService {

    private static final Logger LOGGER = LoggerFactory.getLogger(ObjectFeginFallBack.class);


    @Override
    public Integer getCount(Long demandId) {
        LOGGER.error("查询OcmsObjectDTO失败: {},", demandId);

        return Math.toIntExact(demandId);
    }
}
