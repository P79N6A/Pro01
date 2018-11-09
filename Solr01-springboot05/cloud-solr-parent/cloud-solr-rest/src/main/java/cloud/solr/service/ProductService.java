package cloud.solr.service;//package cloud.solr.service;
//
//import cloud.solr.domain.Product;
//import cloud.solr.repository.ProductRepository;
//import org.apache.commons.lang3.StringUtils;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.data.domain.Page;
//import org.springframework.data.domain.Pageable;
//import org.springframework.stereotype.Service;
//
//import java.util.ArrayList;
//import java.util.List;
//
///**
// * Created by chenyu on 2017/5/25.
// */
//@Service
//public class ProductService {
//    @Autowired
//    ProductRepository productRepository;
//
//    public List<Product> findByName(String name){
//        if(StringUtils.isEmpty(name)){
//            return new ArrayList<>();
//        }
//        return productRepository.findByName(name);
//    }
//    public void save(Product product){
//        if(product != null) {
//            productRepository.save(product);
//        }
//    }
//
//    public Page<Product> query(String queryString, Pageable pageable) throws Exception {
//        return productRepository.findByNameContaining(queryString, pageable);
//    }
//
//}
