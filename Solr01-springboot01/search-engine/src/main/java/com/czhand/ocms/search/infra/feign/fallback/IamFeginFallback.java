package com.czhand.ocms.search.infra.feign.fallback;

import com.czhand.ocms.search.api.dto.UserDTO;
import com.czhand.ocms.search.infra.feign.IamFeginUserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import java.util.List;

/*
 * @description:
 * @program: search-engine
 * @author: syun
 * @create: 2018-08-03 09:36
 */
public class IamFeginFallback implements IamFeginUserService {
    private static final Logger LOGGER = LoggerFactory.getLogger(IamFeginFallback.class);
    @Override
    public ResponseEntity<UserDTO> queryInfo(Long id) {
        LOGGER.error("通过id查询UserDto失败: {},", id);
        return new ResponseEntity("通过id查询UserDto失败", HttpStatus.INTERNAL_SERVER_ERROR);    }

    @Override
    public ResponseEntity<List<UserDTO>> listUsersByIds(Long[] ids) {
        return null;
    }
}
