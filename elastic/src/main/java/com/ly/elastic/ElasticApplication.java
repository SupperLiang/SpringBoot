package com.ly.elastic;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * SpringBoot默认支持两种技术
 * 1、Jest（默认不生效）
 * 需要导入Jest的工具包（io.searchbox.client.JestClient;）
 * 2、SpringData ElasticSearch
 * 1）、TransportClient 节点信息clusterName clusterNodes
 * 2）、ElasticsearchTemplate
 * 3）、编写一个ElasticsearchRepository的子接口操作ES
 */
@SpringBootApplication
public class ElasticApplication {

    public static void main(String[] args) {
        SpringApplication.run(ElasticApplication.class, args);
    }
}
