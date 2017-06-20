package com.itk.config;

import com.itk.config.async.ExceptionHandlingAsyncTaskExecutor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.aop.interceptor.AsyncUncaughtExceptionHandler;
import org.springframework.aop.interceptor.SimpleAsyncUncaughtExceptionHandler;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.AsyncConfigurer;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.concurrent.ThreadPoolTaskExecutor;

import java.util.concurrent.Executor;

@Configuration
@EnableAsync
@EnableScheduling
public class AsyncConfiguration implements AsyncConfigurer {

    private final Logger log = LoggerFactory.getLogger(AsyncConfiguration.class);

    @Value("${itk.async.asyncCorePoolSize:}")
    private Integer asyncCorePoolSize;

    @Value("${itk.async.asyncMaxPoolSize:}")
    private Integer asyncMaxPoolSize;

    @Value("${itk.async.queueCapacity:}")
    private Integer queueCapacity;

    @Override
    @Bean(name = "taskExecutor")
    public Executor getAsyncExecutor() {
        log.debug("Creating Async Task Executor");
        ThreadPoolTaskExecutor executor = new ThreadPoolTaskExecutor();
        if (asyncCorePoolSize != null) {
            executor.setCorePoolSize(asyncCorePoolSize);
        }
        if (asyncMaxPoolSize != null) {
            executor.setMaxPoolSize(asyncMaxPoolSize);
        }
        if (queueCapacity != null) {
            executor.setQueueCapacity(queueCapacity);
        }
        executor.setThreadNamePrefix("itk-Executor-");
        return new ExceptionHandlingAsyncTaskExecutor(executor);
    }

    @Override
    public AsyncUncaughtExceptionHandler getAsyncUncaughtExceptionHandler() {
        return new SimpleAsyncUncaughtExceptionHandler();
    }
}
