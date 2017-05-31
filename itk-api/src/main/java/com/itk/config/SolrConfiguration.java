package com.itk.config;

import org.apache.solr.client.solrj.ResponseParser;
import org.apache.solr.client.solrj.impl.HttpSolrServer;
import org.apache.solr.client.solrj.impl.XMLResponseParser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * Created by young on 2017/5/28.
 */
@Configuration
public class SolrConfiguration {

    @Autowired
    ItkProperties itkProperties;

    @Bean
    public HttpSolrServer httpSolrServer(){
        HttpSolrServer httpSolrServer = new HttpSolrServer(itkProperties.getSolr().getUrl());
        httpSolrServer.setMaxRetries(itkProperties.getSolr().getMaxRetries());
        httpSolrServer.setConnectionTimeout(itkProperties.getSolr().getConnectionTimeout());
        ResponseParser responseParser = new XMLResponseParser();
        httpSolrServer.setParser(responseParser);
        return httpSolrServer;
    }
}
