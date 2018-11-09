package cloud.solr.service.baseSolrService;

import org.apache.solr.client.solrj.impl.HttpSolrClient;
import org.apache.solr.common.SolrDocument;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Value;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by Administrator on 2017/10/11.
 */
public abstract class BaseSolrService<T> {
    @Value("${spring.data.solr.host}")
    private String url;
    public HttpSolrClient getSolrServer(String coreName) {
        return new HttpSolrClient (url+"/"+coreName);
    }
    public synchronized Map<String, Object> addResultMapMsg(boolean flag, String msg){
        Map<String, Object> map = new HashMap<String, Object>();
        map.put("success", flag);
        map.put("msg", msg);
        return map;
    }
    /**
     * 将SolrDocument转换成Bean
     * @param record
     * @param clazz
     * @return
     */
//    public static Object toBean(SolrDocument record, Class clazz){
//        Object obj = null;
//        try {
//            obj = clazz.newInstance();
//        } catch (InstantiationException e1) {
//            e1.printStackTrace();
//        } catch (IllegalAccessException e1) {
//            e1.printStackTrace();
//        }
//        Field[] fields = clazz.getDeclaredFields();
//        for(Field field:fields){
//            Object value = record.get(field.getName());
//            try {
//                BeanUtils.setProperty(obj, field.getName(), value);
//            } catch (IllegalAccessException e) {
//                e.printStackTrace();
//            } catch (InvocationTargetException e) {
//                e.printStackTrace();
//            }
//        }
//        return obj;
//    }
}
