package com.itk.config;

import org.apache.solr.client.solrj.SolrClient;
import org.apache.solr.client.solrj.impl.HttpSolrClient;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.solr.core.SolrTemplate;
import org.springframework.data.solr.repository.config.EnableSolrRepositories;

/**
 * Created by young on 2017/5/28.
 */
@Configuration
@EnableSolrRepositories(basePackages = "com.itk.solr.repository")
public class SolrConfiguration {

    @Value("${itk.solr.url:}")
    private String solrUrl;

    @Value("${itk.solr.connectionTimeout:}")
    private Integer timeOut;

    @Bean
    public SolrClient solrClient() {
        HttpSolrClient solrClient = new HttpSolrClient(solrUrl);
        solrClient.setConnectionTimeout(timeOut);
        return solrClient;
    }

    @Bean
    public SolrTemplate solrTemplate() {
        return new SolrTemplate(solrClient());
    }
}
