package com.qingcheng.service.factory;

import org.apache.http.HttpHost;
import org.elasticsearch.client.RestClient;
import org.elasticsearch.client.RestClientBuilder;
import org.elasticsearch.client.RestHighLevelClient;

/**
 * @Author 86186
 * @Date 2019/10/19 2:14
 */
public class RestClientFactory {

    public static RestHighLevelClient getRestHighLevelClient(String hostName, int port){
        HttpHost http = new HttpHost(hostName, port, "http");
        RestClientBuilder builder = RestClient.builder(http);
        return new RestHighLevelClient(builder);
    }
}
