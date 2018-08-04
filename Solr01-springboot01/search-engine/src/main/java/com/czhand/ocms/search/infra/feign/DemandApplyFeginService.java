package com.czhand.ocms.search.infra.feign;

import com.czhand.ocms.search.infra.feign.fallback.DemandApplyFallBack;
import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

/*
 * @program: search-engine
 * @author: syun
 * @create: 2018-08-03 10:45
 */
@FeignClient(value = "baseinfo-service" ,fallback = DemandApplyFallBack.class)
@RequestMapping(value = "/resume/ocms/demandApply")
public interface DemandApplyFeginService  {

    @GetMapping("/getCountOfParticipantsByDemandId/{demandId}")
    public Integer getCount(@PathVariable("demandId") Long demandId);

}
