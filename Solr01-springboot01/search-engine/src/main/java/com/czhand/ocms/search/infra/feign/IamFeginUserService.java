package com.czhand.ocms.search.infra.feign;

import com.czhand.ocms.search.api.dto.UserDTO;
import com.czhand.ocms.search.infra.feign.fallback.IamFeginFallback;
import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/*
 * @program: search-engine
 * @author: syun
 * @create: 2018-08-03 09:35
 */
@FeignClient(value = "iam-service" ,fallback = IamFeginFallback.class)
@RequestMapping(value = "/v1/users")
public interface IamFeginUserService {

    @GetMapping("/{id}/info")
    public ResponseEntity<UserDTO> queryInfo( @PathVariable("id") Long id);

    @PostMapping(value = "/ids")
    public ResponseEntity<List<UserDTO>> listUsersByIds(@RequestBody Long[] ids);
}
