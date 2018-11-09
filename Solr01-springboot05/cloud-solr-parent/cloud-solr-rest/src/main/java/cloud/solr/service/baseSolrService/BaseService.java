package cloud.solr.service.baseSolrService;

import javax.servlet.http.HttpServletRequest;
import java.util.List;
import java.util.Map;

/**
 * Created by Administrator on 2017/10/11.
 */
public interface BaseService<T> {

    /**
     * 该接口为了一个特别需求用。可以删掉
     * @param request
     * @return
     */
    public abstract Map<String,Object> getObjectWithBasespace(HttpServletRequest request);

    /**
     * 全字段匹配查询
     * @param request
     * @return
     */
    public abstract Map<String,Object> getObjectByAll(HttpServletRequest request);
    /**
     * 中文多字段匹配查询
     * @param request
     * @return
     */
    public abstract List<T> getObjectByChinese(HttpServletRequest request);

    /**
     * 数字多字段匹配查询
     * @param request
     * @return
     */
    public abstract List<T> getObjectByNum(HttpServletRequest request);

    /**
     * 高级匹配查询（and）
     * @param request
     * @return
     */
    public abstract  Map<String,Object> getObjectByReq(HttpServletRequest request);

    /**
     * 添加索引
     * @param object
     * @return
     */
    public boolean add(T object);

    /**
     * 删除索引
     */
    public boolean delete(String id);

    /**
     * 根据id获取对象
     * @param id
     * @return
     */
    public Object getById(String id);


}