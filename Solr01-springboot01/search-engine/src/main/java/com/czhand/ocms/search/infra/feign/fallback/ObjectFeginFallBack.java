package com.czhand.ocms.search.infra.feign.fallback;

import com.czhand.ocms.search.api.dto.OcmsObjectDTO;
import com.czhand.ocms.search.infra.feign.ObjectFeginService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

/*
 * @description:
 * @program: search-engine
 * @author: syun
 * @create: 2018-08-02 15:06
 */
public class ObjectFeginFallBack implements ObjectFeginService {

    private static final Logger LOGGER = LoggerFactory.getLogger(ObjectFeginFallBack.class);


    @Override
    public ResponseEntity<OcmsObjectDTO> query(Long id) {
        LOGGER.error("查询OcmsObjectDTO失败: {},", id);
        return new ResponseEntity("查询OcmsObjectDTO失败", HttpStatus.INTERNAL_SERVER_ERROR);
    }
}
