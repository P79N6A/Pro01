package com.czhand.ocms.search.infra.config;

/*
 * @description:
 * @program: search-engine
 * @author: syun
 * @create: 2018-07-31 15:44
 */

import org.apache.solr.client.solrj.impl.ZkClientClusterStateProvider;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ZkClientClusterStateProviderConfig {


    @Value("${spring.data.solr.zk-host}")
    private String zkhost;


    @Bean
    public ZkClientClusterStateProvider getZkClientClusterStateProvider(){

        return new ZkClientClusterStateProvider(zkhost);
    }

}
