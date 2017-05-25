package com.itk.config;

import com.baomidou.mybatisplus.MybatisConfiguration;
import com.baomidou.mybatisplus.MybatisXMLLanguageDriver;
import com.baomidou.mybatisplus.entity.GlobalConfiguration;
import com.baomidou.mybatisplus.enums.DBType;
import com.baomidou.mybatisplus.plugins.PaginationInterceptor;
import com.baomidou.mybatisplus.spring.MybatisSqlSessionFactoryBean;
import org.apache.ibatis.mapping.DatabaseIdProvider;
import org.apache.ibatis.plugin.Interceptor;
import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.annotation.MapperScan;
import org.mybatis.spring.boot.autoconfigure.MybatisProperties;
import org.mybatis.spring.boot.autoconfigure.SpringBootVFS;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.core.io.DefaultResourceLoader;
import org.springframework.core.io.ResourceLoader;
import org.springframework.core.io.support.PathMatchingResourcePatternResolver;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.util.ObjectUtils;
import org.springframework.util.StringUtils;

import javax.sql.DataSource;

/**
 * Created by enchen on 5/17/17.
 */
@Configuration
@EnableTransactionManagement
public class DatabaseConfig {

    @Bean
    @ConfigurationProperties(prefix="spring.datasource")
    public DataSource dataSource() {
        return new com.alibaba.druid.pool.DruidDataSource();
    }

    @Configuration
    @MapperScan(sqlSessionFactoryRef = "mybatisSqlSessionFactory",
        basePackages = {"com.itk.*.mapper"})
    public class mybatisConfig {
        @Bean(name = "mybatisSqlSessionFactory")
        public SqlSessionFactory sqlSessionFactoryBean() throws Exception {

            SqlSessionFactoryBean sqlSessionFactoryBean = new SqlSessionFactoryBean();
            sqlSessionFactoryBean.setDataSource(dataSource());

            PathMatchingResourcePatternResolver resolver = new PathMatchingResourcePatternResolver();

            sqlSessionFactoryBean.setMapperLocations(resolver.getResources("classpath:/mapper/*/*.xml"));

            return sqlSessionFactoryBean.getObject();
        }
    }

    @Configuration
    @MapperScan(sqlSessionFactoryRef = "mybaitsPlusSqlSessionFactory",
        basePackages = {"com.itk.mybatis.plus.dao"},
        annotationClass = MybatisPlusDatasource.class)
    public class mybatisPlusConfig {

        @Autowired
        private MybatisProperties properties;
        @Autowired
        private ResourceLoader resourceLoader = new DefaultResourceLoader();
        @Autowired(required = false)
        private Interceptor[] interceptors;
        @Autowired(required = false)
        private DatabaseIdProvider databaseIdProvider;

        @Bean(name = "mybaitsPlusSqlSessionFactory")
        @Primary
        public MybatisSqlSessionFactoryBean mybatisSqlSessionFactoryBean(DataSource dataSource) {
            MybatisSqlSessionFactoryBean mybatisSqlSessionFactoryBean = new MybatisSqlSessionFactoryBean();
            mybatisSqlSessionFactoryBean.setDataSource(dataSource);
            mybatisSqlSessionFactoryBean.setVfs(SpringBootVFS.class);
            if (StringUtils.hasText(this.properties.getConfigLocation())) {
                mybatisSqlSessionFactoryBean.setConfigLocation(this.resourceLoader.getResource(this.properties.getConfigLocation()));
            }
            mybatisSqlSessionFactoryBean.setConfiguration(properties.getConfiguration());
            if (!ObjectUtils.isEmpty(this.interceptors)) {
                mybatisSqlSessionFactoryBean.setPlugins(this.interceptors);
            }
            GlobalConfiguration globalConfig = new GlobalConfiguration();
            globalConfig.setDbType(DBType.MYSQL.name());
            globalConfig.setIdType(2);
            globalConfig.setDbColumnUnderline(true);
            mybatisSqlSessionFactoryBean.setGlobalConfig(globalConfig);
            MybatisConfiguration mybatisConfiguration = new MybatisConfiguration();
            mybatisConfiguration.setDefaultScriptingLanguage(MybatisXMLLanguageDriver.class);
            mybatisSqlSessionFactoryBean.setConfiguration(mybatisConfiguration);
            if (this.databaseIdProvider != null) {
                mybatisSqlSessionFactoryBean.setDatabaseIdProvider(this.databaseIdProvider);
            }
            if (StringUtils.hasLength(this.properties.getTypeAliasesPackage())) {
                mybatisSqlSessionFactoryBean.setTypeAliasesPackage(this.properties.getTypeAliasesPackage());
            }
            if (StringUtils.hasLength(this.properties.getTypeHandlersPackage())) {
                mybatisSqlSessionFactoryBean.setTypeHandlersPackage(this.properties.getTypeHandlersPackage());
            }
            if (!ObjectUtils.isEmpty(this.properties.resolveMapperLocations())) {
                mybatisSqlSessionFactoryBean.setMapperLocations(this.properties.resolveMapperLocations());
            }
            return mybatisSqlSessionFactoryBean;
        }
    }


    /**

     *	 mybatis-plus分页插件

     */
    @Bean
    public PaginationInterceptor paginationInterceptor() {
        PaginationInterceptor page = new PaginationInterceptor();
        page.setDialectType("mysql");
        return page;
    }

    public @interface MybatisPlusDatasource {
    }
}
