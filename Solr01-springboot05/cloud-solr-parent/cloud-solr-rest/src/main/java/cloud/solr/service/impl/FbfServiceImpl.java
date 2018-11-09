package cloud.solr.service.impl;

import cloud.solr.domain.Fbf;
import cloud.solr.service.FbfService;
import cloud.solr.service.baseSolrService.BaseSolrService;
import org.apache.commons.lang3.math.NumberUtils;
import org.apache.solr.client.solrj.SolrQuery;
import org.apache.solr.client.solrj.SolrServerException;
import org.apache.solr.client.solrj.impl.HttpSolrClient;
import org.apache.solr.client.solrj.response.QueryResponse;
import org.apache.solr.common.SolrDocument;
import org.apache.solr.common.SolrDocumentList;
import org.apache.solr.common.StringUtils;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpServletRequest;
import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by Administrator on 2017/10/11.
 */
@Service
public class FbfServiceImpl extends BaseSolrService implements FbfService {
    private HttpSolrClient solrServer;

    @Override
    public Map<String, Object> getObjectWithBasespace(HttpServletRequest request) {
        long start  = System.currentTimeMillis();
        if(solrServer == null){
            solrServer = getSolrServer("fbf");
        }
        SolrQuery query = new SolrQuery();

//        query.setSort("createtime",SolrQuery.ORDER.asc);
        String pageNo = request.getParameter("pageNo");  //第几页
        String pageSize = request.getParameter("pageSize"); //每页多少数据
        if(NumberUtils.isNumber(pageNo) && NumberUtils.isNumber(pageSize)){
            int startPage = Integer.valueOf(pageNo);
            int pageNum = Integer.valueOf(pageSize);
            query.setStart((startPage-1)*pageNum);//起始页
            query.setRows(pageNum);//每页显示数量
        }
        String qwpp = request.getParameter("qwpp");
        StringBuffer buffer = new StringBuffer();
        String[] qwppArray = null;
        if(!StringUtils.isEmpty(qwpp)){
            qwppArray = qwpp.split("\\s+");
            for(String qwppStr:qwppArray){
                buffer.append("qwpp:*"+qwppStr+"* AND ");
            }
            String bufferStr = buffer.toString();
            if(bufferStr.endsWith(" AND ")){
                bufferStr = bufferStr.substring(0,bufferStr.lastIndexOf(" AND "));
            }
            query.set("q",bufferStr);
        }else{
            query.set("q","*:*");
        }
        QueryResponse rsp = null;
        try {
            rsp = solrServer.query( query );
        } catch (SolrServerException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        //获取所有高亮的字段
        SolrDocumentList results = rsp.getResults();
        List<Fbf> fbfList = rsp.getBeans(Fbf.class);
        for(Fbf fbf:fbfList){
            if(qwppArray != null){
                for(String qwppStr:qwppArray){
                    if(!StringUtils.isEmpty(fbf.getFbfbm()))
                        fbf.setFbfbm(fbf.getFbfbm().replace(qwppStr,"<font color='red'>"+qwppStr+"</font>"));
                    if(!StringUtils.isEmpty(fbf.getFbfmc()))
                        fbf.setFbfmc(fbf.getFbfmc().replace(qwppStr,"<font color='red'>"+qwppStr+"</font>"));
                    if(!StringUtils.isEmpty(fbf.getFzrzjhm()))
                        fbf.setFzrzjhm(fbf.getFzrzjhm().replace(qwppStr,"<font color='red'>"+qwppStr+"</font>"));
                    if(!StringUtils.isEmpty(fbf.getFbffzrxm()))
                        fbf.setFbffzrxm(fbf.getFbffzrxm().replace(qwppStr,"<font color='red'>"+qwppStr+"</font>"));
                    if(!StringUtils.isEmpty(fbf.getLxdh()))
                        fbf.setLxdh(fbf.getLxdh().replace(qwppStr,"<font color='red'>"+qwppStr+"</font>"));
                    if(!StringUtils.isEmpty(fbf.getFbfdz()))
                        fbf.setFbfdz(fbf.getFbfdz().replace(qwppStr,"<font color='red'>"+qwppStr+"</font>"));
                }
            }
        }
        Map result = new HashMap<String,Object>();
        result.put("totalNum",results.getNumFound());
        result.put("fbfList",fbfList);
        long end  = System.currentTimeMillis();
        System.out.println("Fbf查询消耗时间："+(end-start)+"ms");
        return result;
    }

    @Override
    public Map<String,Object> getObjectByAll(HttpServletRequest request) {
        long start  = System.currentTimeMillis();
        if(solrServer == null){
            solrServer = getSolrServer("fbf");
        }
        SolrQuery query = new SolrQuery();

//        query.setSort("createtime",SolrQuery.ORDER.asc);
        String pageNo = request.getParameter("pageNo");  //第几页
        String pageSize = request.getParameter("pageSize"); //每页多少数据
        if(NumberUtils.isNumber(pageNo) && NumberUtils.isNumber(pageSize)){
            int startPage = Integer.valueOf(pageNo);
            int pageNum = Integer.valueOf(pageSize);
            query.setStart((startPage-1)*pageNum);//起始页
            query.setRows(pageNum);//每页显示数量
        }

        query.setHighlight(true);// 开启高亮组件
        query.setHighlightRequireFieldMatch(true);
//        query.set("hl.preserveMulti","true");//启用多字段高亮
        query.set("hl.fl","fbfbm,fbfmc,fbffzrxm,fbfdz"); // 高亮字段
//        query.addHighlightField("fbfbm"); // 高亮字段
//        query.addHighlightField("fbffzrxm"); // 高亮字段
//        query.addHighlightField("fbfdz"); // 高亮字段
        //标记，高亮关键字前缀
        query.setHighlightSimplePre("<font color='red'>");
        query.setHighlightSimplePost("</font>");//后缀
//        query.set("defType","dismax");
//        query.set("qf","fbfbm^2");
        /**
         //获取高亮分片数，一般搜索词可能分布在文章中的不同位置，其所在一定长度的
         语句即为一个片段，默认为1，但根据业务需要有时候需要多取出几个分片。
         - 此处设置决定下文中titleList, contentList中元素的个数
         **/

        /**
         每个分片的最大长度，默认为100。
         适当设置此值，如果太小，高亮的标题可能会显不全；
         设置太大，摘要可能会太长。
         **/
        query.setHighlightFragsize(150);
        String qwpp = request.getParameter("qwpp");
        StringBuffer buffer = new StringBuffer();
        if(!StringUtils.isEmpty(qwpp)){
            buffer.append("fbfbm:"+qwpp+" OR ");
            buffer.append("fbfmc:"+qwpp+" OR ");
            buffer.append("fbffzrxm:"+qwpp+" OR ");
            buffer.append("fzrzjhm:"+qwpp+" OR ");
            buffer.append("lxdh:"+qwpp+" OR ");
            buffer.append("fbfdz:"+qwpp+" OR ");
            buffer.append("yzbm:"+qwpp+" OR ");
            buffer.append("fbfdcy:"+qwpp+" OR ");
            buffer.append("fbfdcjs:"+qwpp+" OR ");
            buffer.append("sjxzdm:"+qwpp+"");
            query.set("q",buffer.toString());
        }else{
            query.set("q","*:*");
        }
        QueryResponse rsp = null;
        try {
            rsp = solrServer.query( query );
        } catch (SolrServerException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        //获取所有高亮的字段
        SolrDocumentList results = rsp.getResults();
        Map<String,Map<String,List<String>>> highlightresult=rsp.getHighlighting();
        System.out.println(results.getNumFound());//查询总条数
        List<Fbf> fbfList = rsp.getBeans(Fbf.class);
        for(int i=0;i<fbfList.size();i++){
            String poid = fbfList.get(i).getPoid();
            if (highlightresult.get(poid) != null){
                if(highlightresult.get(poid).get("fbfbm") != null){
                    fbfList.get(i).setFbfbm(highlightresult.get(poid).get("fbfbm").get(0));
                }
                if(highlightresult.get(poid).get("fbfmc") != null){
                    fbfList.get(i).setFbfmc(highlightresult.get(poid).get("fbfmc").get(0));
                }
                if(highlightresult.get(poid).get("fbffzrxm") != null){
                    fbfList.get(i).setFbffzrxm(highlightresult.get(poid).get("fbffzrxm").get(0));
                }
                if(highlightresult.get(poid).get("fbfdz") != null){
                    fbfList.get(i).setFbfdz(highlightresult.get(poid).get("fbfdz").get(0));
                }
            }
        }
        Map result = new HashMap<String,Object>();
        result.put("totalNum",results.getNumFound());
        result.put("fbfList",fbfList);
        long end  = System.currentTimeMillis();
        System.out.println("Fbf查询消耗时间："+(end-start)+"ms");
        return result;
    }

    @Override
    public List<Fbf> getObjectByChinese(HttpServletRequest request) {
        return null;
    }

    @Override
    public List<Fbf> getObjectByNum(HttpServletRequest request) {
        return null;
    }

    @Override
    public Map<String,Object> getObjectByReq(HttpServletRequest request) {
        long start  = System.currentTimeMillis();
        if(solrServer == null){
            solrServer = getSolrServer("fbf");
        }
        SolrQuery query = new SolrQuery();
        query.set("q","*:*");
//        query.setSort("createtime",SolrQuery.ORDER.asc);
        String pageNo = request.getParameter("pageNo");  //第几页
        String pageSize = request.getParameter("pageSize"); //每页多少数据
        if(NumberUtils.isNumber(pageNo) && NumberUtils.isNumber(pageSize)){
            int startPage = Integer.valueOf(pageNo);
            int pageNum = Integer.valueOf(pageSize);
            query.setStart((startPage-1)*pageNum);//起始页
            query.setRows(pageNum);//每页显示数量
        }
        query.setHighlight(true);// 开启高亮组件
        query.setHighlightRequireFieldMatch(true);
        query.addHighlightField("fbfbm"); // 高亮字段
        query.addHighlightField("fbfbm"); // 高亮字段
        query.addHighlightField("fbffzrxm"); // 高亮字段
        query.addHighlightField("fbfdz"); // 高亮字段
        //标记，高亮关键字前缀
        query.setHighlightSimplePre("<font color='red'>");
        query.setHighlightSimplePost("</font>");//后缀
        /**
         //获取高亮分片数，一般搜索词可能分布在文章中的不同位置，其所在一定长度的
         语句即为一个片段，默认为1，但根据业务需要有时候需要多取出几个分片。
         - 此处设置决定下文中titleList, contentList中元素的个数
         **/
        query.setHighlight(true).setHighlightSnippets(1);
        /**
         每个分片的最大长度，默认为100。
         适当设置此值，如果太小，高亮的标题可能会显不全；
         设置太大，摘要可能会太长。
         **/
        query.setHighlightFragsize(150);
        StringBuffer buffer = new StringBuffer();
        String fbfbm = request.getParameter("fbfbm");
        if(!StringUtils.isEmpty(fbfbm)){
            buffer.append("fbfbm:*"+fbfbm+"* AND ");
        }
        String fbfmc = request.getParameter("fbfmc");
        if(!StringUtils.isEmpty(fbfmc)){
            buffer.append("fbfmc:"+fbfmc+" AND ");
        }
        String fbffzrxm = request.getParameter("fbffzrxm");
        if(!StringUtils.isEmpty(fbffzrxm)){
            buffer.append("fbffzrxm:"+fbffzrxm+" AND ");
        }
        String fbfdz = request.getParameter("fbfdz");
        if(!StringUtils.isEmpty(fbfdz)){
            buffer.append("fbfdz:"+fbfdz+" AND ");
        }
        String bufferStr = buffer.toString();
        if(StringUtils.isEmpty(bufferStr)){
            query.set("q","*:*");
        }else if(bufferStr.endsWith(" AND ")){
            bufferStr = bufferStr.substring(0,bufferStr.lastIndexOf(" AND "));
            query.set("q",bufferStr);
        }else{
            query.set("q",bufferStr);
        }
        QueryResponse rsp = null;
        try {
            rsp = solrServer.query( query );
        } catch (SolrServerException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        SolrDocumentList results = rsp.getResults();
        Map<String,Map<String,List<String>>> highlightresult=rsp.getHighlighting();
        System.out.println(results.getNumFound());//查询总条数
        List<Fbf> fbfList = rsp.getBeans(Fbf.class);
        for(int i=0;i<fbfList.size();i++){
            String poid = fbfList.get(i).getPoid();
            if (highlightresult.get(poid) != null){
                if(highlightresult.get(poid).get("fbfbm") != null){
                    fbfList.get(i).setFbfbm(highlightresult.get(poid).get("fbfbm").get(0));
                }
                if(highlightresult.get(poid).get("fbfmc") != null){
                    fbfList.get(i).setFbfmc(highlightresult.get(poid).get("fbfmc").get(0));
                }
                if(highlightresult.get(poid).get("fbffzrxm") != null){
                    fbfList.get(i).setFbffzrxm(highlightresult.get(poid).get("fbffzrxm").get(0));
                }
                if(highlightresult.get(poid).get("fbfdz") != null){
                    fbfList.get(i).setFbfdz(highlightresult.get(poid).get("fbfdz").get(0));
                }
            }
        }
        Map result = new HashMap<String,Object>();
        result.put("totalNum",results.getNumFound());
        result.put("fbfList",fbfList);
        long end  = System.currentTimeMillis();
        System.out.println("Fbf查询消耗时间："+(end-start)+"ms");
        return result;
    }

    @Override
    public boolean add(Fbf object) {
        if(solrServer == null){
            solrServer = getSolrServer("fbf");
        }
        try {
            solrServer.addBean(object);
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    @Override
    public boolean delete(String id) {
        if(solrServer == null){
            solrServer = getSolrServer("fbf");
        }
        try {
            solrServer.deleteById(id);
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    public Object getById(String id) {
        if(solrServer == null){
            solrServer = getSolrServer("fbf");
        }
        SolrDocument document = null;
        try {
            document = solrServer.getById(id);
        } catch (SolrServerException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return document;
    }
}
