package cloud.solr.controller.base;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.apache.commons.lang3.StringUtils;
import org.apache.solr.client.solrj.impl.HttpSolrClient;
import org.apache.solr.client.solrj.impl.HttpSolrServer;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;

import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by Administrator on 2017/10/9.
 */
public class BaseController {
    @Value("${spring.data.solr.host}")
    private String url;
    public ObjectMapper jsonTranster = new ObjectMapper();
    public HttpSolrClient getSolrServer(String coreName) {
        return new HttpSolrClient (url+"/"+coreName);
    }
    /**
     * 获取分页请求
     */
    protected PageRequest getPageRequest(HttpServletRequest request){
        int page = 1;
        int size = 10;
        Sort sort = null;
        try {
            String sortName = request.getParameter("sortName");
            String sortOrder = request.getParameter("sortOrder");
            if(StringUtils.isNotBlank(sortName) ){
                if("desc".equalsIgnoreCase(sortOrder)){
                    sort = new Sort(Sort.Direction.DESC, sortName);
                }else{
                    sort = new Sort(Sort.Direction.ASC, sortName);
                }
            }
            page = Integer.parseInt(request.getParameter("pageNo")) - 1;
            size = Integer.parseInt(request.getParameter("pageSize"));
        } catch (Exception e) {
            e.printStackTrace();
        }
        if(sort == null){
            sort = new Sort(Sort.Direction.ASC, "id");
        }
        PageRequest pageRequest = new PageRequest(page, size, sort);
        return pageRequest;
    }
    public synchronized Map<String, Object> addResultMapMsg(boolean flag, String msg){
        Map<String, Object> map = new HashMap<String, Object>();
        map.put("success", flag);
        map.put("msg", msg);
        return map;
    }
}
