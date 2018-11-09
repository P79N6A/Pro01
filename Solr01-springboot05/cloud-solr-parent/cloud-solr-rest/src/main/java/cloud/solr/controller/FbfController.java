package cloud.solr.controller;

import cloud.solr.controller.base.BaseController;
import cloud.solr.domain.Fbf;
import cloud.solr.service.FbfService;
import org.apache.solr.common.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;
import java.util.UUID;

/**
 * Created by Administrator on 2017/10/9.
 * 1.该方法没有用到spring data solr jpa形式查询，因为jpa那种形式好像无法做到动态的多个条件拼接查询。
 * 2.solrQuery查询只需要写一个controller和实体类即可，不需要写service等等。
 */
@RestController
@RequestMapping("/solr/fbf")
public class FbfController extends BaseController{
    @Autowired
    private FbfService fbfService;
//    @RequestMapping(value = "/selectZw",method = RequestMethod.GET)
//    @CrossOrigin
//    public Object getFbfLists(HttpServletRequest request){
//        Map<String,Object> resultMap = new HashMap<String,Object>();
//        List<Fbf> fbfList = cbf_jtcyService.getObjectByChinese(request);
//        resultMap.put("fbf",fbfList);
//        return resultMap;
//    }

    @RequestMapping(value = "/selectQw",method = RequestMethod.GET)
    @CrossOrigin
    public Object getFbfListsQw(HttpServletRequest request){
        return fbfService.getObjectWithBasespace(request);
    }

    @RequestMapping(value = "/selectById",method = RequestMethod.GET)
    @CrossOrigin
    public Object getFbfById(HttpServletRequest request){
        Object solrDocument = fbfService.getById(request.getParameter("id"));
        return solrDocument;
    }

    @RequestMapping(value = "/add",method = RequestMethod.POST)
    @CrossOrigin
    public Object addFbf(HttpServletRequest request){
        String req = request.getParameter("req");
        Fbf fbf = null;
        try {
            jsonTranster.readValue(req,Fbf.class);
        } catch (IOException e) {
            e.printStackTrace();
        }
        if(fbf == null){
            return addResultMapMsg(false,"添加索引的对象不能为空");
        }
        String poid = fbf.getPoid();
        if(StringUtils.isEmpty(poid)){
            poid = UUID.randomUUID().toString();
            fbf.setPoid(poid);
        }
        Object solrDocument = fbfService.getById(poid);
        if(solrDocument == null){
            boolean flag = fbfService.add(fbf);
            if(flag){
                return addResultMapMsg(true,poid);
            }else{
                return addResultMapMsg(false,"添加失败");
            }
        }
        return addResultMapMsg(false,"该id下的对象已存在，不能添加");
    }

    @RequestMapping(value = "/deleteById",method = RequestMethod.POST)
    @CrossOrigin
    public Object deleteFbfById(HttpServletRequest request){
        String id = request.getParameter("id");
        if(StringUtils.isEmpty(id)){
            return addResultMapMsg(false,"id不能为空");
        }
        boolean flag  = fbfService.delete(id);
        if(flag){
            return addResultMapMsg(true,"删除成功");
        }else{
            return addResultMapMsg(false,"删除失败");
        }
    }
}
