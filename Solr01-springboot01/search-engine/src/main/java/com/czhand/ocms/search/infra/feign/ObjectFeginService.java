package com.czhand.ocms.search.infra.feign;

import com.czhand.ocms.search.api.dto.OcmsObjectDTO;
import com.czhand.ocms.search.infra.feign.fallback.ObjectFeginFallBack;
import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

/*
 * @description:
 * @program: search-engine
 * @author: syun
 * @create: 2018-08-02 14:27
 */
@FeignClient(value = "baseinfo-service", fallback = ObjectFeginFallBack.class)
@RequestMapping(value = "/resume/ocmsObject")
public interface ObjectFeginService {


    @GetMapping("/{id}")
    public ResponseEntity<OcmsObjectDTO> query(@PathVariable("id") Long id);

}
