//package com.czhand.ocms.search.api.controller.solr;
//
//import com.czhand.ocms.search.api.dto.OcmsDemandDTO;
//import com.czhand.ocms.search.api.dto.Test;
//import org.apache.solr.client.solrj.SolrClient;
//import org.apache.solr.client.solrj.SolrQuery;
//import org.apache.solr.client.solrj.SolrServerException;
//import org.apache.solr.client.solrj.impl.HttpSolrClient;
//import org.apache.solr.client.solrj.request.AbstractUpdateRequest;
//import org.apache.solr.client.solrj.request.ContentStreamUpdateRequest;
//import org.apache.solr.client.solrj.response.QueryResponse;
//import org.apache.solr.common.SolrDocument;
//import org.apache.solr.common.SolrDocumentList;
//import org.apache.solr.common.SolrInputDocument;
//import org.apache.solr.common.params.MapSolrParams;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.web.bind.annotation.*;
//
//import java.io.File;
//import java.io.IOException;
//import java.math.BigDecimal;
//import java.util.*;
//
///**
// * 搜索引擎控制器
// * @author Antemis
// * @date 下午 9:07 2018/7/16/0016
// */
//@RestController
//@RequestMapping(value = "/resume/solr")
//public class SolrController {
//
//    @Autowired
//    private SolrClient client;
//    private Object object;
//
//
//    /**
//     * 新增/修改 索引
//     * 当 id 存在的时候, 此方法是修改(当然, 我这里用的 uuid, 不会存在的), 如果 id 不存在, 则是新增
//     * @return
//     */
//    @PostMapping(value = "/add")
//    public String add() {
//        String uuid = UUID.randomUUID().toString().replaceAll("-", "");
//        try {
//            SolrInputDocument doc = new SolrInputDocument();
//            doc.setField("id", uuid);
//            doc.setField("content_ik", "我是中国人, 我爱中国");
//            /* 如果spring.data.solr.host 里面配置到 core了, 那么这里就不需要传 techproducts 这个参数
//             * 下面都是一样的
//             */
//            client.add("techproducts", doc);
//            //client.commit();
//            client.commit("techproducts");
//            return uuid;
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
//
//        return "error";
//    }
//
//
//    /**
//     * 新增/修改 索引(默认的configSet方式)
//     * 当 id 存在的时候, 此方法是修改(当然, 我这里用的 uuid, 不会存在的), 如果 id 不存在, 则是新增
//     * @return
//     */
//    @PostMapping(value = "/addTest")
//    public String add1() {
//        String uuid = UUID.randomUUID().toString().replaceAll("-", "");
//        SolrInputDocument document = new SolrInputDocument();
//        Test test = new Test();
//        test.setId(UUID.randomUUID().toString());
//        test.setTest("通过实体类加入数据");
//        Object object = test;
//        try {
//            client.addBean("defaultCollection",object);
//            client.commit("defaultCollection");
//            return uuid;
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
//
//        return "error";
//    }
//
//    /**
//     * 新增/修改 索引(默认的configSet方式,通用接口)
//     * 当 id 存在的时候, 此方法是修改(当然, 我这里用的 uuid, 不会存在的), 如果 id 不存在, 则是新增
//     * @return
//     */
//    @PostMapping(value = "/addTest1",consumes = "application/json;charset=utf-8")
//    public String add2(@RequestBody Map<String,Object> objectMap) throws NoSuchFieldException, IllegalAccessException {
//        Object object = new Object();
///*
//        object = analysis(objectMap);
//*/
//        try {
//            client.addBean("defaultCollection",object);
//            client.commit("defaultCollection");
//            return "1";
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
//
//        return "error";
//    }
//
//    /**
//     * 新增/修改 索引(默认的configSet方式,通用接口传对象)
//     * 当 id 存在的时候, 此方法是修改(当然, 我这里用的 uuid, 不会存在的), 如果 id 不存在, 则是新增
//     * @return
//     */
//    @PostMapping(value = "/addDemand")
//    public String add3(@RequestBody OcmsDemandDTO ocmsDemandDTO) throws NoSuchFieldException, IllegalAccessException {
//        Object object1 = new Object();
//        //将ocmsDemandDTO对象空值设置成不为空
//        ocmsDemandDTO = setNotNull(ocmsDemandDTO);
//        object1 = ocmsDemandDTO;
//        try {
//            client.addBean("defaultCollection",object1);
//            client.commit("defaultCollection");
//            return "1";
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
//        return "error";
//    }
//
//    /**
//     * 根据id删除索引
//     * @return
//     */
//    @RequestMapping("delete")
//    public String delete()  {
//        try {
//            client.deleteById("techproducts","5911b2128c9e4be5987dfbdbd934c2f8");
//            client.commit("techproducts");
//            return "5911b2128c9e4be5987dfbdbd934c2f8";
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
//        return "error";
//    }
//
//    /**
//     * 根据id删除索引
//     * @return
//     */
//    @RequestMapping(value = "/deleteById")
//    public String deleteById(@RequestParam(value = "id") Long id,@RequestParam(value = "collection") String collection)  {
//        try {
//            client.deleteById(collection, String.valueOf(id));
//            client.commit(collection);
//            return "1";
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
//        return "error";
//    }
//
//    /**
//     * 删除所有的索引
//     * @return
//     */
//    @RequestMapping("deleteAll")
//    public String deleteAll(){
//        try {
//
//            client.deleteByQuery("techproducts","*:*");
//            client.commit("techproducts");
//
//            return "success";
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
//        return "error";
//    }
//
//    /**
//     * 根据id查询索引
//     * @return
//     * @throws Exception
//     */
//    @RequestMapping(value = "/getById")
//    public String getById() throws Exception {
//        SolrDocument document = client.getById("techproducts", "0812521390");
//        System.out.println(document);
//        return document.toString();
//    }
//
//    /**
//     * 根据id查询索引
//     * @return
//     * @throws Exception
//     */
//    @RequestMapping(value = "/getBySerialNumber")
//    public String getBySerialNumber(@RequestParam(value = "id") Long id,@RequestParam(value = "collection") String collection) throws Exception{
//        /*SolrDocument document = client.getById(collection, String.valueOf(id));*/
//        SolrDocument document = client.getById(collection, String.valueOf(id));
//        System.out.println(document);
//        return document.toString();
//    }
//
//    /**
//     * 根据id查询索引
//     * @return
//     * @throws Exception
//     */
//    @RequestMapping(value = "/getByConditions")
//    public String getByConditions(@RequestParam(value = "id") Long id,@RequestParam(value = "collection") String collection) throws Exception{
//        SolrDocument document = client.getById(collection, String.valueOf(id));
//        System.out.println(document);
//        return document.toString();
//    }
//
//    /**
//     * 综合查询: 在综合查询中, 有按条件查询, 条件过滤, 排序, 分页, 高亮显示, 获取部分域信息
//     * @return
//     */
//    @RequestMapping("search1")
//    public String search1(){
//        try {
//            final Map<String, String> queryParamMap = new HashMap<String, String>();
//            queryParamMap.put("q", "*:*");
//            queryParamMap.put("fl", "id");
//            queryParamMap.put("sort", "id asc");
//            MapSolrParams queryParams = new MapSolrParams(queryParamMap);
//
//            final QueryResponse response = client.query("defaultCollection", queryParams);
//            final SolrDocumentList documents = response.getResults();
//
//            System.out.println("Found " + documents.getNumFound() + " documents");
//            for(SolrDocument document : documents) {
//                final String id = (String) document.getFirstValue("id");
//                System.out.println("id: " + id);
//            }
//            return "1";
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
//        return "2";
//    }
//
//    private OcmsDemandDTO setNotNull(OcmsDemandDTO ocmsDemandDTO){
//        if(ocmsDemandDTO.getCorporateName()==null){
//            ocmsDemandDTO.setCorporateName("");
//        }
//        if(ocmsDemandDTO.getCreatedBy()==null){
//            ocmsDemandDTO.setCreatedBy(Long.valueOf(0));
//        }
//        if(ocmsDemandDTO.getCreationDate()==null){
//            ocmsDemandDTO.setCreationDate(new Date());
//        }
//        if(ocmsDemandDTO.getDemandConsultantRole()==null){
//            ocmsDemandDTO.setDemandConsultantRole(Long.valueOf(0));
//        }
//        if(ocmsDemandDTO.getDemandConsultantRoleName()==null){
//            ocmsDemandDTO.setDemandConsultantRoleName("");
//        }
//        if(ocmsDemandDTO.getDemandNo()==null){
//            ocmsDemandDTO.setDemandNo("");
//        }
//        if(ocmsDemandDTO.getEmploymentTime()==null){
//            ocmsDemandDTO.setEmploymentTime(Long.valueOf(0));
//        }
//        if(ocmsDemandDTO.getExamineId()==null){
//            ocmsDemandDTO.setExamineId(Long.valueOf(0));
//        }
//        if(ocmsDemandDTO.getExamineStatus()==null){
//            ocmsDemandDTO.setExamineStatus(0);
//        }
//        if(ocmsDemandDTO.getId()==null){
//            ocmsDemandDTO.setId("");
//        }
//        if(ocmsDemandDTO.getIsBoard()==null){
//            ocmsDemandDTO.setIsBoard(0);
//        }
//        if(ocmsDemandDTO.getKeyWord()==null){
//            ocmsDemandDTO.setKeyWord("");
//        }
//        if(ocmsDemandDTO.getLastUpdateDate()==null){
//            ocmsDemandDTO.setLastUpdateDate(new Date());
//        }
//        if(ocmsDemandDTO.getLastUpdatedBy()==null){
//            ocmsDemandDTO.setLastUpdatedBy(Long.valueOf(0));
//        }
//        if(ocmsDemandDTO.getModular()==null){
//            ocmsDemandDTO.setModular("");
//        }
//        if(ocmsDemandDTO.getObjectName()==null){
//            ocmsDemandDTO.setObjectName("");
//        }
//        if(ocmsDemandDTO.getObjectVersionNumber()==null){
//            ocmsDemandDTO.setObjectVersionNumber(Long.valueOf(0));
//        }
//        if(ocmsDemandDTO.getOcmsCompanyId()==null){
//            ocmsDemandDTO.setOcmsCompanyId(Long.valueOf(0));
//        }
//        if(ocmsDemandDTO.getOcmsObjectId()==null){
//            ocmsDemandDTO.setOcmsObjectId(Long.valueOf(0));
//        }
//        if(ocmsDemandDTO.getPrice()==null){
//            ocmsDemandDTO.setPrice(BigDecimal.valueOf(0));
//        }
//        if(ocmsDemandDTO.getPriceUnit()==null){
//            ocmsDemandDTO.setPriceUnit(Long.valueOf(0));
//        }
//        if(ocmsDemandDTO.getProcessNodeId()==null){
//            ocmsDemandDTO.setProcessNodeId(Long.valueOf(0));
//        }
//        if(ocmsDemandDTO.getRemandCycle()==null){
//            ocmsDemandDTO.setRemandCycle("");
//        }
//        if(ocmsDemandDTO.getType()==null){
//            ocmsDemandDTO.setType(Long.valueOf(0));
//        }
//        if(ocmsDemandDTO.getUserId()==null){
//            ocmsDemandDTO.setUserId(Long.valueOf(0));
//        }
//        if(ocmsDemandDTO.getWorkAddress()==null){
//            ocmsDemandDTO.setWorkAddress("");
//        }
//        if(ocmsDemandDTO.getRequirementDescription()==null){
//            ocmsDemandDTO.setRequirementDescription("");
//        }
//        return ocmsDemandDTO;
//    }
//
//    /**
//      * solr对pdf或者word索引的导入，网址：https://blog.csdn.net/zml19910925/article/details/51155265
//      * created by Antemis 上午 10:51 2018/7/24/0024
//      */
//    public static void main(String[] args) {
//        File parentFile = new File("G:/document/");
//        if (parentFile.exists()) {
//            File[] files = parentFile.listFiles();
//            if (files != null) {
//                for (File file : files) {
//                    try {
//                        indexFilesSolrCell(file.getName(), file.getPath());
//                    } catch (IOException | SolrServerException e) {
//                        e.printStackTrace();
//                    }
//                }
//            }
//        }
//    }
//
//    /**
//     * 从文件创建索引 <功能详细描述>
//     *
//     * @param fileName 文件名
//     * @param path 地址
//     * @see [类、类#方法、类#成员]
//     */
//    private static void indexFilesSolrCell(String fileName, String path)
//            throws IOException, SolrServerException {
//        //连接solr服务,solr后面跟collection名，在浏览器中地址是solr/#/,在代码中直接solr/加collection名
//        String urlString = "http://localhost:8983/solr/techproducts";
//        //对solr客户端进行一个文件的提交
//        SolrClient solr = new HttpSolrClient(urlString);
//
//        ContentStreamUpdateRequest up = new ContentStreamUpdateRequest(
//                "/update/extract");
//
//        String contentType = getFileContentType(fileName);
//        up.addFile(new File(path), contentType);
//        up.setParam("literal.id", fileName);
//        up.setParam("literal.path", path);
//        up.setParam("literal.fileName", fileName);
//        up.setParam("fmap.content", "attr_content");
//        up.setAction(AbstractUpdateRequest.ACTION.COMMIT, true, true);
//
//		/*
//		 * up.addFile(file, contenttype); up.setParam("literal.id", id);
//		 * up.setParam("literal.mytitle", mytitle);
//		 * up.setParam("literal.mytime", dataTurntoLong(savetime));
//		 * up.setParam("literal.myindextype", myindextype);
//		 * up.setParam("literal.myyears", myyears); up.setParam("fmap.content",
//		 * "content");
//		 */
//        solr.request(up);
//
//        QueryResponse rsp = solr.query(new SolrQuery("*:*"));
//
//        SolrDocumentList solrDocumentList = rsp.getResults();
//
//        ListIterator<SolrDocument> listIterator = solrDocumentList
//                .listIterator();
//        while (listIterator.hasNext()) {
//            SolrDocument solrDocument = listIterator.next();
//            System.out.println(solrDocument.getFieldValue("attr_filename"));
//        }
//
//    }
//
//    /**
//     * 根据文件名获取文件的ContentType类型
//     *
//     * @param filename 文件名
//     * @return string
//     */
//    private static String getFileContentType(String filename) {
//        String contentType = "";
//        String prefix = filename.substring(filename.lastIndexOf(".") + 1);
//        if (prefix.equals("xlsx")) {
//            contentType = "application/vnd.openxmlformats-officedocument.spreadsheetml.sheet";
//        } else if (prefix.equals("pdf")) {
//            contentType = "application/pdf";
//        } else if (prefix.equals("doc")) {
//            contentType = "application/msword";
//        } else if (prefix.equals("txt")) {
//            contentType = "text/plain";
//        } else if (prefix.equals("xls")) {
//            contentType = "application/vnd.ms-excel";
//        } else if (prefix.equals("docx")) {
//            contentType = "application/vnd.openxmlformats-officedocument.wordprocessingml.document";
//        } else if (prefix.equals("ppt")) {
//            contentType = "application/vnd.ms-powerpoint";
//        } else if (prefix.equals("pptx")) {
//            contentType = "application/vnd.openxmlformats-officedocument.presentationml.presentation";
//        }
//
//        else {
//            contentType = "othertype";
//        }
//
//        return contentType;
//    }
//}