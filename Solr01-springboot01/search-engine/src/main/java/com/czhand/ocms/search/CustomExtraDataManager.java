package com.czhand.ocms.search;

import io.choerodon.core.swagger.ChoerodonRouteData;
import io.choerodon.swagger.annotation.ChoerodonExtraData;
import io.choerodon.swagger.custom.extra.ExtraData;
import io.choerodon.swagger.custom.extra.ExtraDataManager;

@ChoerodonExtraData
public class CustomExtraDataManager implements ExtraDataManager {
    @Override
    public ExtraData getData() {
        ChoerodonRouteData choerodonRouteData = new ChoerodonRouteData();
        choerodonRouteData.setName("search");
        choerodonRouteData.setPath("/search/**");
        choerodonRouteData.setServiceId("search-engine");
        extraData.put(ExtraData.ZUUL_ROUTE_DATA, choerodonRouteData);
        return extraData;
    }
}
