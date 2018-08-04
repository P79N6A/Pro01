package com.czhand.ocms.search;

import io.choerodon.resource.annoation.EnableChoerodonResourceServer;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.netflix.feign.EnableFeignClients;
import org.springframework.scheduling.annotation.EnableScheduling;


@SpringBootApplication
@EnableScheduling
@EnableFeignClients
@EnableEurekaClient
@EnableChoerodonResourceServer
public class SearchServiceApplication {

    public static void main(String[] args){
        SpringApplication.run(SearchServiceApplication.class, args);
    }

}

